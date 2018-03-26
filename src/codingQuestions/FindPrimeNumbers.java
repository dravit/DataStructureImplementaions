package codingQuestions;

//Find all the prime numbers less than or equal to a given number n
//Using Sieve of Eratosthenes

/**
 * Create a list of consecutive integers from 2 to n: (2, 3, 4, …, n).
 * Initially, let p equal 2, the first prime number.
 * Starting from p, count up in increments of p and mark each of these numbers greater than p itself in the list.
 * These numbers will be 2p, 3p, 4p, etc.; note that some of them may have already been marked.
 * Find the first number greater than p in the list that is not marked.
 * If there was no such number, stop. Otherwise, let p now equal this number (which is the next prime),
 * and repeat from step 3.
 */

/**
 * Steps:
 * 1.   create an array of boolean of length n+1 and mark all of them as true.
 * 2.   Consider first p as 2 and run a loop having condition as p*p <= n and increment as p++
 * 3.   in this loop check if the boolean array has true on this index.
 * 4.   If it is true thn run another loop that starts counter from i=2*p, condition i<=n and increment it by i+=p
 * 5.   Mark all such values are false.
 * 6.   Print left out true from boolean array.
 */
public class FindPrimeNumbers {

    /**
     * Step 1 : Create a boolean array of size n + 1 and put true in all indexes
     * @param n
     */
    private void findPrimeNumbers(int n) {
        boolean prime[] = new boolean[n+1];
        for(int i=0; i<=n; i++) {
            prime[i] = true;
        }
        for(int p=2; p*p <=n; p++) {
            if(prime[p]) {
                for(int i=2*p; i<=n; i+= p) {
                    prime[i] = false;
                }
            }
        }

        for(int i=2; i<=n; i++) {
            if(prime[i]) {
                System.out.println(i+"");
            }
        }
    }

    public static void main(String[] args) {
        new FindPrimeNumbers().findPrimeNumbers(5);
    }
}
