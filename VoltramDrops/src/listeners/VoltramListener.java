package listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.gmail.filoghost.holographicdisplays.HolographicDisplays;

import main.LootCrate;
import managers.CrateManager;

public class VoltramListener implements Listener {
	Boolean first = false;
	
	@EventHandler
	public void closeLootCrate(InventoryCloseEvent e) {
		System.out.println("First");
		Player p = (Player) e.getPlayer();
		Inventory inv = e.getInventory();
		for (int i = 0; i < CrateManager.crates.size(); i++) {
			System.out.println(CrateManager.crates.get(i).getLoc() + " crate loc" + inv.getLocation() + " inv loc");
			if(CrateManager.crates.get(i).getLoc().getBlockX() == inv.getLocation().getBlockX() && CrateManager.crates.get(i).getLoc().getBlockY() == inv.getLocation().getBlockY()
					&& CrateManager.crates.get(i).getLoc().getBlockZ() == inv.getLocation().getBlockZ()) {
				System.out.println("Second");
				for(ItemStack item : inv.getContents()) {
					if(item != null) {
						return;
					}
				}
				CrateManager.delCrate(CrateManager.crates.get(i));
			}
		}
	}


	public HolographicDisplays getHolo() {
		Plugin p = Bukkit.getServer().getPluginManager().getPlugin("HolographicDisplays");
		if (p instanceof HolographicDisplays)
			return (HolographicDisplays) p;
		else
			return null;
	}

}
