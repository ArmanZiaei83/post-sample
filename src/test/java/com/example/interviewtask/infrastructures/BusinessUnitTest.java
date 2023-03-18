package com.example.interviewtask.infrastructures;

import org.junit.runner.RunWith;

import java.util.Random;

public class BusinessUnitTest {
    public int randomInt() {
        return new Random().nextInt();
    }

    public long randomLong() {
        return new Random().nextLong();
    }
}
