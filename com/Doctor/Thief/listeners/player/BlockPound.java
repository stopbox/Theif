package com.Doctor.Thief.listeners.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import com.Doctor.Thief.Main;
import com.Doctor.Thief.listeners.MGListener;
import com.Doctor.Thief.utils.BlockUtil;

public class BlockPound extends MGListener {
	
	public BlockPound(Main pl) {
		super(pl);
		// TODO Auto-generated constructor stub
	}
	
	Main plugin = (Main) Bukkit.getPluginManager().getPlugin("Thief");
	int delay = 0;
	private Random random = new Random();
	HashMap<Location, Integer> loc = new HashMap<Location, Integer>();
	HashMap<Location, Material> mat = new HashMap<Location, Material>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPound(PlayerInteractEvent e) {
		if (e.getPlayer().getItemInHand().getType() == Material.GOLD_INGOT && e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getPlayer().getItemInHand().getType() == Material.GOLD_INGOT && e.getAction() == Action.RIGHT_CLICK_AIR) {
			ArrayList<Block> blocks = BlockUtil.getNearbyBlocks(e.getPlayer().getLocation().subtract(-1, 1, -1), 2);
			for (final Block b : blocks) {
				loc.put(b.getLocation(), b.getTypeId());
				mat.put(b.getLocation(), b.getType());
				FallingBlock fb = b.getWorld().spawnFallingBlock(b.getLocation(), b.getType(), b.getData());
				b.setType(Material.AIR);
				fb.setVelocity(new Vector(0, random.nextInt(3), 0));
				fb.setDropItem(false);
				delay = delay + 2;
				Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						delay = delay + -2;
						b.setTypeId(loc.get(b.getLocation()));
						b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, mat.get(b.getLocation()));
						loc.remove(b.getLocation());
					}
				}, delay);
			}
			for (Entity en : e.getPlayer().getNearbyEntities(6, 6, 6)) {
			if (en instanceof Player) {
				Player p = (Player)en;
				p.damage(5.0);
			}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLand(EntityChangeBlockEvent e) {
		if (e.getEntity() instanceof FallingBlock) {
			FallingBlock fb = (FallingBlock)e.getEntity();
			e.setCancelled(true);
			e.getEntity().getWorld().playEffect(fb.getLocation(), Effect.STEP_SOUND, fb.getBlockId());
		}
	}
}
