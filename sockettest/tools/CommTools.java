package sockettest.tools;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class CommTools {
    private static final String host="localhost";
    private static final int port=8080;

    public static int comm(ByteBuffer snd, ByteBuffer rcv) {
        if (snd == null || rcv == null) {
            System.out.println("参数不能为null");
            return -1;
        }
        Selector selector = null;
        final var channel = SocketConnPool.getChannel(host, port);
        if (channel != null) {
            selector = channel.getSelector();
            if(selector == null) {
                System.out.println("getSelector failure");
                return -1;
            }
        } else {
            System.out.println("getChannel failure");
            return -1;
        }

        while (true) {
            try {
                // 发送报文
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey selectionKey : selectionKeys) {
                    if (selectionKey.isConnectable() || selectionKey.isWritable() ) {
                        SocketChannel sndChannel = (SocketChannel) selectionKey.channel();
                        if (sndChannel.isConnectionPending()) {
                            sndChannel.finishConnect();
                        }

                        snd.flip();
                        sndChannel.write(snd);
                        sndChannel.register(selector, SelectionKey.OP_READ);

                    }  else if(selectionKey.isReadable()) {
                        rcv.clear();
                        StringBuffer sb = new StringBuffer("receive msg: ");
                        SocketChannel rcvChannel = (SocketChannel) selectionKey.channel();
                        while (rcvChannel.read(rcv) > 0) {
                            rcv.flip();
                            sb.append(new String(rcv.array(), 0, rcv.limit()));
                        }

                        System.out.println(sb.toString());
                        rcvChannel.register(selector, SelectionKey.OP_WRITE);
                        SocketConnPool.putChannel(channel);
                        return 0;
                    } else {
                        System.out.println("通信失败");
                        return -1;
                    }
                }
                selectionKeys.clear();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
