package academy.tochkavhoda.functional;

@FunctionalInterface
public interface MyFunction<K, T> {
    K apply(T arg);
}
