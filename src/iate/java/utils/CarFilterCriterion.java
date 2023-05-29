package iate.java.utils;

public enum CarFilterCriterion {
    VIN("vin"),
    BRAND("brand_name"),
    MODEL("model_name"),
    YEAR("car_year");

    private final String sqlName;

    CarFilterCriterion(String sqlName) {
        this.sqlName = sqlName;
    }

    public String getSqlName() {
        return sqlName;
    }
}