package virgil;

public class Sieve extends Thread {
    boolean running = true;
    int maxPrime = 1;
    public int calculatePrimeCount(int N) {
        // initially assume all integers are prime
        boolean[] isPrime = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= N using Sieve of Eratosthenes
        for (int i = 2; i*i <= N; i++) {

            // if i is prime, then mark multiples of i as nonprime
            // suffices to consider mutiples i, i+1, ..., N/i
            if (isPrime[i]) {
                for (int j = i; i*j <= N; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

        // count primes
        int primes = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) primes++;
        }

        return primes;
    }
    
    //this code is copied from http://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
    private boolean isPrime(int n)
    {
        //check if n is a multiple of 2
        if (n%2 == 0) return false;
    
        //if not, then just check the odds
        for(int i=3; i*i<=n; i+=2) {
            if(n%i == 0)
                return false;
        }
        return true;
    }
    
    public void run()
    {
        int i = 1;
        try
        {
            while(running) {
                i++;
                if(isPrime(i))
                    maxPrime = i;
                
            }
        }
        catch (Exception e)  {}
    }
    
    public int getMaxPrime()
    {
        return maxPrime;
    }
}