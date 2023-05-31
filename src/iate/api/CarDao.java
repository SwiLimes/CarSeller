package iate.api;

import iate.java.model.Car;
import iate.java.model.Filter;
import iate.java.utils.CarFilterCriterion;

import java.util.List;
import java.util.Map;

public interface CarDao {

    void addCar(Car car);

    void updateCar(Car car);

    void deleteCarByVin(String vin);

    Car getCarByVin(String vin);

    List<Car> getAllCars();

    List<Car> getCarsByFilter(Filter filter);

    List<Car> getFilteredCars(Map<CarFilterCriterion, String> params);
}