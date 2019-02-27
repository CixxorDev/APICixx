package be.cixxor.api.utils;

import java.util.Arrays;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {
	
	private ItemStack is;
	
	public ItemBuilder(Material material) {
		this(material, 1);
	}
	
	public ItemBuilder(ItemStack is) {
		this.is = is;
	}
	
	public ItemBuilder(Material material, int amount) {
		is = new ItemStack(material, amount);
	}
	
	public ItemBuilder(Material material, int amount, short meta) {
		is = new ItemStack(material,amount,meta);
	}
	
	public ItemBuilder clone() {
		return new ItemBuilder(is);
	}
	
	public ItemBuilder setDurability(short dura) {
		is.setDurability(dura);
		return this;
	}
	
	public ItemBuilder setName(String name) {
		ItemMeta iM = is.getItemMeta();
		iM.setDisplayName(name);
		is.setItemMeta(iM);
		return this;
	}
	
	public ItemBuilder addUnsafeEnchantement(Enchantment enchantment, int level) {
		is.addUnsafeEnchantment(enchantment, level);
		return this;
	}
	
	public ItemBuilder removeEnchantment(Enchantment enchantment) {
		is.removeEnchantment(enchantment);
		return this;
	}
	
	public ItemBuilder setSkullOwner(String owner) {
		try {
			SkullMeta im = (SkullMeta) is.getItemMeta();
			im.setOwner(owner);
			is.setItemMeta(im);
		}catch(ClassCastException e){
		}
		return this;
	}
	
	public ItemBuilder addEnchantment(Enchantment ench, int level) {
		ItemMeta im = is.getItemMeta();
		im.addEnchant(ench, level, true);
		is.setItemMeta(im);
		return this;
	}
	
	public ItemBuilder setInfinityDurability() {
		is.setDurability(Short.MAX_VALUE);
		return this;
	}
	
	public ItemBuilder setLore(String str) {
		ItemMeta im = is.getItemMeta();
		im.setLore(Arrays.asList(str));
		is.setItemMeta(im);
		return this;
	}
	
	@SuppressWarnings("deprecation")
	public ItemBuilder setWoolColor(DyeColor color) {
		if(!is.getType().equals(Material.WOOL)) return this;
			this.is.setDurability(color.getData());
			return this;
	}
	
	@SuppressWarnings("deprecation")
	public ItemBuilder setClayColor(DyeColor color) {
		if(!is.getType().equals(Material.CLAY)) return this;
		this.is.setDurability(color.getData());
		return this;
	}
	
	@SuppressWarnings("deprecation")
	public ItemBuilder setGlassColor(DyeColor color) {
		if(!is.getType().equals(Material.GLASS)) return this;
		this.is.setDurability(color.getData());
		return this;
	}
	
	@SuppressWarnings("deprecation")
	public ItemBuilder setCarpetColor(DyeColor color) {
		if(!is.getType().equals(Material.CARPET)) return this;
		this.is.setDurability(color.getData());
		return this;
	}
	
	public ItemBuilder setLeatherArmor(Color color) {
		try {
			LeatherArmorMeta iM = (LeatherArmorMeta) is.getItemMeta();
			iM.setColor(color);
			is.setItemMeta(iM);
		}catch(ClassCastException e) {
		}
		
		return this;
	}
	
	public ItemStack toItemStack() {
		return is;
	}
}
