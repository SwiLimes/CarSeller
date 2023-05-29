package iate.java.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class DBConfig {

    private static final Path DB_PROPS = Paths.get("config/db.properties");
    private static final DBConfig INSTANCE = new DBConfig();
    private final Properties props = new Properties();

    public static DBConfig get() {
        return INSTANCE;
    }
    private DBConfig() {
        try (InputStream in = Files.newInputStream(DB_PROPS)) {
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException("file not found" + DB_PROPS.toAbsolutePath(), e);
        }
    }

    public String getDbUrl() {
        return props.getProperty("db.url");
    }

    public String getDbUser() {
        return props.getProperty("db.username");
    }

    public String getDbPass() {
        return props.getProperty("db.password");
    }
}