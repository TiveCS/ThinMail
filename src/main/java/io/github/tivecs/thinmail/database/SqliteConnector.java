package io.github.tivecs.thinmail.database;

import org.bukkit.Bukkit;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqliteConnector implements DatabaseConnector {

    private Connection connection;

    private final File databaseFile;

    public SqliteConnector(File dbFile) {
        this.databaseFile = dbFile;
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (connection != null && !connection.isClosed()){
            return connection;
        }

        createDatabaseFile();
        connect();
        return connection;
    }

    private void createDatabaseFile() {
        if (!databaseFile.exists()) {
            try {
                databaseFile.getParentFile().mkdir();
                databaseFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFile.getPath());

            Bukkit.getLogger().info("[ThinMail] (SQLite) Connected to database: " + databaseFile.getPath());
        } catch (SQLException | ClassNotFoundException e) {
            Bukkit.getLogger().severe("[ThinMail] (SQLite) Failed to connect database: " + databaseFile.getPath());
            e.printStackTrace();
        }
    }

    public File getDatabaseFile() {
        return databaseFile;
    }
}
