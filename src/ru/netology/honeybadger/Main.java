package ru.netology.honeybadger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static final int COUNT_SHOPS = 3;
    private static final int DIGIT_CAPACITY = 1000;

    public static void main(String[] args) throws InterruptedException {
        Shop shop = new Shop();
        addTasksInExecutorService(shop);
        executorService.awaitTermination(COUNT_SHOPS, TimeUnit.SECONDS);
        System.out.println("Выручка составила:" + shop.getRevenue());
        executorService.shutdown();
    }

    private static void addTasksInExecutorService(Shop shop) {
        for (int i = 0; i < COUNT_SHOPS; i++) {
            executorService.submit(new Thread(null, () -> shop.sumRevenue(createListInteger())));
        }
    }

    private static List<Integer> createListInteger() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < COUNT_SHOPS; i++) {
            list.add((int) (Math.random() * DIGIT_CAPACITY));
        }
        return list;
    }
}
