package io.github.tivecs.thinmail.repository;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import io.github.tivecs.thinmail.ThinMail;
import io.github.tivecs.thinmail.config.database.DatabaseType;
import io.github.tivecs.thinmail.database.DatabaseConnector;
import io.github.tivecs.thinmail.repository.mail.IMailRepository;
import io.github.tivecs.thinmail.repository.mail.MailRepositorySqlite;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RepositoryManagerTest {

    private ServerMock server;
    private ThinMail plugin;

    @BeforeEach
    public void setUp() {
        server = MockBukkit.mock();
        plugin = MockBukkit.load(ThinMail.class);
    }

    @AfterEach
    public void tearDown() {
        MockBukkit.unmock();
    }
}

