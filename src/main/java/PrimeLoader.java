import org.nustaq.serialization.FSTConfiguration;
import org.nustaq.serialization.FSTObjectInput;
import org.nustaq.serialization.FSTObjectOutput;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashSet;

public class PrimeLoader {


    static FSTConfiguration conf = FSTConfiguration.createFastBinaryConfiguration();
    private String pathToDB = "";
    HashSet<Integer> Primes = new HashSet<>();


    private void calcPrimesUnder(int maximumValue) {

        boolean[] prime = new boolean[maximumValue];

        for (int n = 2; n < maximumValue; n++) {
            prime[n] = true;
        }
        long ii;


        for (int i = 2; i < maximumValue; i++) {
            if (prime[i]) {

                Primes.add(i);
                ii = (long) i;
                for (int x = i; x * ii < maximumValue; x++)
                    prime[x * i] = false;
            }
        }

    }


    public PrimeLoader(String pathToDB) {

        this.pathToDB = pathToDB;
        long time;

        conf.setCrossPlatform(false);
        conf.setForceSerializable(true);
        conf.setPreferSpeed(true);
        conf.setStructMode(true);


        //Read From File
        try {
            time = System.nanoTime();
            System.out.println("Reading Prime Numbers Database");

            Primes.clear();

            FileInputStream f = new FileInputStream(pathToDB);
            BufferedInputStream b = new BufferedInputStream(f,100000000);
            FSTObjectInput in = new FSTObjectInput(b);
            Primes = (HashSet<Integer>) in.readObject();
            in.close();

            System.out.println("Loaded " + Primes.size() + " Primes from Database in " + (System.nanoTime() - time) / 1000000000d + " Seconds\n");


        }catch (FileNotFoundException e){
            System.out.println("No Prime Database Found!\n");
            System.out.println("Generating Primes");
            time = System.nanoTime();
            calcPrimesUnder(Config.instance.maxPrimeNumber);

            System.out.println("Calculated " + Primes.size() + " Primes in " + (System.nanoTime() - time) / 1000000000d + " Seconds\n");

            // Write to File
            System.out.println("Writing to File");
            time = System.nanoTime();

            try {

                FileOutputStream out = new FileOutputStream(pathToDB);
                FSTObjectOutput sout = new FSTObjectOutput(out);
                sout.writeObject( Primes );
                sout.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            System.out.println("Wrote " + Primes.size() + " Primes to File in " + (System.nanoTime() - time) / 1000000000d + " Seconds\n");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        Config.instance.Primes=this.Primes;

    }


}

