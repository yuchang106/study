package sockettest.tools;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SocketConnPool {
    private static final ConcurrentLinkedDeque<ChannelNode> channelPool = new ConcurrentLinkedDeque<>();
    public static ChannelNode getChannel(String host, int port) {
        ChannelNode channelNode = channelPool.poll();
        if( channelNode == null) {
            try {
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(false);
                Selector selector = Selector.open();
                socketChannel.register(selector, SelectionKey.OP_CONNECT);
                socketChannel.connect(new InetSocketAddress(host, port));

                return new ChannelNode(socketChannel, selector, host, port);
            } catch (IOException e) {
                System.out.println("创建socket通道失败");
                return null;
            }
        }
        return channelNode;
    }

    public static boolean putChannel(ChannelNode channelNode) {
        return channelPool.offer(channelNode);
    }

    public static int getChannelPoolSize() {
        return channelPool.size();
    }
}
