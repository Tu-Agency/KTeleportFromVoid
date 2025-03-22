package lapisteam.kurampa.kteleportfromvoid.commands;

import lapisteam.kurampa.kteleportfromvoid.Main;
import lapisteam.kurampa.kteleportfromvoid.utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Objects;

public class ReloadCommand implements CommandExecutor {

    private final Main plugin;

    public ReloadCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("kteleportfromvoid") && args.length > 0 && args[0].equalsIgnoreCase("reload")) {
            FileConfiguration config = getFileConfig();
            if (sender.hasPermission(Objects.requireNonNull(config.getString("PermissionPluginReload")))) {
                plugin.reloadPluginConfig();
                sender.sendMessage(ColorUtils.applyColors(config.getString("Messages.reload_success")));
                return true;
            } else {
                sender.sendMessage(ColorUtils.applyColors(config.getString("Messages.noPermission")));
                return true;
            }
        }
        return false;
    }

    private FileConfiguration getFileConfig() {
        FileConfiguration config = plugin.getConfig();
        return config;
    }
}
