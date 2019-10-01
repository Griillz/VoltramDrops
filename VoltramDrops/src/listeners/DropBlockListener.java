package listeners;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

import main.LootCrate;
import main.VoltramDrops;
import managers.CrateManager;

public class DropBlockListener implements Listener {
	String name = "";
	List<String> entityList = new ArrayList<String>();

	/*
	@EventHandler
	public void onEntityChangeBlock(EntityChangeBlockEvent e) {
		if (e.getEntity() instanceof FallingBlock) {
			if ((setBlockToCrate(e.getEntity()) == true)) {
				System.out.println(e.getBlock().getLocation() + " FALLING BLOCK LOC");
				//CrateManager.spawnLocs.add(e.getBlock().getLocation());

				Location l = e.getBlock().getLocation();
				Block b = l.getBlock();
				b.setType(Material.AIR);
				CrateManager.createNewCrate(l, name);

				
			}
		}
	}
	*/
/*
	public boolean setBlockToCrate(Entity c) {
		String crateName = "";
		for (LootCrate crate : CrateManager.crates) {
			if (crate.getLoc().getBlockX() == c.getLocation().getBlockX()
					&& crate.getLoc().getBlockZ() == c.getLocation().getBlockZ()) {
				crateName = getName(crate);
				if (!(crateName.equals("none"))) {
					name = crateName;
					System.out.println(crateName + " CRATENAME GETTER!");
					if (c.getLocation().getBlockY() < VoltramDrops.plugin.getConfig()
							.getInt("Regions." + crateName + ".dropFromHeight") - 2) {
						System.out.println(crate.getLoc().getBlockX() + " " + crate.getLoc().getBlockZ() + " "
								+ c.getLocation().getBlockX() + " " + c.getLocation().getBlockZ() + " "
								+ VoltramDrops.plugin.getConfig().getInt("Regions." + crateName + ".dropFromHeight"));

						return true;
					}
				}
			}

		}
		return false;
	}

	public String getName(LootCrate c) {
		for (String i : VoltramDrops.plugin.getConfig().getConfigurationSection("Regions").getKeys(false)) {
			System.out.println(i + " looping thru crate names");
			if (c.getName().contains(i)) {
				System.out.println(i + " CRATE NAME");
				return i;
			}
		}
		return "none";

	}
	*/
}
