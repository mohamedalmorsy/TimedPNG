package virgil;
import java.util.*;

public class Stress {
    public static void main(String[] args) throws InterruptedException {
        String function = args[0];

        if (function.equalsIgnoreCase("sieve")) {
            int seconds                      = Integer.parseInt(args[1]);
            Sieve primeNumberGeneratorThread = new  Sieve();
            primeNumberGeneratorThread.start();  
            Thread.sleep(seconds * 1000);
            primeNumberGeneratorThread.running=false;
            System.out.println("The maximum prime number found in " + seconds + " seconds = " + primeNumberGeneratorThread.getMaxPrime());
            System.exit(0);
        }
    }
}