package com.mcmaximilian.monsteralpha.Event;

import com.destroystokyo.paper.event.server.ServerTickStartEvent;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Stray;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static com.mcmaximilian.monsteralpha.Utils.EntityUtil.*;

public class EntitySetupEvent implements Listener {

    /**
     * 몬스터를 강화하는 부분 ( 매 틱마다 몬스터를 감지한다 )
     * @param event = ServerTickStartEvent
     */
    @EventHandler
    public void onMonsterSetupEvent(ServerTickStartEvent event) {
        for (World world : Bukkit.getServer().getWorlds() ) {
            for (Entity entity : world.getEntities() ) {

                if ( entity instanceof Skeleton skeleton ) {
                    onSkeletonSetUp( skeleton );
                }
                else if ( entity instanceof Stray stray ) {
                    onStraySetup( stray );
                }
            }
        }
    }
}
