package be.cixxor.api.utils;

import java.util.UUID;

import org.bukkit.Achievement;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import net.minecraft.server.v1_8_R3.EntityPlayer;

public class PlayerUtils {
	
	public static void killPlayer(Player player) {
		player.setHealth(0.0D);
	}
	
	public static void damage(Player player, double damage) {
		player.damage(damage);
	}
	
	public static void setMaxHealth(Player player, double value) {
		player.setMaxHealth(value);
	}
	
	public static void healPlayer(Player player) {
		player.setHealth(20.0D);
	}
	
	public static void feedPlayer(Player player) {
		player.setFoodLevel(20);
	}
	
	public static void healPlayer(Player player, double value) {
		double d = player.getHealth();
		d += value;
		player.setHealth(d);
	}
	public static void feedPlayer(Player player, double value) {
	    int d = player.getFoodLevel();
		d += value;
		player.setFoodLevel(d);
	}
	
	public static void starve(Player player) {
		player.setFoodLevel(0);
	}
	
	public static void starve(Player player, int value) {
		int d = player.getFoodLevel();
		d += value;
		player.setFoodLevel(d);
	}
	
	public static UUID getUUID(Player player) {
		return player.getUniqueId();
	}
	
	public static void setGameMode(Player player, GameMode gamemode) {
		player.setGameMode(gamemode);
	}
	
	public static void addPotionEffect(Player player, PotionEffectType potioneffect, int time, int level) {
		player.addPotionEffect(new PotionEffect(potioneffect, time * 20, level));
	}
	
	public static void removePotionEffect(Player player, PotionEffectType potioneffect) {
		player.removePotionEffect(potioneffect);
	}
	public static void removeAllPotionEffect(Player player) {
		for(PotionEffect pe : player.getActivePotionEffects()) {
			player.removePotionEffect(pe.getType());
		}
	}
	
	public static void kick(Player player, String reason) {
		player.kickPlayer(reason);
	}
	
	public static void teleport(Player player, Object object) {
		if((object instanceof Player)) {
			Player p = (Player) object;
			player.teleport(p);
		} else if(object instanceof Location) {
			Location loc = (Location) object;
			player.teleport(loc);
		} else if(object instanceof Entity) {
			Entity ent = (Entity) object;
			player.teleport(ent);
		} else if(object instanceof LivingEntity) {
			LivingEntity lent = (LivingEntity) object;
			player.teleport(lent);
		}
	}
	
	public static void burnplayer(Player player, int ticks) {
		player.setFireTicks(ticks);
	}
	
	public static void extinguish(Player player) {
		player.setFireTicks(0);
	}
	
	public static void unlockward(Player player, Achievement achievement) {
		player.awardAchievement(achievement);
	}
	
	public static Inventory getInventory(Player player) {
		return player.getInventory();
	}
	
	public static void addItemToInventory(Player player, ItemStack it) {
		player.getInventory().addItem(new ItemStack[] {it});
	}
	
	public static Boolean inventoryContainsItem(Player player, Material material) {
		if(player.getInventory().contains(material)) {
			return Boolean.valueOf(true);
		}
		return Boolean.valueOf(false);
	}
	
	public static Boolean inventoryContainsItem(Player player, Material material, int amount) {
		if(player.getInventory().contains(material, amount)) {
			return Boolean.valueOf(true);
		}
		return Boolean.valueOf(false);
	}
	
	public static String getInventoryName(Player player) {
		return player.getInventory().getName();
	}
	
	public static String getInventoryTitle(Player player) {
		return player.getInventory().getTitle();
	}
	
	public boolean inventoryhasEmptySlot(Player player, ItemStack it) {
		ItemStack[] arrayOfItemStack;
		int j = (arrayOfItemStack = player.getInventory().getContents()).length;
		for(int i = 0; i < j; i++) {
			ItemStack items = arrayOfItemStack[i];
			if(items == null) {
				return Boolean.valueOf(false);
			}
		}
		return Boolean.valueOf(true);
	}
	
	public static void clearInv(Player player) {
		player.getInventory().clear();
	}
	
	public static Integer getLevel(Player player) {
		return Integer.valueOf(player.getLevel());
	}
	
	public static void setVelocity(Player player, double x, double y, double z) {
		player.setVelocity(new Vector(x,y,z));
	}
	
	public static Integer getPing(Player player) {
		CraftPlayer cp = (CraftPlayer) player;
		EntityPlayer ep = cp.getHandle();
		return Integer.valueOf(ep.ping);
	}
	
	public static Boolean isSprinting(Player player) {
		CraftPlayer cp = (CraftPlayer) player;
		EntityPlayer ep = (EntityPlayer) cp.getHandle();
		return Boolean.valueOf(ep.isSprinting());
	}
	
	public static Boolean isSneaking(Player player) {
		CraftPlayer cp = (CraftPlayer) player;
		EntityPlayer ep = (EntityPlayer) cp.getHandle();
		return Boolean.valueOf(ep.isSneaking());
	}
	
	public static Boolean isBurning(Player player) {
		CraftPlayer cp = (CraftPlayer) player;
		EntityPlayer ep = (EntityPlayer) cp.getHandle();
		return Boolean.valueOf(ep.isBurning());
	}
	
	public static Boolean isInvisible(Player player) {
		CraftPlayer cp = (CraftPlayer) player;
		EntityPlayer ep = (EntityPlayer) cp.getHandle();
		return Boolean.valueOf(ep.isInvisible());
	}
	
	public static void setSneaking(Player player, boolean b) {
		CraftPlayer cp = (CraftPlayer) player;
		EntityPlayer ep = (EntityPlayer) cp.getHandle();
		ep.setSneaking(b);
	}
	
	public static String getWName(Player player) {
		return player.getWorld().getName();
	}
	
	public static void setInvisible(Player player, boolean b) {
		CraftPlayer cp = (CraftPlayer) player;
		EntityPlayer ep = (EntityPlayer) cp.getHandle();
		ep.setInvisible(b);
	}
	
	public static void setFlying(Player player, boolean b) {
		player.setFlying(b);
	}
	
	public static void setCollides(Player player, boolean b) {
		player.spigot().setCollidesWithEntities(b);
	}
	
	public static void respawn(Player player) {
		player.spigot().respawn();
	}
	
	public static void chat(Player player,String str) {
		player.chat(str);
	}
	
	/**
	 * 
	 * @author: Cixxor
	 * @worldside
	 * 
	 */
	public static void setPvPonWorld(World world, boolean b) {
		world.setPVP(b);
	}
	
	public static void summon(World world,EntityType ent,Location loc) {
		world.spawnEntity(loc,ent);
	}
	
	public static void explode(World world, Location loc, float f) {
		world.createExplosion(loc, f);
	}	
	
}