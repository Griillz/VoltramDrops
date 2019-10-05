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

		try {
		if(!justCreated) {
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
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".spawntime", VoltramDrops.plugin.getConfig().getInt("DefaultTime"));
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".cratedespawntime", VoltramDrops.plugin.getConfig().getInt("CrateDespawnDefaultTime"));
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".name", regionName);
		System.out.println("8");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".world", p.getWorld().getName());
		System.out.println("9");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".enabled", false);
		System.out.println("10");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier1", "");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier1.Diamond", "");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier1.Diamond.name", "diamond");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier1.Diamond.minamount", 1);
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier1.Diamond.maxamount", 10);
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier1.Diamond.chance", 100);
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier2", "");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier2.Diamond", "");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier2.Diamond.name", "diamond");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier2.Diamond.minamount", 10);
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier2.Diamond.maxamount", 20);
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier2.Diamond.chance", 100);
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier3", "");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier3.Diamond", "");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier3.Diamond.name", "diamond");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier3.Diamond.minamount", 20);
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier3.Diamond.maxamount", 30);
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + ".tier3.Diamond.chance", 100);

		VoltramDrops.plugin.saveConfig();
		System.out.println("11");
	}
	
	public static void addItem(String regionName, String tier, String itemName, Player p) {
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + "tier" + tier + "." + itemName, "");
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + "tier" + tier + "." + itemName + ".name", p.getInventory().getItemInMainHand().getType());
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + "tier" + tier + "." + itemName + ".minamount", 10);
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + "tier" + tier + "." + itemName + ".maxamount", 20);
		VoltramDrops.plugin.getConfig().set("Regions." + regionName + "tier" + tier + "." + itemName + ".chance", 100);
		}

}
