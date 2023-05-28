package iate.java.dao;

import iate.api.ModelDao;
import iate.java.sql.SqlHelper;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ModelDaoImpl implements ModelDao {

    private final SqlHelper sqlHelper;
//    private static final DBConfig dbConfig = DBConfig.get();

    public ModelDaoImpl() {
        this("jdbc:postgresql://localhost:5432/carseller","postgres", "postgres");
    }

    public ModelDaoImpl(String dbName, String dbUser, String dbPass) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        sqlHelper = new SqlHelper(() -> DriverManager.getConnection(dbName, dbUser, dbPass));
    }


    @Override
    public List<String> getAllBrands() {
        return sqlHelper.execute("Select DISTINCT brand_name FROM brand",ps ->{
            List<String> brands = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                brands.add(rs.getString("brand_name"));
            }
            return brands;
        });
    }

    @Override
    public List<String> getAllModels(String brand) {
        return sqlHelper.execute("Select * FROM brand WHERE brand_name = ?;",ps ->{
            ps.setString(1,brand);
            List<String> brands = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                brands.add(rs.getString("model_name"));
            }
            return brands;
        });
    }
}
