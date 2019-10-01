package configfiles;

import java.io.File;

import org.bukkit.entity.Player;

import main.VoltramDrops;

public class DefaultConfig {
	

	
	public static void defaultSetup() {
		
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
		try {
		if(justCreated == false) {
		for (String i : VoltramDrops.plugin.getConfig().getConfigurationSection("Regions").getKeys(false)) {
			VoltramDrops.plugin.getConfig().set("Regions." + i + ".enabled", false);
		}
		}
		}
		catch (NullPointerException e) {
			
		}
		VoltramDrops.plugin.saveConfig();
	
	}
	
	public static void addRegion(String regionName, double minX, double maxX, double minZ, double maxZ, Player p) {
		System.out.println("MADE TO DEFAULT CONFIG");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName, regionName);
		System.out.println("1");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".minX", minX);
		System.out.println("2");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".maxX", maxX);
		System.out.println("3");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".minZ", minZ);
		System.out.println("4");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".maxZ", maxZ);
		System.out.println("5");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".dropFromHeight", VoltramDrops.plugin.getConfig().getInt("DefaultDropFromHeight"));
		System.out.println("6");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".numCrates", VoltramDrops.plugin.getConfig().getInt("DefaultNumCrates"));
		System.out.println("7");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".MinForDrops", VoltramDrops.plugin.getConfig().getInt("DefaultMinForDrops"));
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".NoNoBlock", VoltramDrops.plugin.getConfig().getString("DefaultNoNoBlock"));
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".time", VoltramDrops.plugin.getConfig().getInt("DefaultTime"));
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".name", regionName);
		System.out.println("8");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".world", p.getWorld().getName());
		System.out.println("9");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".enabled", false);
		System.out.println("10");
		VoltramDrops.plugin.saveConfig();
		System.out.println("11");
	}

}
