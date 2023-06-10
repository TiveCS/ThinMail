package io.github.tivecs.thinmail.api.usecase;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import io.github.tivecs.thinmail.ThinMail;
import io.github.tivecs.thinmail.database.DatabaseConnector;
import io.github.tivecs.thinmail.repository.mail.IMailRepository;
import io.github.tivecs.thinmail.repository.mail.MailRepositorySqlite;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SendMailUseCaseTest {

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

    @Test
    public void testExecute_WhenReceiverNotFound() {
        // Arrange
        PlayerMock sender = server.addPlayer();
        String subject = "subject";
        String body = "body";
        String receiverName = "entity404";
        IMailRepository mailRepository = mock(IMailRepository.class);

        SendMailUseCase sendMailUseCase = new SendMailUseCase(mailRepository, sender, subject, body, receiverName);

        // Action
        sendMailUseCase.execute();

        // Assert
        sender.assertSaid("Player not found");
    }

    @Test
    public void testExecute_WhenPayloadIsValid() {
        // Arrange
        PlayerMock sender = server.addPlayer();
        PlayerMock receiver = server.addPlayer("Adam");
        String subject = "subject";
        String body = "body";
        IMailRepository mailRepository = mock(IMailRepository.class);

        SendMailUseCase sendMailUseCase = new SendMailUseCase(mailRepository, sender, subject, body, receiver.getName());

        // Action
        sendMailUseCase.execute();

        // Assert
        sender.assertSaid("Mail sent to " + receiver.getName());
    }



}

