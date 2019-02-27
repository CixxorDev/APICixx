package be.cixxor.api.utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CixxorAPI extends JavaPlugin{
	
	static CixxorAPI instance;
	
	@Override
	public void onEnable() {
		instance = this;
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	}
	
	public static CixxorAPI getInstance() { return instance; }

}
