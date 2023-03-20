package com.example.interviewtask.infrastructures;

import java.util.Random;
import java.util.UUID;

public class BusinessUnitTest {
    public int randomInt() {
        return new Random().nextInt();
    }

    public String randomString() {
        return UUID.randomUUID()
                .toString();
    }
}
