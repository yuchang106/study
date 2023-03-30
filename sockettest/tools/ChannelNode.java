package sockettest.tools;

import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class ChannelNode {
    private SocketChannel socketChannel;
    private Selector selector;
    private String address;
    private int port;

    public ChannelNode() {
    }
    public ChannelNode(SocketChannel socketChannel, Selector selector, String address, int port) {
        this.socketChannel = socketChannel;
        this.selector = selector;
        this.address = address;
        this.port = port;
    }

    public SocketChannel getSocketChannel() {
        return socketChannel;
    }

    public void setSocketChannel(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    public Selector getSelector() {
        return selector;
    }

    public void setSelector(Selector selector) {
        this.selector = selector;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
