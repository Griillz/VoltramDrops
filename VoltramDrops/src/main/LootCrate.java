package main;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;

public class LootCrate {
	
	Chest chest = null;
	Inventory inv = null;
	int tier = 0;
	int items = 0;
	
	
	
	public LootCrate() {
		
	}
	
	public LootCrate(int tier, int items) {
		this.tier = tier;
		this.items = items;
		
	}	
	
	
}
