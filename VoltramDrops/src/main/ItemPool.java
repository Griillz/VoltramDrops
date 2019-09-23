package main;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ItemPool {

	Player p = null;
	int tier = 0;
	int items = 0;
	HashMap<String, ItemStack> map = new HashMap<>(); // HashMap of ItemStacks
	Random rand = new Random();
	LootCrate crate = new LootCrate();

	// Puts desired items for itempool into hashmap
	public void createPool() {

		map.put("1diamond", new ItemStack(Material.DIAMOND, 10));
		map.put("1gold", new ItemStack(Material.GOLD_INGOT, 10));
		map.put("1emerald", new ItemStack(Material.EMERALD, 10));
		map.put("1coal", new ItemStack(Material.COAL, 10));
		map.put("1wood", new ItemStack(Material.OAK_PLANKS, 10));
		map.put("1stone", new ItemStack(Material.STONE, 10));

		map.put("2diamond", new ItemStack(Material.DIAMOND, 20));
		map.put("2gold", new ItemStack(Material.GOLD_INGOT, 20));
		map.put("2emerald", new ItemStack(Material.EMERALD, 20));
		map.put("2coal", new ItemStack(Material.COAL, 20));
		map.put("2wood", new ItemStack(Material.OAK_PLANKS, 20));
		map.put("2stone", new ItemStack(Material.STONE, 20));

		map.put("3diamond", new ItemStack(Material.DIAMOND, 30));
		map.put("3gold", new ItemStack(Material.GOLD_INGOT, 30));
		map.put("3emerald", new ItemStack(Material.EMERALD, 30));
		map.put("3coal", new ItemStack(Material.COAL, 30));
		map.put("3wood", new ItemStack(Material.OAK_PLANKS, 30));
		map.put("3stone", new ItemStack(Material.STONE, 30));

	}

	// Adds items to crates based off tier
	public void addChest(LootCrate e) {
		e.chest.update(true);
		p.sendMessage("TIER IS " + e.tier);
		for (int i = 0; i < e.items; i++) {
			int index = rand.nextInt(26) + 1;
			p.sendMessage("INDEX IS " + index);
			if (e.chestInv.getItem(index) != null) {
				index = indexCheck(e.chestInv);
				p.sendMessage("INDEX IS FROM METHOD" + index);
			}
			int chance = rand.nextInt(100) + 1;
			p.sendMessage("RAND VALUE " + chance);
			if (e.tier == 1) {
				if (chance <= 30) {
					e.chestInv.setItem(index, map.get("1wood"));
				} else if (chance <= 55) {
					e.chestInv.setItem(index, map.get("1stone"));
				} else if (chance <= 70) {
					e.chestInv.setItem(index, map.get("1coal"));
				} else if (chance <= 83) {
					e.chestInv.setItem(index, map.get("1gold"));
				} else if (chance <= 92) {
					e.chestInv.setItem(index, map.get("1diamond"));
				} else if (chance <= 100) {
					e.chestInv.setItem(index, map.get("1emerald"));
				}
			}

			if (e.tier == 2) {
				if (chance <= 30) {
					e.chestInv.setItem(index, map.get("2wood"));
				} else if (chance <= 55) {
					e.chestInv.setItem(index, map.get("2stone"));
				} else if (chance <= 70) {
					e.chestInv.setItem(index, map.get("2coal"));
				} else if (chance <= 83) {
					e.chestInv.setItem(index, map.get("2gold"));
				} else if (chance <= 92) {
					e.chestInv.setItem(index, map.get("2diamond"));
				} else if (chance <= 100) {
					e.chestInv.setItem(index, map.get("2emerald"));
				}
			}

			if (e.tier == 3) {
				if (chance <= 30) {
					e.chestInv.setItem(index, map.get("3wood"));
				} else if (chance <= 55) {
					e.chestInv.setItem(index, map.get("3stone"));
				} else if (chance <= 70) {
					e.chestInv.setItem(index, map.get("3coal"));
				} else if (chance <= 83) {
					e.chestInv.setItem(index, map.get("3gold"));
				} else if (chance <= 92) {
					e.chestInv.setItem(index, map.get("3diamond"));
				} else if (chance <= 100) {
					e.chestInv.setItem(index, map.get("3emerald"));
				}
			}
		}
	}

	// If items is already in chest index, pick a new index
	public int indexCheck(Inventory inv) {
		Random rand = new Random();
		int index = rand.nextInt(26) + 1;
		if (inv.getItem(index) != null) {
			indexCheck(inv);
		}

		return index;
	}

}
