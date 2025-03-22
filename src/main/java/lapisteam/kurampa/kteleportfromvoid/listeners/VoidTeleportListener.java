package lapisteam.kurampa.kteleportfromvoid.listeners;

import lapisteam.kurampa.kteleportfromvoid.Main;
import lapisteam.kurampa.kteleportfromvoid.utils.ColorUtils;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VoidTeleportListener implements Listener  {

    private final Main plugin;

    public VoidTeleportListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerFallIntoVoid(PlayerMoveEvent event) {
        FileConfiguration config = getFileConfig();

        if(!config.getBoolean("VoidTeleport_enable")) return;

        Player player = event.getPlayer();
        Location loc = player.getLocation();
        World world = loc.getWorld();

        if (loc.getY() < -64) {
            if(config.getBoolean("GiveFallingEffect")) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 60, 1, false, false));
            }

            Location spawnLocation = world.getSpawnLocation();
            spawnLocation.setY(world.getHighestBlockYAt(spawnLocation) + 1);

            player.teleport(spawnLocation);

            if(config.getBoolean("VoidTeleport_Notify")) {
                String NotifyMessage = ColorUtils.applyColors(config.getString("Messages.VoidNotifyMessage"));
                player.sendMessage(NotifyMessage); // Уведомление игроку о перемещении на спавн
            }
            if(config.getBoolean("VoidTeleport_PlaySound")) {
                player.playSound(spawnLocation, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f); // Звук перемещения
            }
        }
    }

    @EventHandler
    public void onVoidDamage(EntityDamageEvent event) {
        FileConfiguration config = getFileConfig();

        if(!config.getBoolean("DisableVoidDamage")) return;

        if (event.getEntity() instanceof Player player) {
            if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {
                event.setCancelled(true);
            }
        }
    }

    private FileConfiguration getFileConfig() {
        return plugin.getConfig();
    }

}
