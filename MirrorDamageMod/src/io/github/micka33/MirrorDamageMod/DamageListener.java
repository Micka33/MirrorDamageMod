/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.micka33.MirrorDamageMod;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 *
 * @author Micka
 */
public class DamageListener implements Listener {
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamaged(EntityDamageByEntityEvent event)
    {
        if ((event.getEntity() instanceof Player && event.getDamager() instanceof Player) &&
            (((Player)event.getEntity()).getPlayerListName().equalsIgnoreCase("osuper") || ((Player)event.getEntity()).getPlayerListName().equalsIgnoreCase("beber7")) &&
            (((Player)event.getDamager()).getPlayerListName().equalsIgnoreCase("osuper") || ((Player)event.getDamager()).getPlayerListName().equalsIgnoreCase("beber7"))
           )
        {
            event.setCancelled(true);
            Player damager = (Player)event.getDamager();
            ArrayList<PotionEffect> effects = new ArrayList<>();
            effects.add(new PotionEffect(PotionEffectType.BLINDNESS, 20*10, 10, true));
            effects.add(new PotionEffect(PotionEffectType.SLOW, 20*2, 5, true));
            effects.add(new PotionEffect(PotionEffectType.POISON, 20*2, 1, true));
            damager.addPotionEffects(effects);
            damager.damage(event.getDamage());
            damager.sendMessage("You've been punished by Wine'not Server");
            Bukkit.broadcastMessage("Wine'not Server has punished "+damager.getPlayerListName());
        }
    }
}
