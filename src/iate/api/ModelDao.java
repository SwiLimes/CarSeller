package iate.api;

import java.util.List;

public interface ModelDao {
    List<String> getAllBrands();

    List<String> getAllModels(String brand);
}
