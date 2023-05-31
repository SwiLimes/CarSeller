package iate.java.utils;

import java.util.Map;
import java.util.stream.Collectors;

public class QueryUtils {
    public QueryUtils() {
    }

    /**
     * Построение запроса
     *
     * @param searchQuery запрос в бд
     * @param params      параметры для поиска
     */
    public static String buildCarFilterQuery(String searchQuery, Map<CarFilterCriterion, String> params) {
        return searchQuery + params.entrySet().stream()
                .filter(entry -> !entry.getValue().isEmpty())
                .map(entry ->
                        switch (entry.getKey()) {
                            case YEAR_FROM -> String.format("car_year >= %d", Integer.parseInt(entry.getValue()));
                            case YEAR_TO -> String.format("car_year <= %d", Integer.parseInt(entry.getValue()));
                            default -> String.format("%s = '%s'", entry.getKey().getSqlName(), entry.getValue());
                        }
                )
                .collect(Collectors.joining(" AND ")) + ";";
    }
}
