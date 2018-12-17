package chapter02;

import io.reactivex.Observable;

public class FirstExample {
    public void emit01() {
        Observable.just("Hello", "RxJava 2!!")
                .subscribe(System.out::println);
    }

    public void emit02() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .subscribe(System.out::println);
    }

    public static void main(String[] args) {
        FirstExample demo = new FirstExample();
        demo.emit01();
        demo.emit02();
    }
}
