package P11.full_credit;

import P11.full_credit.qlogger.Qlogger;

public class ListPrimes {
    public static void main(String[] args) {
        Qlogger.enabled = true;
        Primes primes = new Primes();
        long begin = Long.parseLong(args[1].replaceAll("_", ""));
        long end = Long.parseLong(args[2].replaceAll("_", ""));
        int numThreads = Integer.parseInt(args[3].replaceAll("_", ""));

        primes.search(begin, end, numThreads);
        Qlogger.log(primes.toString());
    }
}
