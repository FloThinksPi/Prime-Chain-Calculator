import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by flo on 11.02.16.
 */

public enum Config {
    instance;

    Set<Integer> Primes = new HashSet<>();
    long timeStamp;

    //Primes des vollen Int Raumes benutzen Kann hier verkleinert werden(Prime.db löschen damit primzahlen neu generiert werden)
    //int maxPrimeNumber=(Integer.MAX_VALUE)/2; //Hälfte an Integer Prüfen
    int maxPrimeNumber = (Integer.MAX_VALUE - 2); //Alle Integer Prüfen (-2 um int überlauf abzusichern)


    //findet die längste primkette zwischen den beiden werten.
    final int startChainSearch = 0;
    final int stopChainSearch = maxPrimeNumber;

    //Instanzen
    OutputCoordinator outCoordinator;

}
