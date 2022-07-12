package ru.netology.honeybadger;

import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class Shop {

    private LongAdder longAdder = new LongAdder();

    public void sumRevenue(List<Integer> list) {
        for (Integer integer : list) {
            longAdder.add(integer);
        }
    }

    public long getRevenue() {
        return longAdder.sum();
    }
}
