// Computer Network Laboratory - CS58L
// 5th Sem 2020-21
// https://github.com/jssstu-lab/computer-networks

// Java program for error detecting code using CRC-CCITT (16- bits).

import java.util.Scanner;

public class CRC16CCITT {
    public static void main(String[] args) {
        int crc = 0xFFFF;
        int polynomial = 0x1021;

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        sc.close();

        byte[] bytes = s.getBytes();

        for (byte b: bytes) {
            for (int i = 0; i < 8; i++) {
                boolean bit = ((b >> (7-i) & 1) == 1);
                boolean c15 = ((crc >> 15 & 1) == 1);
                crc <<= 1;
                if (c15 ^ bit) {
                    crc ^= polynomial;
                }
            }
        }

        crc &= 0xffff;
        System.out.println("CRC16-CCITT = " + Integer.toHexString(crc));
    }
}
