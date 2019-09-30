package main;

import java.util.ArrayList;

import configfiles.DefaultConfig;
import tasks.DropEvent;

public class Init {
	public static void init() {
		ItemPool.createPool();
		DefaultConfig.defaultSetup();

		ArrayList<String> regionNames = new ArrayList<String>();
		try {
			for (String i : VoltramDrops.plugin.getConfig().getConfigurationSection("Regions").getKeys(false)) {
				regionNames.add(i);
				new DropEvent(VoltramDrops.plugin.getConfig().getString("Regions." + i + ".name"),
						VoltramDrops.plugin.getConfig().getInt("Regions." + i + ".time"),
						VoltramDrops.plugin.getConfig().getInt("Regions." + i + ".MinForDrops"), VoltramDrops.plugin).run();
			}
		} catch (NullPointerException e) {

		}
	}
}
