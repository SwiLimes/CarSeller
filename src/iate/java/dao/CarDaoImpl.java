package iate.java.dao;

import iate.api.CarDao;
import iate.java.model.Car;
import iate.java.model.Filter;
import iate.java.sql.SqlHelper;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {

    private final SqlHelper sqlHelper;
//    private static final DBConfig dbConfig = DBConfig.get();

    public CarDaoImpl() {
        this("jdbc:postgresql://localhost:5432/carseller","postgres", "postgres");
    }

    public CarDaoImpl(String dbName, String dbUser, String dbPass) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        sqlHelper = new SqlHelper(() -> DriverManager.getConnection(dbName, dbUser, dbPass));
    }

    @Override
    public void addCar(Car car) {
        sqlHelper.execute("INSERT INTO car(vin, brand_name, model_name, car_year)" +
//                "car_type, equipment, engine_id, car_shape, drive_unit, transmission_id, consumption, clearance)" +
                "VALUES (?, ?, ?, ?);", ps -> {
            ps.setString(1, car.getVin());
            ps.setString(2, car.getBrandName());
            ps.setString(3, car.getModelName());
            ps.setString(4, car.getYear());
//            ps.setString(5, car.getType().name());
//            ps.setString(6, car.getEngine().getId());
//            insertEngine(car.getEngine());
//            ps.setString(7, car.getShape().name());
//            ps.setString(8, car.getDriveUnit().name());
//            ps.setString(9, car.getTransmission().name());
//            ps.setString(10, car.getEquipment());
//            ps.setDouble(11, car.getConsumption());
//            ps.setDouble(12, car.getClearance());
//            initCreateUpdateStatement(car, ps);
//            ps.execute();
            return null;
        });
    }

//    private void insertEngine(Engine engine) {
//        sqlHelper.execute("INSERT INTO engine(engine_type, capacity, power, fuel_type) ")
//    }

    @Override
    public void updateCar(Car car) {
        sqlHelper.execute("UPDATE car SET brand_name = ?, model_name = ?, car_year = ? WHERE vin = ?;"
//                ", car_type = ?," + "engine_id = ?, car_shape = ?, drive_unit = ?, transmission_id = ?, equipment = ?, consumption = ?, clearance = ?;"
                , ps -> {
            ps.setString(1, car.getBrandName());
            ps.setString(2, car.getModelName());
            ps.setString(3, car.getYear());
            ps.setString(4, car.getVin());
            ps.execute();
            return null;
        });
    }

    @Override
    public void deleteCarByVin(String vin) {
        sqlHelper.execute("DELETE FROM car WHERE vin = ?;", ps -> {
            ps.setString(1, vin);
            ps.execute();
            return null;
        });
    }

    @Override
    public Car getCarByVin(String vin) {
        return sqlHelper.execute("SELECT * FROM car WHERE vin = ?;", ps -> {
            ps.setString(1, vin);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                throw new RuntimeException();
            }
            return initCar(rs);
        });
    }

    @Override
    public List<Car> getAllCars() {
        return sqlHelper.execute("SELECT * FROM car;", ps -> {
            List<Car> cars = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cars.add(initCar(rs));
            }
            return cars;
        });
    }

    @Override
    public List<Car> getCarsByFilter(Filter filter) {
        return null;
    }

    private void initCreateUpdateStatement(Car car, PreparedStatement ps) throws SQLException {
        ps.setString(1, car.getBrandName());
        ps.setString(2, car.getModelName());
        ps.setString(3, car.getYear());
//        ps.setString(5, car.getType().name());
//        ps.setString(6, car.getEquipment());
//        ps.setString(7, car.getEngine().name());
//        ps.setString(8, car.get);
//        ps.setString(9, car.getDriveUnit().name());
//        ps.setString(10, car.getTransmission().name());
//        ps.setString(11, car.geCl

    }
    private Car initCar(ResultSet rs) throws SQLException {
        String vin = rs.getString("vin");
        String brandName = rs.getString("brand_name");
        String modelName = rs.getString("model_name");
        String year = rs.getString("car_year");
//        CarType type = CarType.valueOf(rs.getString("car_type"));
//        Engine engine = initEngine(rs.getInt("engine_id"));
//        CarShape shape = CarShape.valueOf(rs.getString("car_shape"));
//        DriveUnit driveUnit = DriveUnit.valueOf(rs.getString("drive_unit"));
//        Transmission transmission = Transmission.valueOf(rs.getString("transmission"));
//        String equipment = rs.getString("equipment");
//        double consumption = rs.getDouble("consumption");
//        double clearance = rs.getDouble("clearance");

        return new Car(vin, brandName, modelName, year);
//                type, engine, shape, driveUnit, transmission, equipment, consumption, clearance);
    }

//    private Engine initEngine(int engineId) {
//        return sqlHelper.execute("SELECT * FROM engine WHERE id = ?;", ps -> {
//            ps.setInt(1, engineId);
//            ResultSet rs = ps.executeQuery();
//            if (!rs.next()) {
//                throw new RuntimeException("");
//            }
//            return new Engine(EngineType.valueOf(rs.getString("engine_type")),
//                    rs.getDouble("capacity"),
//                    rs.getInt("power"),
//                    rs.getString("fuel_type"));
//        });
//    }
}