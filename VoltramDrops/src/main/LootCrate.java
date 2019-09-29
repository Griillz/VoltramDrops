package main;

import java.util.ArrayList;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;

public class LootCrate {

	public ArrayList<String> crates = new ArrayList<String>();
	public Block block = null;
	public String name = null;
	public Location loc = null;
	public Chest chest = null;
	public Inventory chestInv = null;
	public com.gmail.filoghost.holographicdisplays.api.Hologram hologram = null;
	public int tier = 0;
	public int items = 0;

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
