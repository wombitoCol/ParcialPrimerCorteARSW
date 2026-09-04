/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.math;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void main(String a[]) throws InterruptedException {
        int numberOfDigits = 1_000;
        int numberOfThreads = 4;
        int range = numberOfDigits / numberOfThreads;
        ArrayList<PiThreads> threads = new ArrayList<PiThreads>();
        for (int i = 0; i < numberOfThreads ; i++ ){
            int startNumber = i * numberOfDigits;
            threads.add(new PiThreads(startNumber, range));
        }

        for (int i = 0; i < numberOfThreads ; i++){
            threads.get(i).start();
        }

        for(PiThreads t : threads){
            t.join();
        }

        for (int i = 0; i < numberOfThreads ; i++){
            System.out.println(bytesToHex(threads.get(i).getDigits()));
        }
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<hexChars.length;i=i+2){
            //sb.append(hexChars[i]);
            sb.append(hexChars[i+1]);            
        }
        return sb.toString();
    }

}
