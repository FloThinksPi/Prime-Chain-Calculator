import java.util.Collections;
import java.util.List;

/**
 * Created by flo on 11.02.16.
 */
public class PrimeGeneratorThread extends Thread {

    private long number;

    public void run() {
        List<Long> resultList;
        resultList = PrimeGenerator.byDuplication(Utils.longToBytes(number));
        Collections.reverse(resultList);
        System.out.println(resultList);
    }

    public PrimeGeneratorThread(long number) {
        this.number = number;
        this.start();
    }

}