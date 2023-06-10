package io.github.tivecs.thinmail.repository.mail;

import io.github.tivecs.thinmail.model.Mail;

import java.sql.SQLException;
import java.util.Set;

public interface IMailRepository {

    void createTable();

    Long createMail(Mail mail);

    Mail findMailById(Long id);

    void deleteMailById(Long id);

    Set<Mail> findMailsByPlayerId(String playerId);
}
