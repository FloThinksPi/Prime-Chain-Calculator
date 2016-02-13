import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by flo on 11.02.16.
 */
public class PrimeGenerator {

    public static List<Long> byDuplication(byte[] number) {

        List<Long> resultList=new ArrayList<Long>();
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

            //Convert ByteArray to Long TODO Make Faster , Make Bigger
            long l = Utils.bytesToLong(newNumber);
            //System.out.println(l);


            boolean isPrime=Config.instance.primeChecker.check(l);

            //System.out.println(isPrime);

            List<Long> tempResultList=new ArrayList<Long>();
            if(isPrime){
                tempResultList=PrimeGenerator.byDuplication(newNumber);
                tempResultList.add(l);
            }

            //Bestes Ergebniss Finden und zur rückgabe speichern
            if(tempResultList.size()>resultList.size()){
                resultList=tempResultList;
            }

        }

        return resultList;

    }


}
