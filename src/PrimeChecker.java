import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;

public class PrimeChecker {

    private String pathToDB = "";
    Set<Integer> Primes = new HashSet<>();


    private Set<Integer> calcPrimesUnder(int maximumValue) {
        Set<Integer> primes = new HashSet<>();
        boolean[] prime = new boolean[maximumValue];

        for (int n = 2; n < maximumValue; n++) {
            prime[n] = true;
        }
        long ii;
        long bla = 0;
        //161S
        for (int i = 2; i < maximumValue; i++) {
            if (prime[i]) {
                if (bla % 100000 == 0) System.out.println(Math.round(((double) i / (double) maximumValue) * 100) + "%");
                bla++;
                primes.add(i);
                ii = (long) i;
                for (int x = i; x * ii < maximumValue; x++)
                    prime[x * i] = false;
            }
        }

        return primes;
    }


    public PrimeChecker(String pathToDB, boolean generatePrimes) {

        this.pathToDB = pathToDB;
        long time;
        if (generatePrimes) {


            System.out.println("Generating Primes");
            time = System.nanoTime();
            Primes = calcPrimesUnder(Config.instance.maxPrimeNumber);

            System.out.println("Calculated " + Primes.size() + " Primes in " + (System.nanoTime() - time) / 1000000000 + "S");

// Write to File
//            System.out.println("Writing to File");
//            time = System.nanoTime();
//
//            try {
//                RandomAccessFile out = new RandomAccessFile(pathToDB, "rw");
//                FileChannel file = out.getChannel();
//                ByteBuffer buf = file.map(FileChannel.MapMode.READ_WRITE, 0, 4 * primeList.size());
//
//                primeList.forEach(buf::putInt);
//
//                file.close();
//                System.out.println("Done");
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//
//            System.out.println("Wrote " + primeList.size() + " Primes in " + (System.nanoTime() - time) / 1000000000 + "S");

        }
//        Read From File
//        try {
//            time = System.nanoTime();
//            System.out.println("Reading Prime Numebr Database");
//
//            List<Integer> tempPrimeList = Collections.synchronizedList(new ArrayList());
//
//            FileInputStream f = new FileInputStream(pathToDB);
//            FileChannel ch = f.getChannel();
//            ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES * 1000);
//            int noOfBytesRead = ch.read(buffer);
//
//            while (noOfBytesRead != -1) {
//
//                buffer.flip();
//
//                while (buffer.hasRemaining()) {
//                    tempPrimeList.add(buffer.getInt());
//                }
//
//                buffer.clear();
//                noOfBytesRead = ch.read(buffer);
//            }
//
//            ch.close();
//            f.close();
//
//            System.out.println("Done");
//            System.out.println("Read Primes : " + tempPrimeList.size() + " in " + (System.nanoTime() - time) / 1000000000 + "S");
//
//            System.out.println("Calculating Hashmap");
//            time = System.nanoTime();
//            Primes = tempPrimeList;
//            System.out.println("Mapped Primes : " + tempPrimeList.size() + " in " + (System.nanoTime() - time) / 1000000000 + "S");
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }


    }

    public boolean check(long number) {
        if (number > Config.instance.maxPrimeNumber) return false;
        else if (Primes.contains((int) number)) return true;
        return false;
    }



}

