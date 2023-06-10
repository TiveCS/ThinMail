package io.github.tivecs.thinmail;

import io.github.tivecs.thinmail.cmds.ThinMailCmd;
import io.github.tivecs.thinmail.config.ThinMailConfig;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class ThinMail extends JavaPlugin {


    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();

        ThinMailConfig.getInstance().load(this);

        loadCommands();

        new ThinMailApi(this);
    }

    private void loadCommands() {
        PluginCommand thinMailCmd = this.getCommand("thinmail");

        if (thinMailCmd != null) thinMailCmd.setExecutor(new ThinMailCmd());
    }

    @Override
    public void onDisable() {

    }
}
