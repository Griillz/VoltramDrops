package configfiles;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class CustomConfig {

	private static File file;
	private static FileConfiguration customFile;

	// finds or generates custom config file
	public static void setup() {
		file = new File(Bukkit.getServer().getPluginManager().getPlugin("VoltramDrops").getDataFolder(),
				"customconfig.yml");

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {

			}
		}

		customFile = YamlConfiguration.loadConfiguration(file);
	}

	// gets an instance of the file
	public static FileConfiguration get() {
		return customFile;
	}

	// saves the file
	public static void save() {
		try {
			customFile.save(file);
		} catch (IOException e) {
			System.out.println("Couldn't save file");
		}
	}

	// reloads file
	public static void reload() {
		customFile = YamlConfiguration.loadConfiguration(file);
	}
}
