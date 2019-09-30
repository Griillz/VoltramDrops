package listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import main.VoltramDrops;

public class JoinListener implements Listener {
	

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if(VoltramDrops.plugin.getConfig().getBoolean("HasRegion") == true) {
		if (e.getPlayer() instanceof Player) {
			for (String i : VoltramDrops.plugin.getConfig().getConfigurationSection("Regions").getKeys(false)) {
				e.getPlayer().sendMessage(ChatColor.RED + i);
				if (Bukkit.getServer().getOnlinePlayers().size() >= VoltramDrops.plugin.getConfig().getInt("Regions." + i + ".MinForDrops")
						&& VoltramDrops.plugin.getConfig().getBoolean("Regions." + i + ".enabled") == false) {
					VoltramDrops.plugin.getConfig().set("Regions." + i + ".enabled", true);
					VoltramDrops.plugin.saveConfig();
					e.getPlayer().sendMessage("Online player count is " + Bukkit.getServer().getOnlinePlayers().size() + " config req is "
							+ VoltramDrops.plugin.getConfig().getInt("Regions." + i + ".MinForDrops"));
				}
			}

		}
		}
	}

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		if (e.getPlayer() instanceof Player) {
			System.out.println("LEFT!");
			for (String i : VoltramDrops.plugin.getConfig().getConfigurationSection("Regions").getKeys(false)) {
				if (Bukkit.getServer().getOnlinePlayers().size() < VoltramDrops.plugin.getConfig().getInt("Regions." + i + ".MinForDrops")
						&& VoltramDrops.plugin.getConfig().getBoolean("Regions." + i + ".enabled") == true) {
					VoltramDrops.plugin.getConfig().set("Regions." + i + ".enabled", false);
					VoltramDrops.plugin.saveConfig();
				}
			}
		}

	}
}
