package iate.java.storage;

import iate.java.model.Car;

import java.util.List;

public interface Storage <T> {
    void add(T t);

    void delete(String str);

   // List<Car> getAllCar();

    T get(String str);

    List<Car> get();
}
