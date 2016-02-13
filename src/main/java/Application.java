import java.util.concurrent.*;

/**
 * Created by flo on 11.02.16.
 */
public class Application {


    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    public static void main(String[] args) throws InterruptedException {

        new PrimeLoader("Primes.db");
        Config.instance.outCoordinator = new OutputCoordinator();


        System.out.println("Search for Dulicate Primes");
        Config.instance.timeStamp = System.nanoTime();

        long i = 0;
        int threadCount = Runtime.getRuntime().availableProcessors()*2;
        ExecutorService es = Executors.newFixedThreadPool(threadCount);
        System.out.println("You have " + Runtime.getRuntime().availableProcessors() + " Cores -> Using " + threadCount + " Threads\n");
        int calcArea=Config.instance.stopChainSearch;
        while (i < threadCount) {

            es.execute(new PrimeChainFinderThread(calcArea/threadCount*i,calcArea/threadCount*(i+1)));

            i++;
        }

        es.shutdown();

        es.awaitTermination(365, TimeUnit.DAYS);

        Config.instance.outCoordinator.printResult();


    }


}
