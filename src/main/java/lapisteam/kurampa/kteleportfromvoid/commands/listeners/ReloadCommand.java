package lapisteam.kurampa.kteleportfromvoid.commands.listeners;

import lapisteam.kurampa.kteleportfromvoid.Main;
import lapisteam.kurampa.kteleportfromvoid.commands.BaseCommand;
import lapisteam.kurampa.kteleportfromvoid.manager.CommandsManager;
import lapisteam.kurampa.kteleportfromvoid.manager.ProjectManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ReloadCommand extends BaseCommand {

    private final CommandsManager commandsManager;

    public ReloadCommand(Main plugin) {
        super(plugin);
        ProjectManager projectManager = plugin.getProjectManager();
        this.commandsManager = projectManager.getCommandManager();
    }

    @Override
    public boolean handle(CommandSender sender, String[] args) {
        return false;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!hasPermission(sender, "reload")) {
            sendNoPermission(sender);
            return false;
        }
        return commandsManager.getReloadCommand_Handler().Handler(sender, args);
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            completions.add("<reload>");
        }
        return completions;
    }
}