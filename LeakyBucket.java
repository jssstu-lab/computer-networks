// Computer Network Laboratory - CS58L
// 5th Sem 2020-21
// https://github.com/jssstu-lab/computer-networks

// Write a program for congestion control using leaky bucket algorithm.

import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int capacity = sc.nextInt();
        int inflow = sc.nextInt();
        int outflow = sc.nextInt();
        int n = sc.nextInt();

        sc.close();

        int filled = 0;

        while (n != 0 ) {
            if (inflow <= (capacity-filled)) {
                filled += inflow;
            }
            else {
                System.out.println((inflow - capacity + filled) + " packets overflowed and discard.");
                filled = capacity;
            }
            filled -= outflow;
            n--;
            System.out.println(filled + " out of " + capacity + " packets remaining in bucket.");
            try {
                Thread.sleep(2000);
            }
            catch (Exception e) {
                continue;
            }
        }
    }
}
