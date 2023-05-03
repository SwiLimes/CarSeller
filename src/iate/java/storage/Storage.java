package iate.java.storage;

public interface Storage <T> {
    void add(T t);

    void delete(String str);

    T get(String str);
}
