package configfiles;

import java.io.File;

import main.Region;
import main.VoltramDrops;

public class DefaultConfig {
	
	Region region = new Region();

	
	public void defaultSetup() {
		
		boolean justCreated = false;
		File config = new File(VoltramDrops.plugin.getDataFolder(), "config.yml");
		if(!config.exists()) {
			VoltramDrops.plugin.getConfig().options().copyDefaults(true);
			justCreated = true;
			
		}
/*
		VoltramDrops.plugin.getConfig().addDefault("MinForDrop", 1);
		VoltramDrops.plugin.getConfig().addDefault("Regions", "//List of Regions");
		//VoltramDrops.plugin.getConfig().addDefault("Regions.Region", region.regions);
		 
		 */
		if(justCreated == false) {
		for (String i : VoltramDrops.plugin.getConfig().getConfigurationSection("Regions").getKeys(false)) {
			VoltramDrops.plugin.getConfig().set("Regions." + i + ".enabled", false);
		}
		}
		VoltramDrops.plugin.saveDefaultConfig();
	
	}
	
	public void addRegion(Region reg) {
		System.out.println("MADE TO DEFAULT CONFIG");
		VoltramDrops.plugin.getConfig().set("Regions." + reg.name, reg.name);
		System.out.println("1");
		VoltramDrops.plugin.getConfig().set("Regions." + reg.name + ".minX", reg.minX);
		System.out.println("2");
		VoltramDrops.plugin.getConfig().set("Regions." + reg.name + ".maxX", reg.maxX);
		System.out.println("3");
		VoltramDrops.plugin.getConfig().set("Regions." + reg.name + ".minZ", reg.minZ);
		System.out.println("4");
		VoltramDrops.plugin.getConfig().set("Regions." + reg.name + ".maxZ", reg.maxZ);
		System.out.println("5");
		VoltramDrops.plugin.getConfig().set("Regions." + reg.name + ".dropFromHeight", 75);
		System.out.println("6");
		VoltramDrops.plugin.getConfig().set("Regions." + reg.name + ".numCrates", 10);
		System.out.println("7");
		VoltramDrops.plugin.getConfig().set("Regions." + reg.name + ".MinForDrops", 1);
		System.out.println("8");
		VoltramDrops.plugin.getConfig().set("Regions." + reg.name + ".world", reg.player.getWorld().getName());
		System.out.println("9");
		VoltramDrops.plugin.getConfig().set("Regions." + reg.name + ".enabled", false);
		System.out.println("10");
		VoltramDrops.plugin.saveConfig();
		System.out.println("11");
	}

}
