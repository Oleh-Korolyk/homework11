package task;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task123 {

    private List<String> names;
    private int i = 0;

// task 1
    public String oddNames(List<String> names) {
        String lineNames = names.stream()
                .map(n -> String.valueOf(i++) + ". " + n)
                .filter(n -> Integer.parseInt (n.substring(0, n.indexOf("."))) % 2 != 0)
                .collect(Collectors.joining(", ", "", "."));
        return lineNames;
    }

// task 2
    public List<String> listNames(List<String> names) {
        List<String> nm = names.stream()
                .map(n -> n.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return nm;
    }


    public static void main(String[] args) {

        Task123 task = new Task123();

        List<String> names = List.of("Roman", "Ivan", "Stepan", "Anna", "Petro", "Mariya", "Vira", "Nadiya", "Pavlo", "Mykola", "Andriy", "Kateryna");
        String[] numbers = {"1, 2, 0", "4, 5"};

// task 1
        System.out.println(task.oddNames(names));
// task 2
        System.out.println(task.listNames(names));

// task 3
        List<Integer> ln = Arrays.asList(numbers).stream()
                .map(n -> n.split(", "))
                .flatMap(Arrays::stream)
                .map(n -> Integer.parseInt(n))
                .sorted()
                .peek(n -> System.out.print(n + ", "))
                .collect(Collectors.toList());
    }
}
