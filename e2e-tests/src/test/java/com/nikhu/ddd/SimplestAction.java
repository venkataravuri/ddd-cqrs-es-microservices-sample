package com.nikhu.ddd;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by vravuri on 11-Jul-17.
 */
public class SimplestAction {
    public void nothing() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1, 2));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}