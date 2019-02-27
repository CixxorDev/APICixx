package be.cixxor.api.utils;

import java.util.Collection;

import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityFireworks;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityStatus;
import net.minecraft.server.v1_8_R3.World;

public class CustomEntityFireWork extends EntityFireworks{
	
	Collection <? extends Player> players;
	boolean gone;
	
	public CustomEntityFireWork(World world, final Collection<? extends Player> collection) {
		super(world);
		this.players = null;
		this.gone = false;
		this.players = collection;
		this.a(new float[] {0.25f, 0.25f});
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public void die() {
		if(this.gone) {
			return;
		}
		if(this.world.isClientSide) {
			this.gone = true;
			if(this.players != null && this.players.size() > 0) {
				for(Player pls : this.players) {
					((CraftPlayer)players).getHandle().playerConnection.sendPacket((Packet) new PacketPlayOutEntityStatus((Entity)this, (byte) 17));
				}
				this.die();
				return;
			}
			this.world.broadcastEntityEffect((Entity)this, (byte) 17);
			this.die();
		}
	}
	
	public static void spawnEntity(final Location loc, final FireworkEffect effect, final Collection<? extends Player> collection) {
		try {
			CustomEntityFireWork firework = new CustomEntityFireWork((World)(((CraftWorld) loc.getWorld()).getHandle()), collection);
			FireworkMeta meta = ((Firework)firework.getBukkitEntity()).getFireworkMeta();
			meta.addEffect(effect);
			((Firework)firework.getBukkitEntity()).setFireworkMeta(meta);
			firework.setPosition(loc.getX(), loc.getY(), loc.getZ());
			if(((CraftWorld)loc.getWorld()).getHandle().addEntity((Entity)firework)) {
				firework.setInvisible(true);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
