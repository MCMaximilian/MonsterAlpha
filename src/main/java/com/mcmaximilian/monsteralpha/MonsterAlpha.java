package com.mcmaximilian.monsteralpha;

import com.mcmaximilian.monsteralpha.Event.EntitySetupEvent;
import com.mcmaximilian.monsteralpha.Event.PlayerEvent;
import com.mcmaximilian.monsteralpha.Event.SystemEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class MonsterAlpha extends JavaPlugin {

    private static final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

    @SuppressWarnings("DataFlowIssue")
    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents( new PlayerEvent() , this );
        getServer().getPluginManager().registerEvents( new EntitySetupEvent() , this );
        getServer().getPluginManager().registerEvents( new SystemEvent(), this );
        //TODO: EventHandler Class List for main class.

        getCommand("alpha").setExecutor( new Command() );
        getCommand("alpha").setTabCompleter( new Command() );
        //TODO: Command List ( and executor file loc )

        console.sendMessage( Component.text("MonsterAlpha Plugin has been enabled!").color(NamedTextColor.GREEN));
        //TODO: Console Message
    }

    @Override
    public void onDisable() {

        console.sendMessage( Component.text("MonsterAlpha Plugin has been disabled!").color(NamedTextColor.RED));
    }
}
