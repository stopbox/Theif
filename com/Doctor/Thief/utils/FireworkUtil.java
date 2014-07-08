package com.Doctor.Thief.utils;

import java.util.Random;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkUtil {

	static Random rand = new Random();



	public static void endFirework(Location loc){
		int x = rand.nextInt(5);
		Firework fw = (Firework) loc.getWorld().spawnEntity(loc,
				EntityType.FIREWORK);
		FireworkMeta fwmeta = fw.getFireworkMeta();
		FireworkEffect.Builder builder = FireworkEffect.builder();
		switch(x) {
		case 1:
			builder.withTrail().withFade(Color.RED)
			.withColor(Color.RED).withColor(Color.RED)
			.with(FireworkEffect.Type.BALL_LARGE);
			break;
		case 2:
			builder.withTrail().withFade(Color.AQUA)
			.withColor(Color.BLUE).withColor(Color.WHITE)
			.with(FireworkEffect.Type.BURST);
			break;
		case 3:
			builder.withTrail().withFade(Color.AQUA)
			.withColor(Color.BLUE).withColor(Color.WHITE)
			.with(FireworkEffect.Type.BALL_LARGE);
			break;
		case 4:
			builder.withTrail().withFade(Color.GREEN)
			.withColor(Color.GREEN).withColor(Color.LIME)
			.with(FireworkEffect.Type.CREEPER);
		default:
			builder.withTrail().withFade(Color.FUCHSIA)
			.withColor(Color.FUCHSIA).withColor(Color.FUCHSIA)
			.with(FireworkEffect.Type.STAR);
			break;
		}
		fwmeta.addEffect(builder.build());
		fwmeta.setPower(1);
		fw.setFireworkMeta(fwmeta);
//		fw.detonate();
	}

}
