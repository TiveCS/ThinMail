package io.github.tivecs.thinmail.cmds;

import io.github.tivecs.thinmail.ThinMailApi;
import io.github.tivecs.thinmail.api.usecase.SendMailUseCase;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ThinMailCmd implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (command.getName().equalsIgnoreCase("thinmail")) {
            if (args.length == 0) {
                sender.sendMessage("/thinmail help");
                sender.sendMessage("/thinmail send <player> <subject> <body>");
                return true;
            }
            if (args.length == 4) {
                if (args[0].equalsIgnoreCase("send")) {
                    String receiverName = args[1];
                    String subject = args[2];
                    String body = args[3];

                    new SendMailUseCase(
                            ThinMailApi.getInstance().getDatabase().getRepositoryManager().getMailRepository(),
                            (Player) sender,
                            subject,
                            body,
                            receiverName
                    ).execute();


                    return true;
                }
            }
        }

        return false;
    }
}
