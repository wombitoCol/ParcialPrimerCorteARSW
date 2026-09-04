package edu.eci.arsw.math;

import sun.jvm.hotspot.runtime.Threads;

public class PiThreads extends Thread {

    private int startThread;
    private int count;
    private byte[] digits;


    public PiThreads(int startThread, int count){
        this.startThread = startThread;
        this.count = count;
    }

    @Override
    public void run(){
        this.digits = PiDigits.getDigits(this.startThread, this.count);
    }

    public byte[] getDigits(){
        return this.digits;
    }

}
