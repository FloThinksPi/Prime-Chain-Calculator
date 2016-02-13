import java.nio.ByteBuffer;

/**
 * Created by flo on 11.02.16.
 */

class BufferThread extends Thread {
    public BufferThread(String str, ByteBuffer buffer) {
        super(str);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + getName());
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
        System.out.println("DONE! " + getName());
    }
}


