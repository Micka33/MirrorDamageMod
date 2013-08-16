/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.micka33.MirrorDamageMod;
import org.bukkit.plugin.java.JavaPlugin;


/**
 *
 * @author Micka
 */
public class MirrorDamageMod extends JavaPlugin {

    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
        System.out.println("[MirrorDamageMod] version 0.1 [Micka33] loaded");
    }
    
    @Override
    public void onDisable()
    {
        System.out.println("[MirrorDamageMod] version 0.1 [Micka33] un-loaded");
    }
    

}
