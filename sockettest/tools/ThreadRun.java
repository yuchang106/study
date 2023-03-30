package sockettest.tools;

import java.nio.ByteBuffer;

public class ThreadRun implements Runnable{
    @Override
    public void run() {
        ByteBuffer sndBuf = ByteBuffer.allocate(1024);
        ByteBuffer rcvBuf = ByteBuffer.allocate(1024);
        sndBuf.put("hello".getBytes());

        if ( ( CommTools.comm(sndBuf, rcvBuf) < 0 ) ) {
            System.out.println("交易失败");
        }
    }
}
