package chapter02;

import io.reactivex.Observable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Order {
    private String str;

    public Order(String str) {
        this.str = str;
    }

    public String getId() {
        return this.str;
    }
}

public class fromIterable {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Jerry");
        names.add("William");
        names.add("Bob");

        Observable<String> source = Observable.fromIterable(names);
        source.subscribe(System.out::println);

        Set<String> cities = new HashSet<>();
        cities.add("Seoul");
        cities.add("London");
        cities.add("Paris");

        Observable.fromIterable(cities).subscribe(System.out::println);

        BlockingQueue<Order> orderQueue = new ArrayBlockingQueue<>(100);
        orderQueue.add(new Order("ORD-1"));
        orderQueue.add(new Order("ORD-2"));
        orderQueue.add(new Order("ORD-3"));

        Observable.fromIterable(orderQueue).subscribe(order -> System.out.println(order.getId()));
    }
}
