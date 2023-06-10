package io.github.tivecs.thinmail.config;

import io.github.tivecs.thinmail.ThinMail;
import io.github.tivecs.thinmail.config.database.DatabaseType;
import io.github.tivecs.thinmail.config.database.ThinMailMysqlConfig;
import io.github.tivecs.thinmail.config.database.ThinMailSqliteConfig;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Locale;
import java.util.Objects;

public class ThinMailConfig {

    private static ThinMailConfig instance = null;

    private FileConfiguration configuration;

    // Database Config
    private DatabaseType databaseType;
    private ThinMailSqliteConfig sqliteConfig = null;
    private ThinMailMysqlConfig mysqlConfig = null;

    public static ThinMailConfig getInstance() {
        if (instance == null){
            instance = new ThinMailConfig();
        }
        return instance;
    }

    private ThinMailConfig() { }

    public void load(ThinMail plugin) {
        this.configuration = plugin.getConfig();

        loadDatabaseConfig();
    }

    private void loadDatabaseConfig() {
        String databaseTypeString = Objects.requireNonNull(configuration.getString("database.type")).toUpperCase(Locale.ROOT);
        databaseType = DatabaseType.valueOf(databaseTypeString);

        switch (databaseType) {
            case SQLITE: sqliteConfig = new ThinMailSqliteConfig(configuration.getString("database.sqlite.path"));
                break;
            case MYSQL:
                mysqlConfig = new ThinMailMysqlConfig(
                    configuration.getString("database.mysql.host"),
                    configuration.getInt("database.mysql.port"),
                    configuration.getString("database.mysql.database"),
                    configuration.getString("database.mysql.username"),
                    configuration.getString("database.mysql.password")
                );
                break;
        }
    }

    public DatabaseType getDatabaseType() {
        return databaseType;
    }

    public ThinMailSqliteConfig getSqliteConfig() {
        return sqliteConfig;
    }

    public ThinMailMysqlConfig getMysqlConfig() {
        return mysqlConfig;
    }
}
