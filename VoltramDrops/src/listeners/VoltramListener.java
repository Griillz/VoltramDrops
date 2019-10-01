package listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import com.gmail.filoghost.holographicdisplays.HolographicDisplays;

import main.LootCrate;
import managers.CrateManager;

public class VoltramListener implements Listener {
	Boolean first = false;

	// clears chest on left click
	@EventHandler
	public void onLeftClickChest(PlayerInteractEvent e) {
		if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			if (e.getClickedBlock().getType().equals(Material.CHEST)) {
				for (LootCrate crate : CrateManager.crates) {
					System.out.println(
							crate.getLoc() + " - crate loc " + e.getClickedBlock().getLocation() + " - clicked loc");
					if (crate.getLoc().getX() == e.getClickedBlock().getLocation().getX()
							&& crate.getLoc().getY() == e.getClickedBlock().getLocation().getY()
							&& crate.getLoc().getZ() == e.getClickedBlock().getLocation().getZ()) {
						System.out.println(crate.getName());
						CrateManager.delCrate(crate);
						return;
					}
				}
			}
		}
	}

	// Makes a new LootCrate Object when chest is placed
	/*
	 * @EventHandler public void onPlaceChest(BlockPlaceEvent e) { if
	 * (e.getBlockPlaced().getType().equals(Material.CHEST)) { CrateManager
	 * crateManager = new CrateManager(); crateManager.createNewCrate(e);
	 * 
	 * } }
	 */

	public HolographicDisplays getHolo() {
		Plugin p = Bukkit.getServer().getPluginManager().getPlugin("HolographicDisplays");
		if (p instanceof HolographicDisplays)
			return (HolographicDisplays) p;
		else
			return null;
	}

}
