package be.cixxor.api.utils;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;

import net.minecraft.server.v1_8_R3.EnumColor;

public class ColorUtils {
	
	private static Color[] colors;
	private static DyeColor[] dyeColors;
	private static ChatColor[] chatColors;
	private static EnumColor[] enumColors;
	
	/**
	 *  Get a random color of Color class
	 * @author Cixxor
	 */
	
	public static Color getRandomColor() {
		return ColorUtils.colors[new Random().nextInt(16)];
	}
	
	public static DyeColor getRandomDyeColor() {
		return ColorUtils.dyeColors[new Random().nextInt(16)];
	}
	
	public static ChatColor getRandomChatColor() {
		return ColorUtils.chatColors[new Random().nextInt(17)];
	}
	
	public static EnumColor getRandomEnumColor() {
		return ColorUtils.enumColors[new Random().nextInt(16)];
	}
	
	static {
		ColorUtils.colors = new Color[] {Color.AQUA, Color.BLACK, Color.BLUE, Color.FUCHSIA, Color.GRAY, Color.GREEN, Color.LIME, Color.MAROON, Color.NAVY, Color.OLIVE, Color.ORANGE, Color.PURPLE, Color.RED, Color.SILVER, Color.TEAL, Color.WHITE, Color.YELLOW};
		ColorUtils.dyeColors = new DyeColor[] {DyeColor.BLACK, DyeColor.BLUE, DyeColor.BROWN, DyeColor.CYAN, DyeColor.GRAY, DyeColor.GREEN, DyeColor.LIGHT_BLUE, DyeColor.LIME, DyeColor.MAGENTA, DyeColor.ORANGE, DyeColor.PINK, DyeColor.PURPLE, DyeColor.RED, DyeColor.SILVER, DyeColor.WHITE, DyeColor.YELLOW};
		ColorUtils.chatColors = new ChatColor[] {ChatColor.AQUA, ChatColor.BLACK, ChatColor.BLUE, ChatColor.DARK_AQUA, ChatColor.DARK_BLUE, ChatColor.DARK_GRAY, ChatColor.DARK_GREEN, ChatColor.DARK_PURPLE, ChatColor.DARK_RED, ChatColor.GOLD, ChatColor.GRAY, ChatColor.GREEN, ChatColor.LIGHT_PURPLE, ChatColor.RED, ChatColor.WHITE, ChatColor.YELLOW};
		ColorUtils.enumColors = new EnumColor[] {EnumColor.BLACK, EnumColor.BLUE,EnumColor.BROWN, EnumColor.CYAN, EnumColor.GRAY, EnumColor.GREEN, EnumColor.LIGHT_BLUE, EnumColor.LIME, EnumColor.MAGENTA, EnumColor.ORANGE, EnumColor.PINK, EnumColor.PURPLE, EnumColor.RED, EnumColor.SILVER, EnumColor.WHITE, EnumColor.YELLOW};
	}

}
