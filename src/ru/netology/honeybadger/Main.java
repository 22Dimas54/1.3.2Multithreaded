package ru.netology.honeybadger;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> listShop1 = Arrays.asList(100, 200, 300);
        List<Integer> listShop2 = Arrays.asList(400, 500, 600);
        List<Integer> listShop3 = Arrays.asList(700, 800, 900);

        Shop shop = new Shop();

        Thread threadShop1 = new Thread(null, () -> shop.sumRevenue(listShop1));
        Thread threadShop2 = new Thread(null, () -> shop.sumRevenue(listShop2));
        Thread threadShop3 = new Thread(null, () -> shop.sumRevenue(listShop3));

        threadShop1.start();
        threadShop2.start();
        threadShop3.start();

        threadShop1.join();
        threadShop2.join();
        threadShop3.join();

        System.out.println("Выручка составила:"+shop.getRevenue());

        threadShop1.interrupt();
        threadShop2.interrupt();
        threadShop3.interrupt();
    }
}
