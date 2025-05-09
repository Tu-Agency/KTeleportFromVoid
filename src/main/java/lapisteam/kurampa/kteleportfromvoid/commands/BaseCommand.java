package lapisteam.kurampa.kteleportfromvoid.commands;

import lapisteam.kurampa.kteleportfromvoid.Main;
import lapisteam.kurampa.kteleportfromvoid.configs.MainConfig;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public abstract class BaseCommand implements CommandExecutor, TabCompleter {
    protected final Main plugin;
    protected final MainConfig cfg;

    public BaseCommand(Main plugin) {
        this.plugin = plugin;
        this.cfg = plugin.getProjectManager().getMainConfig();
    }

    protected boolean hasPermission(CommandSender sender, String CommandName) {
        return sender.hasPermission(cfg.getCommandData(CommandName, "hasPermission"));
    }

    protected void sendNoPermission(CommandSender sender) {
        sender.sendMessage(cfg.getMessage("noPermission"));
    }

    public abstract boolean handle(CommandSender sender, String[] args);
}