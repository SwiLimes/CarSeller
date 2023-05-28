package iate.api;

import iate.java.model.Car;
import iate.java.model.Filter;

import java.util.List;

public interface CarDao {

    void addCar(Car car);

    void updateCar(Car car);

    void deleteCarByVin(String vin);

    Car getCarByVin(String vin);

    List<Car> getAllCars();

    List<Car> getCarsByFilter(Filter filter);
}