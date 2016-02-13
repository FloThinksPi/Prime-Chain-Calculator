import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Florian on 13.02.2016.
 */
public class OutputCoordinator {


    List<Long> resultChain = new ArrayList<>();


    public void printResult() {
        int SearchCount = Config.instance.stopChainSearch - Config.instance.startChainSearch;
        Collections.reverse(resultChain);
        System.out.println("Searched " + SearchCount + " Numbers for PrimeChains in " + (System.nanoTime() - Config.instance.timeStamp) / 1000000000d + " Seconds");
        System.out.println("Longest Primechain = " + resultChain);
    }


    public void registerResults(ArrayList<Long> newResultChain) {
        if (newResultChain.size() > resultChain.size()) {
            resultChain = newResultChain;
        }
    }

}
