package io.github.tivecs.thinmail.api.database;

import io.github.tivecs.thinmail.ThinMail;
import io.github.tivecs.thinmail.config.ThinMailConfig;
import io.github.tivecs.thinmail.config.database.DatabaseType;
import io.github.tivecs.thinmail.database.DatabaseConnector;
import io.github.tivecs.thinmail.database.SqliteConnector;
import io.github.tivecs.thinmail.repository.RepositoryManager;

import java.io.File;
import java.sql.SQLException;

public class ThinMailDatabase {

    private RepositoryManager repositoryManager;

    private DatabaseConnector connector;


    public ThinMailDatabase(ThinMail plugin){
        connectToDatabase(plugin);
    }

    private void connectToDatabase(ThinMail plugin) {
        ThinMailConfig environment = ThinMailConfig.getInstance();

        switch (environment.getDatabaseType()) {
            case SQLITE:
                File sqliteFile = new File(plugin.getDataFolder(), environment.getSqliteConfig().getPath());
                this.connector = new SqliteConnector(sqliteFile);
                break;
            case MYSQL:
                throw new UnsupportedOperationException("MySQL is not supported yet");
        }

        this.repositoryManager = new RepositoryManager(connector, environment.getDatabaseType());
    }

    public RepositoryManager getRepositoryManager() {
        return repositoryManager;
    }

    public DatabaseConnector getConnector() {
        return connector;
    }
}
