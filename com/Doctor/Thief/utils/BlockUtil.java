package com.Doctor.Thief.utils;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class BlockUtil {

	private static HashMap<Block, Integer> broken = new HashMap<Block, Integer>();

	@SuppressWarnings("deprecation")
	public static void repair() {
		for (Block b : broken.keySet()) {
			b.setTypeId(broken.get(b));
		}
	}

	@SuppressWarnings("deprecation")
	public static ArrayList<Block> getFlatPlaneNearbyBlocks(Location loc,
			int radius) {
		ArrayList<Block> blocks = new ArrayList<Block>();
		int x = loc.getBlockX();
		int z = loc.getBlockZ();
		int xDiff = x + radius;
		int zDiff = z + radius;
		for (x = x - (radius); x <= xDiff; x++) {
			for (z = z - (radius); z <= zDiff; z++) {
				int y = loc.getBlockY();
				Location blockloc = new Location(loc.getWorld(), x, y, z);
				if (blockloc.getBlock().getType() != Material.AIR) {
					blocks.add(blockloc.getBlock());
					broken.put(blockloc.getBlock(), blockloc.getBlock()
							.getTypeId());
				}
			}
		}
		return blocks;
	}

	public static ArrayList<Block> getNearbyBlocks(Location loc, int radius) {
		ArrayList<Block> blocks = new ArrayList<Block>();
		for (int x = -(radius); x <= radius; x++) {
			for (int y = -(radius); y <= radius; y++) {
				for (int z = -(radius); z <= radius; z++) {

					Location blockloc = loc.getBlock().getRelative(x, y, z).getLocation();
					blocks.add(blockloc.getBlock());
					broken.put(blockloc.getBlock(), blockloc.getBlock()
							.getTypeId());
				}

			}

		}
		return blocks;
	}
}
