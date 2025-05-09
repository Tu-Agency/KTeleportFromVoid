package lapisteam.kurampa.kteleportfromvoid.manager;

import lapisteam.kurampa.kteleportfromvoid.Main;
import lapisteam.kurampa.kteleportfromvoid.commands.handlers.*;
import lapisteam.kurampa.kteleportfromvoid.commands.listeners.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;

public class CommandsManager {

    private final Main plugin;
    private ReloadCommand_Handler reloadCommand_Handler;

    public CommandsManager(Main plugin) {
        this.plugin = plugin;
    }

    public void RegAllCommands() {
        registerCommands();
        InitCommandsHandlers();
    }

    private void InitCommandsHandlers() {
        InitCommandsEventHandlers();
        reloadCommand_Handler = new ReloadCommand_Handler(plugin); // Обработчик команды Перезагрузки конфига плагина
    }

    private void InitCommandsEventHandlers() {

    }

    private void registerCommands() {
        register("kteleportfromvoid", new ReloadCommand(plugin));
    }

    private void register(String name, CommandExecutor executor) {
        PluginCommand command = plugin.getCommand(name);
        if (command == null) {
            plugin.getLogger().warning("Команда " + name + " не найдена в plugin.yml");
            return;
        }
        command.setExecutor(executor);
        if (executor instanceof TabCompleter completer) {
            command.setTabCompleter(completer);
        }
    }

    public ReloadCommand_Handler getReloadCommand_Handler() {
        return reloadCommand_Handler;
    }
}