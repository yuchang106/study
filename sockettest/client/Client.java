package sockettest.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.Set;

public class Client {
    private String address;
    private int port;
    private Selector selector;

    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    private Scanner scanner = new Scanner(System.in);


    public Client(String address, int port) throws IOException {
        this.address = address;
        this.port = port;
        this.selector = Selector.open();
    }

    public void connectToServer() {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress(address, port));


            connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connect() {
        while (true) {
            try {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey key : selectionKeys) {
                    if (key.isConnectable()) {
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        if (clientChannel.isConnectionPending()) {
                            clientChannel.finishConnect();
                            System.out.println("client connect success...");
                        }

                        clientChannel.register(selector, SelectionKey.OP_WRITE);
                    } else if (key.isReadable()) {
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        StringBuffer sb = new StringBuffer("receive msg: ");

                        readBuffer.clear();
                        while (clientChannel.read(readBuffer) > 0) {
                            readBuffer.flip();
                            sb.append(new String(readBuffer.array(), 0, readBuffer.limit()));
                        }

                        System.out.println(sb.toString());
                        clientChannel.register(selector, SelectionKey.OP_WRITE);
                    } else if (key.isWritable()) {
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        String msg = scanner.nextLine();
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

    public static void main(String[] args) {
        String address = "localhost";
        int port = 8080;

        try {
            new Client(address, port).connectToServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
