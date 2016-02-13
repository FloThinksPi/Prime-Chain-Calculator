import java.util.List;

/**
 * Created by flo on 11.02.16.
 */
public class Application {

    public static byte[] TestData = {1, 8, 5, 9, 3};

    public static void main(String[] args) {

        PrimeChecker primeChecker = new PrimeChecker("Primes2.db", true);
        Config.instance.primeChecker = primeChecker;


        System.out.println("Search for Dulicate Primes");
        long time = System.nanoTime();

        List<Long> resultList;

        new PrimeGeneratorThread(2);
        new PrimeGeneratorThread(118593);
        new PrimeGeneratorThread(1185593);
        new PrimeGeneratorThread(185593);
        new PrimeGeneratorThread(11855593);

        System.out.println("Searched Duplicate Primes in " + (System.nanoTime() - time) / 10000000d + "S/100");

    }


}
