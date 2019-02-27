package be.cixxor.api.utils;

import java.util.Random;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;

public class FireworkUtils {
	
	public static void createFireworkEffect(Location location, Color color, FireworkEffect.Type type) {
		
	}
	
	public static FireworkEffect.Type getRandomFireworkType(){
		FireworkEffect.Type type = FireworkEffect.Type.BALL;
		int r = new Random().nextInt(4);
		if(r == 0) {
			type = FireworkEffect.Type.BALL_LARGE;
		} else if(r == 1){
			type = FireworkEffect.Type.BURST;
		} else if(r == 2) {
			type = FireworkEffect.Type.CREEPER;
		} else if(r == 3) {
			type = FireworkEffect.Type.STAR;
		}
		return type;
	}
	
	public static FireworkEffect getRandomFireworkEffect() {
		Color color = ColorUtils.getRandomColor();
		FireworkEffect.Type type = getRandomFireworkType();
		return FireworkEffect.builder().withColor(color).with(type).build();
	}
	
	public static FireworkEffect getRandomFireworkEffect(FireworkEffect.Type type) {
		Color color = ColorUtils.getRandomColor();
		return FireworkEffect.builder().withColor(color).with(type).build();
	}
	
	public static FireworkEffect getRandomFireworkEffect(Color color) {
		FireworkEffect.Type type = getRandomFireworkType();
		return FireworkEffect.builder().withColor(color).with(type).build();
	}
	
	public static FireworkEffect getRandomFireworkEffectColorandType(FireworkEffect.Type type, Color color) {
		return FireworkEffect.builder().withColor(color).with(type).build();
	}

}
