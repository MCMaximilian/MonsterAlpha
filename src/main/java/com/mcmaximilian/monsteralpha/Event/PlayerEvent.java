package com.mcmaximilian.monsteralpha.Event;

import com.destroystokyo.paper.event.server.ServerTickStartEvent;
import com.mcmaximilian.monsteralpha.Utils.PlayerUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerEvent implements Listener {

    /**
     * 사람들이 누군가를 때릴 경우, 취소하는 이벤트
     */
    @EventHandler
    public void onPlayerAttackCancelEvent(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity damaged = event.getEntity();
        if ( damager instanceof Player player && damaged instanceof Player) {
            player.sendMessage(Component.text("이 서버에서는 사람을 때릴 수 없습니다!").color(NamedTextColor.RED));
        }
    }

    /**
     * 플레이어들의 세팅을 정하는 함수
     */
    @EventHandler
    public void onPlayerSettingEvent(ServerTickStartEvent event) {
        for (World world : Bukkit.getServer().getWorlds() ) {
            for ( Player player : world.getPlayers() ) {
                PlayerUtil.PlayerSetup( player );
            }
        }
    }
}
