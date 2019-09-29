package main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;

import configfiles.DefaultConfig;

public class Region {
	
	com.sk89q.worldedit.regions.Region region = null;
	public CommandVD lol = new CommandVD();
	public boolean enabled = false; // if the region is enabled
	public int timer = 0; // Time in seconds for lootcrate event to occur, gotten from config
	public String name = null;
	public double minX, maxX, minZ, maxZ;
	public Player player;
	
	
	public Region() {
		
	}
	
	public Region(String regionName, double minX, double maxX, double minZ, double maxZ, Player p) {
		this.player = p;
		this.minX = minX;
		this.maxX = maxX;
		this.minZ = minZ;
		this.maxZ = maxZ;
		this.name = regionName;
		System.out.println("MADE TO REGION CONSTRUCTOR");
		DefaultConfig c = new DefaultConfig();
		c.addRegion(this);
	}
	
	
	public WorldEditPlugin getWorldEdit() {
		Plugin p = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
		if (p instanceof WorldEditPlugin)
			return (WorldEditPlugin) p;
		else
			return null;
	}

}
