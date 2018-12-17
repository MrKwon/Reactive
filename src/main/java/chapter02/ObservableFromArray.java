package chapter02;

import io.reactivex.Observable;

import java.util.stream.IntStream;

public class ObservableFromArray {
    public static Integer[] toIntegerArray(int[] intArray) {
        return IntStream.of(intArray).boxed().toArray(Integer[]::new);
    }

    public static void main(String[] args) {
        Integer[] arr = {100, 200, 300};
        Observable<Integer> source = Observable.fromArray(arr);
        source.subscribe(System.out::println);

        int[] intArray = {400, 500, 600};
        Observable.fromArray(intArray).subscribe(System.out::println); // RxJava에서 int 배열을 인식하지 못함

        // int 배열을 명시적 래퍼 타입의 배열로 바꿔줘야 함 - toIntegerArray() 메서드 사용
        Observable<Integer> source02 = Observable.fromArray(toIntegerArray(intArray));
        source02.subscribe(System.out::println);

    }
}