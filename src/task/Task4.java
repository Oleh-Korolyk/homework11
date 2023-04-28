package task;


import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {

    private long a, b, c, m;

    public Task4(long a, long c, long m) {
        this.a = a;
        this.c = c;
        this.m = m;
    }

//        public void setB(long b) {
//        this.b = b;
//    }

    public Task4 b(long b) {
        this.b = b;
        return this;
    }

    public long next() {
        return  (b * a + c) % m;
    }

    public static void main(String[] args) {
        Task4 algorithm = new Task4(25214903917l, 11l, (long) Math.pow(2, 48));

//        algorithm.setB(7);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(algorithm.next());
//            algorithm.setB(algorithm.next());
//        }

        Stream<Long> generator = Stream.iterate(7l, (seed) -> algorithm.b(seed).next());
        generator
                .limit(11)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
