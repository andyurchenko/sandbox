package academy.tochkavhoda.functional;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Functional {
    public static <F, T> T useFunctionFor(F str, Function<F, T> o) {
        return o.apply(str);
    }

    public static <F, T, R> Function<F, R> splitAndCountFunctionThen(Function<F, T> f1, Function<T, R> f2) {
        return f1.andThen(f2);
    }

    public static <F, T, R> Function<F, R> splitAndCountFunctionCompose(Function<F, T> f1, Function<T, R> f2) {
        return f2.compose(f1);
    }

    public static <T> T create(Supplier<T> supplier) {
        return supplier.get();
    }

    public static <F, R> R createWithArg(F arg, Function<F, R> function) {
        return function.apply(arg);
    }

    public static IntStream transformSequential(IntStream stream, IntUnaryOperator op) {
        return stream.map(op);
    }

    public static IntStream transformParallel(IntStream stream, IntUnaryOperator op) {
        return stream.parallel().map(op);
    }

    public void tasks() {
//1. Используя функциональный интерфейс java.util.function.Function и лямбда-выражения, создайте:
//
//функцию split (String s) -> List<String>, разбивающую строку по пробелам
//функцию count (List<?> list) -> Integer, считающую количество элементов в любом списке
//2. Примените split к строке, содержащей пробелы, а после этого примените count к ее результату.
        String strToSplit = "A B C D";
        List<String> resultStringList;

        resultStringList = useFunctionFor(
                strToSplit,
                (String str) -> Arrays.stream(str.split(" ")).toList()
        );
        resultStringList.forEach(System.out::println);


//3. Попробуйте избавиться от декларации типов в параметрах функций из пункта 1. Почему это возможно?
        resultStringList = useFunctionFor(
                strToSplit,
                (str) -> Arrays.stream(str.split(" ")).toList()
        );
        resultStringList.forEach(System.out::println);

//4. Попробуйте заменить лямбда-выражение на method reference, в каких случаях это возможно и почему?
        int listSize = useFunctionFor(resultStringList, List::size);
        System.out.println("List size = " + listSize);


//5. Перепишите решение из п. 1, композируя функции split и count при помощи default-методов
// интерфейса Function в новую функцию splitAndCount:
//используйте andThen
//используйте compose
//Чем данный подход отличается от count.apply(split.apply(str))?
        Function<String, Integer> splitAndCount = splitAndCountFunctionThen(
                (String str) -> Arrays.stream(str.split(" ")).toList(),
                List::size
        );

        listSize = useFunctionFor(strToSplit, splitAndCount);
        System.out.println("List size = " + listSize);

//6. Напишите функцию create, принимающую в качестве аргумента строку и возвращающую Person с именем, равным переданной строке.
// Перепишите при помощи method reference.
        final String personName = "Vasya";
        Person personVasya = create(
                () -> new Person(personName)
        );
        System.out.println(personVasya);

        Person personPetya = createWithArg(
                "Petya",
                (name) -> new Person(name)
        );
        System.out.println(personPetya);

        personPetya = createWithArg(
                "PETYA",
                Person::new
        );
        System.out.println(personPetya);

//7. Реализуйте функцию max, используя method reference к Math.max. Какой интерфейс из java.util.function подойдет для функции
// с двумя параметрами?
        BiFunction<Double, Double, Double> max = Math::max;

//8. Реализуйте функцию getCurrentDate, возвращающую текущую дату () -> java.util.Date. Какой интерфейс из java.util.function
// подойдет для функции без параметров?
        Supplier<Date> getCurrentDate = Date::new;
        System.out.println("Current date = " + getCurrentDate.get());

//9. Реализуйте функцию isEven (Integer a) -> Boolean. Какой интерфейс из java.util.function для этого подойдет?
        Predicate<Integer> isEven = (a) -> a % 2 == 0;

//10. Реализуйте функцию areEqual (Integer a, Integer b) -> Boolean. Какой интерфейс из java.util.function для этого подойдет?
        BiPredicate<Integer, Integer> areEqual = Objects::equals;

//11. Создайте интерфейс MyFunction, декларирующий единственный метод K apply(T arg).
//Замените Function на MyFunction Предположим, вы решили использовать функцию с двумя аргументами.
//Что произойдет, когда вы добавите K apply(T arg1, T arg2)?
//Задекларируйте MyFunction как функциональный интерфейс. Попробуйте скомпилировать.



//13. Напишите метод IntStream transform(IntStream stream, IntUnaryOperator op),
// трансформирующий каждый элемент при помощи операции op. Выведите результат на консоль.
        int[] intArray = new int[100];
        for (int i = 0; i < 100; i++) {
            intArray[i] = i + 1;
        }
        IntStream intStream = transformSequential(IntStream.of(intArray), (x) -> x * x);
        intStream.forEach(System.out::println);


//14.Задача аналогичная предыдущей, только теперь нужно трансформировать входящий Stream в параллельный,
// обратите внимание на изменившийся вывод на консоль.
        intStream = transformParallel(IntStream.of(intArray), (x) -> x * x);
        intStream.forEach(System.out::println);

//15. Реализуйте класс Person(String name, int age). Имея список List<Person>, при помощи Stream API необходимо вернуть
// уникальные имена для всех людей старше 30 лет, отсортированные по длине имени.
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("A", 10));
        persons.add(new Person("B", 20));
        persons.add(new Person("C", 30));
        persons.add(new Person("AAA", 40));
        persons.add(new Person("AAA", 50));
        persons.add(new Person("BB", 60));
        persons.add(new Person("C", 70));
        persons.add(new Person("DDDDD", 80));
        persons.add(new Person("DDDDD", 90));
        persons.add(new Person("DDDDD", 90));
        persons.add(new Person("EEEE", 100));
        persons.stream()
                .filter(person -> person.getAge() > 30)
                .distinct()
                .sorted(Comparator.comparingInt(Person::getAge))
                .forEach(System.out::println);

//16. Имея список List<Person>, при помощи Stream API необходимо вернуть уникальные имена для всех людей старше 30 лет,
// отсортированные по количеству людей с одинаковым именем. Используйте Collectors.groupingBy
        System.out.println("==================================================================================");
        Map<String, List<Person>> uniqueNames = persons.stream()
                .collect(Collectors.groupingBy(Person::getName));
//        uniqueNames.entrySet().forEach(System.out::println);
        uniqueNames.values().stream().sorted(Comparator.comparingInt((Collection<Person> a) -> a.size())).forEach(System.out::println);
        uniqueNames.values().stream()
                .sorted(Comparator.comparingInt((Collection<Person> a) -> a.size()))
                .map((Collection<Person> collection) -> ((List<Person>) collection).get(0).getName())
                .forEach(System.out::println);
        System.out.println("==================================================================================");
//17. Реализуйте sum(List<Integer> list) (сумма элементов списка) и product(List<Integer> list) (их произведение) через Stream.reduce
        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(10);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        Optional<Integer> result = integerList.stream().reduce(Integer::sum);
        result.ifPresent(sum -> System.out.println(" List<Integer> integerList sum = " + sum));
        System.out.println("integerList.stream() result = " + integerList.stream().reduce(1, (a, b) -> a * b));

    }
}
