package iate.java.storage;

import iate.api.ModelDao;
import iate.java.dao.ModelDaoImpl;

import java.util.List;

public class ModelStorage {
    private static final ModelDao DAO = new ModelDaoImpl();

    public List<String> getAllBrands() { // получение всех машин
        return DAO.getAllBrands();
    }

    public List<String> getModelsByBrand(String brand) {
        return  DAO.getAllModels(brand);
    }
}
