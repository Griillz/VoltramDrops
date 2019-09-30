package managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;

import main.ItemPool;
import main.LootCrate;

public class CrateManager {
	
	static Plugin holoDisp = Bukkit.getServer().getPluginManager().getPlugin("HolographicDisplays");
	public static List<LootCrate> crates = new ArrayList<LootCrate>();

	public static void createNewCrate(Location loc) {
		LootCrate crate = new LootCrate(genTier(), genItems());
		crate.setTier(genTier());
		crate.setLoc(loc.getBlock().getLocation());
		crate.getLoc().getBlock().setType(Material.CHEST);
		crate.setBlock(crate.getLoc().getBlock());
		
		crate.setChest((Chest) crate.getBlock().getState());
		crate.setChestInv(crate.getChest().getInventory());
		ItemPool.addChest(crate);
		Location holo = crate.getLoc();
		holo.add(0.5, 2, 0.5);
		crate.setHologram(HologramsAPI.createHologram(holoDisp, holo));
		holo.add(-0.5, -2, -0.5);
		crate.getHologram().appendTextLine(ChatColor.DARK_RED + "TIER " + ChatColor.YELLOW + crate.getTier());
		
		crates.add(crate);
		
	}
	
	public static void delCrate(LootCrate crate) {
		crate.getChestInv().clear();
		crate.getHologram().delete();
		crate.getBlock().setType(Material.AIR);
		crates.remove(crate);
	}
	
	// Generates create tier
	public static int genTier() {
		Random rand = new Random();
		int i = rand.nextInt(10) + 1;
		int tier = 0;

		if (i <= 5) {
			tier = 1;
		} else if (i <= 9 && i > 5) {
			tier = 2;
		} else {
			tier = 3;
		}

		return tier;
	}

	// generates num of items in crate
	public static int genItems() {
		Random rando = new Random();
		return rando.nextInt(6) + 1;
	}
}
