package io.github.tivecs.thinmail.api.usecase;

import io.github.tivecs.thinmail.model.Mail;
import io.github.tivecs.thinmail.repository.mail.IMailRepository;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SendMailUseCase {

    private final IMailRepository mailRepository;

    private final Player sender;

    private final String subject, body, receiverName;

    public SendMailUseCase(@NotNull IMailRepository mailRepository, @NotNull Player sender, @NotNull String subject, @NotNull String body, @NotNull String receiverName) {
        this.mailRepository = mailRepository;
        this.sender = sender;
        this.subject = subject;
        this.body = body;
        this.receiverName = receiverName;
    }

    @SuppressWarnings("deprecation")
    public void execute() {
        OfflinePlayer receiver = Bukkit.getOfflinePlayer(receiverName);

        if (!receiver.isOnline() && !receiver.hasPlayedBefore()){
            sender.sendMessage("Player not found");
            return;
        }

        Mail mail = new Mail(sender.getUniqueId().toString(), receiver.getUniqueId().toString(), subject, body);

        mailRepository.createMail(mail);

        sender.sendMessage("Mail sent to " + receiver.getName());

        if (receiver.isOnline()){
            Objects.requireNonNull(receiver.getPlayer()).sendMessage("You have new mail");
        }
    }

}
