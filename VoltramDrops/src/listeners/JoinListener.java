package listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import configfiles.CustomConfig;
import main.Region;
import main.VoltramDrops;

public class JoinListener implements Listener {

	public boolean lootDrop = false;
	public static int numOnline = 0;

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if (e.getPlayer() instanceof Player) {
			numOnline += 1;
			for (String i : VoltramDrops.plugin.getConfig().getConfigurationSection("Regions").getKeys(false)) {
				e.getPlayer().sendMessage(ChatColor.RED + i);
				if (numOnline >= VoltramDrops.plugin.getConfig().getInt("Regions." + i + ".MinForDrops")
						&& VoltramDrops.plugin.getConfig().getBoolean("Regions." + i + ".enabled") == false) {
					VoltramDrops.plugin.getConfig().set("Regions." + i + ".enabled", true);
					VoltramDrops.plugin.saveConfig();
					e.getPlayer().sendMessage("Online player count is " + numOnline + " config req is "
							+ VoltramDrops.plugin.getConfig().getInt("Regions." + i + ".enabled"));
				}
			}

		}
	}

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		if (e.getPlayer() instanceof Player) {
			System.out.println("LEFT!");
			numOnline -= 1;
			System.out.println(numOnline);
			for (String i : VoltramDrops.plugin.getConfig().getConfigurationSection("Regions").getKeys(false)) {
				if (numOnline < VoltramDrops.plugin.getConfig().getInt("Regions." + i + ".MinForDrops")
						&& VoltramDrops.plugin.getConfig().getBoolean("Regions." + i + ".enabled") == true) {
					VoltramDrops.plugin.getConfig().set("Regions." + i + ".enabled", false);
					VoltramDrops.plugin.saveConfig();
				}
			}
		}

	}
}
