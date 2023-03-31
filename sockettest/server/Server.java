package sockettest.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class Server {

    private final String address;
    private final int port;
    private final Selector selector;

    private final ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private final ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    //private Scanner scanner = new Scanner(System.in);

    public Server(String address, int port) throws IOException {
        this.address = address;
        this.port = port;
        this.selector = Selector.open();
    }

    public void startServer() {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = serverSocketChannel.socket();

            serverSocket.bind(new InetSocketAddress(address, port));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("nio server start...");
        } catch (IOException e) {
            System.out.println("nio server start error...");
            e.printStackTrace();
        }

        // 监听连接
        acceptClient();
    }

    public static void main(String[] args) {
        String address = "localhost";
        int port = 8080;

        try {
            new Server(address, port).startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void acceptClient() {
        while (true) {
            try {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                for (SelectionKey key : selectionKeys) {
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();

                        SocketChannel clientChannel = server.accept();
                        clientChannel.configureBlocking(false);
                        clientChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println("client connect...");
                    } else if (key.isReadable()) {
                        System.out.println("开始接收...");
                        SocketChannel clientChannel = (SocketChannel) key.channel();

                        readBuffer.clear();
                        StringBuffer sb = new StringBuffer("receive msg: ");
                        try {
                            while (clientChannel.read(readBuffer) > 0) {
                                readBuffer.flip();
                                sb.append(new String(readBuffer.array(), 0, readBuffer.limit()));
                            }
                        } catch (IOException e) {
                            clientChannel.close();
                            continue;
                        }

                        System.out.println(sb);
                        clientChannel.register(selector, SelectionKey.OP_WRITE);

                        String msg = "hello";
                        writeBuffer.clear();
                        writeBuffer.put(msg.getBytes());
                        writeBuffer.flip();

                        clientChannel.write(writeBuffer);
                        clientChannel.register(selector, SelectionKey.OP_READ);
                    }
                }

                selectionKeys.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
