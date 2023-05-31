package iate.java.utils;

public enum CarFilterCriterion {
    VIN("vin"),
    BRAND("brand_name"),
    MODEL("model_name"),
    YEAR_FROM("year_from"),
    YEAR_TO("year_to");

    private final String sqlName;

    CarFilterCriterion(String sqlName) {
        this.sqlName = sqlName;
    }

    public String getSqlName() {
        return sqlName;
    }
}