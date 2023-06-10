package io.github.tivecs.thinmail.config.database;

public class ThinMailSqliteConfig {

    private final String path;

    public ThinMailSqliteConfig(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
