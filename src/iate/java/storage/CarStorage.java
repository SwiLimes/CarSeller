package iate.java.storage;

import iate.api.CarDao;
import iate.api.CarDaoImpl;
import iate.java.model.Car;

import java.util.HashMap;
import java.util.Map;

public class CarStorage  implements Storage<Car>{

    private static Map<String,Car> cars = new HashMap<>();
    private static final CarDao DAO = new CarDaoImpl();
    
    @Override
    public void add(Car car) {

    }

    @Override
    public void delete(String str) {

    }

    @Override
    public Car get(String str) {
        return null;
    }
}
