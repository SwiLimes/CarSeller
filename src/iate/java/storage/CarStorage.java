package iate.java.storage;

import iate.api.CarDao;
import iate.java.dao.CarDaoImpl;
import iate.java.model.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarStorage {

    private static final Map<String, Car> cars = new HashMap<>();
    private static final CarDao DAO = new CarDaoImpl();


    public List<Car> getAllCars() { // получение всех машин
        return DAO.getAllCars();
    }

    public List<Car> getCarByFilter() {
        return DAO.getAllCars();
    }

    public Car getCarByVin(String vin) {
        return DAO.getCarByVin(vin);
    }


}
