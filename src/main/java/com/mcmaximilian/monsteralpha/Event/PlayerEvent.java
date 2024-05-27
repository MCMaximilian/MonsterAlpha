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
import org.bukkit.event.entity.PlayerDeathEvent;

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
            event.setCancelled( true );
        }
    }

    /**
     * 플레이어들의 세팅을 정하는 함수
     */
    @EventHandler
    public void onPlayerSettingEvent(ServerTickStartEvent event) {
        for (World world : Bukkit.getServer().getWorlds() ) { //TODO: 월드를 다 가져오기
            for ( Player player : world.getPlayers() ) { //TODO: 월드에서 플레이어를 다 가져오기
                PlayerUtil.PlayerSetup( player );
            }
        }
    }

    /**
     * 사람이 죽었을 때 위치와 함께 월드를 알려주는 명령어
     * @param event = Deathevent
     */
    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent event) {

        Player player = event.getPlayer();

        String playerName = player.getName();
        String playerWorldName = player.getWorld().getKey().getKey();
        int xPos = player.getLocation().getBlockX();
        int yPos = player.getLocation().getBlockY();
        int zPos = player.getLocation().getBlockZ();

        Component component = Component.text( playerName + "이(가)").color(NamedTextColor.GREEN);
        component = component.append( Component.text(playerWorldName + "에 " + xPos + " , " + yPos + " , " + zPos + " 에서").color(NamedTextColor.YELLOW ));
        component = component.append( Component.text(" 사망하였습니다").color(NamedTextColor.RED));

        event.deathMessage( Component.text(""));

        Bukkit.getServer().broadcast( component );
    }
}
