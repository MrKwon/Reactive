package chapter02;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.functions.Consumer;

public class ObservableCreateExample {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.create(
                (ObservableEmitter<Integer> emitter) -> {
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                    emitter.onComplete();
        });

        source.subscribe(System.out::println); // subscribe 가 없으면 출력이 되지 않는당

        source.subscribe(data -> System.out.println("Result : " + data)); // 이걸 줄이면 line 16

        source.subscribe(new Consumer<Integer>() { // 이걸 람다로 줄이면 line 19
            @Override
            public void accept(Integer data) throws Exception {
                System.out.println("new Result : " + data);
            }
        });
    }
}
