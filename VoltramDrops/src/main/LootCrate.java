package main;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;

public class LootCrate {

	ArrayList<String> crates = new ArrayList<String>();
	Block block = null;
	String name = null;
	Location loc = null;
	Chest chest = null;
	Inventory chestInv = null;
	com.gmail.filoghost.holographicdisplays.api.Hologram hologram = null;
	int tier = 0;
	int items = 0;

	public LootCrate() {

	}

	public LootCrate(int tier, int items) {
		this.tier = tier;
		this.items = items;
		setName(this);

	}
	
	public void setName(LootCrate e) {
		int i = crates.size();
		this.name = "Crate " + i;
	}

}
