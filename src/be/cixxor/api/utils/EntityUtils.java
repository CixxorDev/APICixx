package be.cixxor.api.utils;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public class EntityUtils {
	
	@SuppressWarnings("unused")
	private static boolean isInBorder(Location center, Location notCenter, int range) {
		int x = center.getBlockX();
		int z = center.getBlockZ();
		int x1 = notCenter.getBlockX();
		int z1 = notCenter.getBlockZ();
		
		if(x1 >= x + range || z1 >= z + range || x1 <= x-range || z1 <= z-range) {
			return false;
		}
		return true;
	}
	
	public static void setVolocity(Entity ent, double x, double y, double z) {
		ent.setVelocity(new Vector(x,y,z));
	}

}
