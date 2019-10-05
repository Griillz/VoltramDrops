package main;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ItemPool {
	
	static HashMap<String, ItemStack> map1 = new HashMap<>(); // HashMap of ItemStacks for tier 1
	static HashMap<String, ItemStack> map2 = new HashMap<>(); // HashMap of ItemStacks for tier 2
	static HashMap<String, ItemStack> map3 = new HashMap<>(); // HashMap of ItemStacks for tier 3
	static Random rand = new Random();

	// Puts desired items for itempool into hashmap
	public static void createPool() {

		for (String i : VoltramDrops.plugin.getConfig().getConfigurationSection("Regions").getKeys(false)) {
			for (String x : VoltramDrops.plugin.getConfig().getConfigurationSection(i + ".tier1").getKeys(false)) {
				for( String z : VoltramDrops.plugin.getConfig().getConfigurationSection(x + ".name").getKeys(false)) {
					map1.put(i + x + z, new ItemStack((Material) VoltramDrops.plugin.getConfig().get(z)));
				}
			}
		}
		
		for (String i : VoltramDrops.plugin.getConfig().getConfigurationSection("Regions").getKeys(false)) {
			for (String x : VoltramDrops.plugin.getConfig().getConfigurationSection(i + ".tier2").getKeys(false)) {
				for( String z : VoltramDrops.plugin.getConfig().getConfigurationSection(x + ".name").getKeys(false)) {
					map2.put(i + x + z, new ItemStack((Material) VoltramDrops.plugin.getConfig().get(z)));
				}
			}
		}
		
		for (String i : VoltramDrops.plugin.getConfig().getConfigurationSection("Regions").getKeys(false)) {
			for (String x : VoltramDrops.plugin.getConfig().getConfigurationSection(i + ".tier3").getKeys(false)) {
				for( String z : VoltramDrops.plugin.getConfig().getConfigurationSection(x + ".name").getKeys(false)) {
					map3.put(i + x + z, new ItemStack((Material) VoltramDrops.plugin.getConfig().get(z)));
				}
			}
		}
		/*
		map1.put("diamond", new ItemStack(Material.DIAMOND, 10));
		map1.put("gold", new ItemStack(Material.GOLD_INGOT, 10));
		map1.put("emerald", new ItemStack(Material.EMERALD, 10));
		map1.put("coal", new ItemStack(Material.COAL, 10));
		map1.put("wood", new ItemStack(Material.OAK_PLANKS, 10));
		map1.put("stone", new ItemStack(Material.STONE, 10));

		map2.put("diamond", new ItemStack(Material.DIAMOND, 20));
		map2.put("gold", new ItemStack(Material.GOLD_INGOT, 20));
		map2.put("emerald", new ItemStack(Material.EMERALD, 20));
		map2.put("coal", new ItemStack(Material.COAL, 20));
		map2.put("wood", new ItemStack(Material.OAK_PLANKS, 20));
		map2.put("stone", new ItemStack(Material.STONE, 20));

		map3.put("diamond", new ItemStack(Material.DIAMOND, 30));
		map3.put("gold", new ItemStack(Material.GOLD_INGOT, 30));
		map3.put("emerald", new ItemStack(Material.EMERALD, 30));
		map3.put("coal", new ItemStack(Material.COAL, 30));
		map3.put("wood", new ItemStack(Material.OAK_PLANKS, 30));
		map3.put("stone", new ItemStack(Material.STONE, 30));
		*/

	}

	// Adds items to crates based off tier
	public static void addChest(LootCrate e, String regionName, String tier, String itemName) {
		e.getChest().update(true);
		for (int i = 0; i < e.getItems(); i++) {
			int index = rand.nextInt(26) + 1;
			if (e.getChestInv().getItem(index) != null) {
				index = indexCheck(e.getChestInv());
			}
			int chance = rand.nextInt(100) + 1;
			if (e.getTier() == 1) {
				if (chance <= 30) {
					e.getChestInv().setItem(index, map1.get(regionName + tier + itemName));
				} else if (chance <= 55) {
					e.getChestInv().setItem(index, map1.get(regionName + tier + itemName));
				} else if (chance <= 70) {
					e.getChestInv().setItem(index, map1.get(regionName + tier + itemName));
				} else if (chance <= 83) {
					e.getChestInv().setItem(index, map1.get(regionName + tier + itemName));
				} else if (chance <= 92) {
					e.getChestInv().setItem(index, map1.get(regionName + tier + itemName));
				} else if (chance <= 100) {
					e.getChestInv().setItem(index, map1.get(regionName + tier + itemName));
				}
			}

			if (e.getTier() == 2) {
				if (chance <= 30) {
					e.getChestInv().setItem(index, map2.get("wood"));
				} else if (chance <= 55) {
					e.getChestInv().setItem(index, map2.get("stone"));
				} else if (chance <= 70) {
					e.getChestInv().setItem(index, map2.get("coal"));
				} else if (chance <= 83) {
					e.getChestInv().setItem(index, map2.get("gold"));
				} else if (chance <= 92) {
					e.getChestInv().setItem(index, map2.get("diamond"));
				} else if (chance <= 100) {
					e.getChestInv().setItem(index, map2.get("emerald"));
				}
			}

			if (e.getTier() == 3) {
				if (chance <= 30) {
					e.getChestInv().setItem(index, map3.get("wood"));
				} else if (chance <= 55) {
					e.getChestInv().setItem(index, map3.get("stone"));
				} else if (chance <= 70) {
					e.getChestInv().setItem(index, map3.get("coal"));
				} else if (chance <= 83) {
					e.getChestInv().setItem(index, map3.get("gold"));
				} else if (chance <= 92) {
					e.getChestInv().setItem(index, map3.get("diamond"));
				} else if (chance <= 100) {
					e.getChestInv().setItem(index, map3.get("emerald"));
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
