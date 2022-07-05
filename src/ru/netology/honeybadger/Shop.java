package ru.netology.honeybadger;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Shop {

    private AtomicLong atomicLong = new AtomicLong(0);

    public void sumRevenue(List<Integer> list) {
        for (Integer integer : list) {
            atomicLong.addAndGet(integer);
        }
    }

    public long getRevenue() {
        return atomicLong.get();
    }
}
