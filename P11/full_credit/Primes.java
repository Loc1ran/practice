package P11.full_credit;

import P11.full_credit.qlogger.Qlogger;

import java.util.Map;
import java.util.TreeMap;

public class Primes {
    private long maxPrimes;
    private final Map<Long, Integer> primes;

    public Primes() {
        primes = new TreeMap<>();
    }

    public boolean isPrime(long number) {
        if (maxPrimes == 0) {
            return false;
        }

        int count = 0;

        for (long i = 2; i <= number; i++) {
            if ( number % i == 0 ) {
                count++;
            }
        }

        return count == 2;
    }

    public void search(long begin, long end, int numThreads) {
        findPrimes(begin, end, numThreads);
    }

    public int size(){
        return primes.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Long, Integer> entry : primes.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        return sb.toString();
    }

    protected void findPrimes(long begin, long end , int threadID){
        Qlogger.log("begin");
        Qlogger.log("end");

        for (long i = begin+1; i <= end; i++) {
            if (isPrime(i)) {
                addPrime(i, threadID);
            }
        }
    }

    protected void addPrime(long prime, int threadID){
        primes.put(prime, threadID);
    }


}
