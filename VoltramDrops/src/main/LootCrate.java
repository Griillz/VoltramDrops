package main;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;

import managers.CrateManager;

public class LootCrate {

	private Block block = null;
	private String name = null;
	private Location loc = null;
	private Chest chest = null;
	private Inventory chestInv = null;
	private com.gmail.filoghost.holographicdisplays.api.Hologram hologram = null;
	private int tier = 0;
	private int items = 0;

	public LootCrate() {

	}

	public LootCrate(int tier, int items) {
		this.tier = tier;
		this.items = items;
		setName(this);

	}
	
	public void setName(LootCrate e) {
		int i = CrateManager.crates.size();
		this.name = "Crate " + i;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public Chest getChest() {
		return chest;
	}

	public void setChest(Chest chest) {
		this.chest = chest;
	}

	public Inventory getChestInv() {
		return chestInv;
	}

	public void setChestInv(Inventory chestInv) {
		this.chestInv = chestInv;
	}

	public com.gmail.filoghost.holographicdisplays.api.Hologram getHologram() {
		return hologram;
	}

	public void setHologram(com.gmail.filoghost.holographicdisplays.api.Hologram hologram) {
		this.hologram = hologram;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

	public int getItems() {
		return items;
	}

	public void setItems(int items) {
		this.items = items;
	}
	
	
	
	

}
