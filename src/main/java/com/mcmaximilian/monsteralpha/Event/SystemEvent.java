package com.mcmaximilian.monsteralpha.Event;

import com.mcmaximilian.monsteralpha.Utils.ServerUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.apache.commons.lang3.SystemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import static com.mcmaximilian.monsteralpha.Utils.ServerUtil.*;

public class SystemEvent implements Listener {

    /**
     * 서버 레벨을 정할 때 클릭을 감지하는 이벤트
     * @param event = InventoryClickEvent
     */
    @EventHandler
    public void onPlayerClickInventoryEvent(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getClickedInventory();
        int slot = event.getSlot();

        if (LevelSettingInventoryMap.containsKey( player.getUniqueId())) {
            if ( LevelSettingInventoryMap.get( player.getUniqueId() ).equals( inventory )) { //TODO: 감지 코드
                if ( slot >=1 && slot <= 7 ) {
                    ServerLevel = slot ;
                    Bukkit.getServer().broadcast(Component.text("서버의 레벨을 " + ServerLevel + "로 설정하였습니다!").color(NamedTextColor.GREEN));
                    player.closeInventory();
                    LevelSettingInventoryMap.remove( player.getUniqueId() );
                }
                event.setCancelled( true );
            }
        }
    }
}
