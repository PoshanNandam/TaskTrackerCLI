package org.example.util;

public class AutoIncrementIdGenerator {
    private static int currentId = 0;

    private AutoIncrementIdGenerator() {}

    public static synchronized int generateId() {
        return ++currentId;
    }
}
