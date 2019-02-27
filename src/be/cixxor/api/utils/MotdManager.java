package be.cixxor.api.utils;

import net.minecraft.server.v1_8_R3.MinecraftServer;

public class MotdManager {
	
	private static MotdManager instance = new MotdManager();
	private MotdManager() {}
	public static MotdManager getInstance() {return instance;}
	
	public static void setLobbyMotd(String motd) {
		MinecraftServer.getServer().setMotd(motd);
	}
	
	public static void setGameMotd(String motd) {
		MinecraftServer.getServer().setMotd(motd);
	}
	
	public static void setFinishMotd(String motd) {
		MinecraftServer.getServer().setMotd(motd);
	}
	
	public static void setGen(int purcentage) {
		MinecraftServer.getServer().setMotd("Génération " + purcentage + "%");;
	}
}
