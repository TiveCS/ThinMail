package io.github.tivecs.thinmail.repository.mail;

import io.github.tivecs.thinmail.database.DatabaseConnector;
import io.github.tivecs.thinmail.model.Mail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class MailRepositorySqlite implements IMailRepository {

    private final DatabaseConnector connector;

    public MailRepositorySqlite(DatabaseConnector connector) {
        this.connector = connector;
    }

    @Override
    public void createTable() {
        try {
            Connection connection = connector.getConnection();

            connection.createStatement().execute("CREATE TABLE IF NOT EXISTS `mails`" +
                    "(" +
                    "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    "sender_id TEXT NOT NULL," +
                    "receiver_id TEXT NOT NULL," +
                    "subject TEXT NOT NULL," +
                    "body TEXT NOT NULL," +
                    "send_at DATE NOT NULL" +
                    ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long createMail(Mail mail) {
        try {
            Connection connection = connector.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

    @Override
    public Mail findMailById(Long id) {
        return null;
    }

    @Override
    public void deleteMailById(Long id) {

    }

    @Override
    public Set<Mail> findMailsByPlayerId(String playerId) {
        return null;
    }
}
