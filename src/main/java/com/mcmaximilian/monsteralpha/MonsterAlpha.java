package com.mcmaximilian.monsteralpha;

import com.mcmaximilian.monsteralpha.Event.PlayerEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class MonsterAlpha extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents( new PlayerEvent() , this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
