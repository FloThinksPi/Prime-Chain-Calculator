import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by flo on 11.02.16.
 */
public class PrimeChainFinder {

    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
    }

    public static ArrayList<Long> byDuplication(byte[] number,long numberLong) {

        ArrayList<Long> resultList=new ArrayList<>();

        //Generate All Duplicates
        for (int position = 0; position < number.length;position++){

            byte[] newNumber = new byte[number.length+1];

            for (int character = 0; character < newNumber.length;character++){

                if(character<position){
                    newNumber[character]=number[character];
                }

                if(character==position){
                    newNumber[character]=number[character];
                    character++;
                    newNumber[character]=number[character-1];
                }

                if(character>position){
                    newNumber[character]=number[character-1];
                }

            }
            long l = Utils.bytesToLong(newNumber);

            boolean isPrime=Utils.primeCheck(l);

            ArrayList<Long> tempResultList=new ArrayList<Long>();
            if(isPrime){
                tempResultList= PrimeChainFinder.byDuplication(newNumber,l);
            }

            //Bestes Ergebniss aus allen Kombinationen Finden und zur rückgabe speichern
            if(tempResultList.size()>resultList.size()){
                resultList=tempResultList;
            }

        }

        //sich selbst hinzufügen da selbst Primzahl
        resultList.add(numberLong);

        return resultList;

    }


}
