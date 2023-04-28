package task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5 {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){

        ArrayList<T> result = new ArrayList<>();

        Iterator<T> iteratorFirst = first.iterator();
        Iterator<T> iteratorSecond = second.iterator();

        while (iteratorFirst.hasNext() && iteratorSecond.hasNext()) {
            result.add(iteratorFirst.next());
            result.add(iteratorSecond.next());
        }
        return result.stream();

    }

    public static void main(String[] args) {

        Stream<String> first = Stream.of("Apple", "Pear", "Orange", "Lemon", "Cherry", "Plum");
        Stream<String> second = Stream.of("Potato", "Carrot", "Tomato", "Cucumber", "Carrot");

        Stream<Integer> first1 = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Integer> second2 = Stream.of(101, 202, 303, 404, 505);


        Stream<String> resultString = zip(first, second);
        Stream<Integer> resultInt = zip(first1, second2);

        resultString
                .peek(System.out::println)
                .collect(Collectors.toList());
        resultInt
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

}
