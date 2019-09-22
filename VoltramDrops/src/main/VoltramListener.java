package main;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class VoltramListener implements Listener {
	Boolean first = false;
	ItemPool pool = new ItemPool();
/*
   // Generates new items in chest on right click
	@EventHandler
	public void onRightClickChest(PlayerInteractEvent e) {
		pool.p = e.getPlayer();
		if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if (e.getClickedBlock().getType().equals(Material.CHEST)) {
				Chest chest = (Chest)e.getClickedBlock().getState();
				Inventory inv = chest.getInventory();
				if(first == false) {
					first = true;
					pool.createPool();
				}
				pool.addChest(genItems(), genTier(), inv, chest);
			}
		}
	}
	*/
	
	// clears chest on left click
	@EventHandler
	public void onLeftClickChest(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			if(e.getClickedBlock().getType().equals(Material.CHEST)) {
				Chest chest = (Chest)e.getClickedBlock().getState();
				Inventory inv = chest.getInventory();
				inv.clear();
				p.sendMessage("CHEST CLEARED!");
			}
		}
	}
	
	// Makes a new LootCrate Object when chest is placed
	@EventHandler
	public void onPlaceChest(BlockPlaceEvent e) {
		pool.p = e.getPlayer();
		if(e.getBlockPlaced().getType().equals(Material.CHEST)) {
			Block b = e.getBlockPlaced();
			LootCrate crate = new LootCrate(genTier(), genItems());
			crate.chest = (Chest)b.getState();
			crate.inv = crate.chest.getInventory();
			if(first == false) {
				first = true;
				pool.createPool();
			}
			pool.addChest(genItems(), genTier(), crate.inv, crate.chest);
		}
	}
	
	// Generates create tier
	public int genTier() {
		Random rand = new Random();
		int i = rand.nextInt(10) + 1;
		int tier = 0;
		
		if (i <= 5) {
			tier = 1;
		}
		else if(i <= 9 && i > 5) {
			tier = 2;
		}
		else {
			tier = 3;
		}
		
		return tier;
	}
	
	// generates num of items in crate
	public int genItems() {
		Random rando = new Random();
		return rando.nextInt(6) + 1;
	}
	

}
