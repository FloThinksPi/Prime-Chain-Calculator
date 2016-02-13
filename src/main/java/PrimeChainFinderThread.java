import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by flo on 11.02.16.
 */
public class PrimeChainFinderThread extends Thread {

    private long start;
    private long stop;

    public void run() {
        ArrayList<Long> resultList;
        long i;
        for (i = start; i < stop; i++) {
            if(Utils.primeCheck(i)){
                resultList = PrimeChainFinder.byDuplication(Utils.longToBytes(i), i);
                Config.instance.outCoordinator.registerResults(resultList);
            }
        }

        //System.out.println("ThreadStart="+start+" ThreadStop="+stop+" ThreadI="+i);

    }

    public PrimeChainFinderThread(long start, long stop) {
        this.start = start;
        this.stop = stop;
    }

}