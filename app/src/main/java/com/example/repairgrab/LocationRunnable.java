package com.example.repairgrab;

import android.os.SystemClock;

public class LocationRunnable  implements Runnable {
    int i=0;
    long start = SystemClock.uptimeMillis();

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    @Override
    public void run() {

    }
}
