package listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import configfiles.CustomConfig;

public class JoinListener implements Listener {
	
	public boolean lootDrop = false;
	public int numOnline = 0;
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		if(e.getPlayer() instanceof Player) {
			numOnline += 1;
			if(numOnline >= CustomConfig.get().getInt("MinForDrop")) {
				lootDrop = true;
			}
		}
	}
	
	public void onPlayerLeave(PlayerQuitEvent e) {
		if(e.getPlayer() instanceof Player) {
			numOnline -= 1;
			if(numOnline <= CustomConfig.get().getInt("MinForDrop")) {
				lootDrop = false;
			}
		}
	}

}
