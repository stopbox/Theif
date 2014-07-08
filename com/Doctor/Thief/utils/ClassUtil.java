package com.Doctor.Thief.utils;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ClassUtil {

	static Random rand = new Random();
	static ItemStack helmet = new ItemStack(Material.AIR, 1);
	static ItemStack chest = new ItemStack(Material.AIR, 1);
	static ItemStack pants = new ItemStack(Material.AIR, 1);
	static ItemStack boots = new ItemStack(Material.AIR, 1);
	static ItemStack sword = new ItemStack(Material.AIR, 1);
	static ItemStack bow = new ItemStack(Material.BOW, 1);
	static ItemStack arrow = new ItemStack(Material.ARROW, 5);

	
	@SuppressWarnings("deprecation")
	public static void noob(Player p){

		int r = rand.nextInt(3);
		//hat
		if(r == 0){
			helmet = new ItemStack(Material.AIR, 1);
		}else if(r == 1){
			helmet = new ItemStack(Material.LEATHER_HELMET);
			helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		}else if(r == 2){
			helmet = new ItemStack(Material.GOLD_HELMET);
			helmet.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
		}else if(r == 3){
			helmet = new ItemStack(Material.IRON_HELMET);
		}
		p.getInventory().setHelmet(helmet);
		//Chestplate
		if(r == 2){
			chest = new ItemStack(Material.AIR, 1);
		}else if(r == 0){
			chest = new ItemStack(Material.LEATHER_CHESTPLATE);
			chest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			chest.addEnchantment(Enchantment.THORNS, 1);
		}else if(r == 3){
			chest = new ItemStack(Material.GOLD_CHESTPLATE);
			chest.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
		}else if(r == 1){
			chest = new ItemStack(Material.IRON_CHESTPLATE);
		}
		p.getInventory().setChestplate(chest);
		//pants
		if(r == 2){
			pants = new ItemStack(Material.AIR, 1);
		}else if(r == 1){
			pants = new ItemStack(Material.LEATHER_LEGGINGS);
			pants.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
		}else if(r == 0){
			pants = new ItemStack(Material.GOLD_LEGGINGS);
			pants.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
		}else if(r == 3){
			pants = new ItemStack(Material.IRON_LEGGINGS);
		}
		p.getInventory().setLeggings(pants);
		//shoes
		if(r == 1){
			boots = new ItemStack(Material.AIR, 1);
		}else if(r == 3){
			boots = new ItemStack(Material.LEATHER_BOOTS);
			boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			boots.addEnchantment(Enchantment.PROTECTION_FALL, 2);
		}else if(r == 0){
			boots = new ItemStack(Material.GOLD_BOOTS);
			boots.addEnchantment(Enchantment.PROTECTION_FIRE, 1);
		}else if(r == 2){
			chest = new ItemStack(Material.IRON_BOOTS);
		}
		p.getInventory().setBoots(boots);
		//weapons
		int x = rand.nextInt(7);
		sword = new ItemStack(Material.STONE_SWORD, 1);
		if(x == 0){
			sword = new ItemStack(Material.WOOD_SWORD, 1);
		
			p.getInventory().addItem(bow);
			p.getInventory().addItem(arrow);
		}else if(r == 1){
			sword = new ItemStack(Material.IRON_SWORD);
		}else if(r == 3 || r == 2){
			sword = new ItemStack(Material.STONE_SWORD);
		}else if(r == 4 || r == 5 || r == 6 || r == 7){
			sword = new ItemStack(Material.WOOD_SWORD);
		}
		p.getInventory().addItem(sword);
		
		
		p.updateInventory();
	}

}
