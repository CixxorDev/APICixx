package be.cixxor.api.utils;

import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
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

	public static void spawnEntity(World world, EntityType ent, Location location){
		world.spawnEntity(location,ent);
	}
	public static void saveWorld(World world){
		world.save();
	}
	public static void TreeGenerator(World world, Location location, TreeType TreeType){
		world.generateTree(location,TreeType);
	}
	public static void allowPVP(World world,boolean b){
		world.setPVP(b);
	}

}
