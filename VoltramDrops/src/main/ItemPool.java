package main;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ItemPool {
	
	static HashMap<String, ItemStack> map = new HashMap<>(); // HashMap of ItemStacks
	static Random rand = new Random();

	// Puts desired items for itempool into hashmap
	public static void createPool() {

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
	public static void addChest(LootCrate e) {
		e.getChest().update(true);
		Bukkit.broadcastMessage("TIER IS " + e.getTier());
		for (int i = 0; i < e.getItems(); i++) {
			int index = rand.nextInt(26) + 1;
			Bukkit.broadcastMessage("INDEX IS " + index);
			if (e.getChestInv().getItem(index) != null) {
				index = indexCheck(e.getChestInv());
				Bukkit.broadcastMessage("INDEX IS FROM METHOD" + index);
			}
			int chance = rand.nextInt(100) + 1;
			Bukkit.broadcastMessage("RAND VALUE " + chance);
			if (e.getTier() == 1) {
				if (chance <= 30) {
					e.getChestInv().setItem(index, map.get("1wood"));
				} else if (chance <= 55) {
					e.getChestInv().setItem(index, map.get("1stone"));
				} else if (chance <= 70) {
					e.getChestInv().setItem(index, map.get("1coal"));
				} else if (chance <= 83) {
					e.getChestInv().setItem(index, map.get("1gold"));
				} else if (chance <= 92) {
					e.getChestInv().setItem(index, map.get("1diamond"));
				} else if (chance <= 100) {
					e.getChestInv().setItem(index, map.get("1emerald"));
				}
			}

			if (e.getTier() == 2) {
				if (chance <= 30) {
					e.getChestInv().setItem(index, map.get("2wood"));
				} else if (chance <= 55) {
					e.getChestInv().setItem(index, map.get("2stone"));
				} else if (chance <= 70) {
					e.getChestInv().setItem(index, map.get("2coal"));
				} else if (chance <= 83) {
					e.getChestInv().setItem(index, map.get("2gold"));
				} else if (chance <= 92) {
					e.getChestInv().setItem(index, map.get("2diamond"));
				} else if (chance <= 100) {
					e.getChestInv().setItem(index, map.get("2emerald"));
				}
			}

			if (e.getTier() == 3) {
				if (chance <= 30) {
					e.getChestInv().setItem(index, map.get("3wood"));
				} else if (chance <= 55) {
					e.getChestInv().setItem(index, map.get("3stone"));
				} else if (chance <= 70) {
					e.getChestInv().setItem(index, map.get("3coal"));
				} else if (chance <= 83) {
					e.getChestInv().setItem(index, map.get("3gold"));
				} else if (chance <= 92) {
					e.getChestInv().setItem(index, map.get("3diamond"));
				} else if (chance <= 100) {
					e.getChestInv().setItem(index, map.get("3emerald"));
				}
			}
		}
	}

	// If items is already in chest index, pick a new index
	public static int indexCheck(Inventory inv) {
		Random rand = new Random();
		int index = rand.nextInt(26) + 1;
		if (inv.getItem(index) != null) {
			indexCheck(inv);
		}

		return index;
	}

}
