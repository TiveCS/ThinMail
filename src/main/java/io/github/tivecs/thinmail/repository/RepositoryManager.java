package io.github.tivecs.thinmail.repository;

import io.github.tivecs.thinmail.config.database.DatabaseType;
import io.github.tivecs.thinmail.database.DatabaseConnector;
import io.github.tivecs.thinmail.repository.mail.IMailRepository;
import io.github.tivecs.thinmail.repository.mail.MailRepositorySqlite;

import java.sql.SQLException;

public class RepositoryManager {

    private IMailRepository mailRepository;

    public RepositoryManager(DatabaseConnector connector, DatabaseType databaseType) {
        loadRepository(connector, databaseType);
        initTable();
    }

    private void initTable() {
        mailRepository.createTable();
    }

    private void loadRepository(DatabaseConnector connector, DatabaseType databaseType) {
        switch (databaseType) {
            case SQLITE:
                this.mailRepository = new MailRepositorySqlite(connector);
                break;
            case MYSQL:
                throw new UnsupportedOperationException("MySQL is not supported yet");
        }
    }


    public IMailRepository getMailRepository() {
        return mailRepository;
    }
}
