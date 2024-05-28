package com.mcmaximilian.monsteralpha.Utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ServerUtil {

    public static Integer ServerLevel = 1;

    private static final Component LevelSettingInventoryName = Component.text("서버 난이도 세팅!").color(NamedTextColor.GREEN).decoration( TextDecoration.BOLD , true);

    public static HashMap<UUID , Inventory> LevelSettingInventoryMap = new HashMap<>();

    /**
     * 서버 난이도를 정하는 인벤토리를 Map에 넣고, 플레이어에게 열도록 하는 함수
     */
    public static void onLevelSettingInventory(Player player) {

        Inventory inventory = Bukkit.getServer().createInventory( null , 9 , LevelSettingInventoryName );

        inventory.setItem( 0 , new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
        inventory.setItem( 1, onLevelSettingInventoryItem( 1 ));
        inventory.setItem( 2, onLevelSettingInventoryItem( 2 ));
        inventory.setItem( 3, onLevelSettingInventoryItem( 3 ));
        inventory.setItem( 4, onLevelSettingInventoryItem( 4 ));
        inventory.setItem( 5, onLevelSettingInventoryItem( 5 ));
        inventory.setItem( 6, onLevelSettingInventoryItem( 6 ));
        inventory.setItem( 7, onLevelSettingInventoryItem( 7 ));
        inventory.setItem( 8, new ItemStack( Material.WHITE_STAINED_GLASS_PANE ));

        LevelSettingInventoryMap.put( player.getUniqueId() , inventory );

        player.openInventory( inventory );
    }

    /**
     * 인벤토리에 들어가는 아이템들을 정의하는 함수
     * @param slotCode = 들어갈 아이템의 난이도
     * @return = 그 블록
     */
    private static ItemStack onLevelSettingInventoryItem( Integer slotCode ) {
        if ( slotCode == 1) {
            ItemStack item = new ItemStack( Material.WHITE_CONCRETE );

            ItemMeta meta = item.getItemMeta();

            meta.displayName( Component.text("1단계").color(NamedTextColor.WHITE));

            List<Component> lore = new ArrayList<>();
            lore.add( Component.text("초심자들을 위한 쉬운 난이도 입니다!"));
            lore.add( Component.text("난이도: 보통").color(NamedTextColor.GREEN));
            meta.lore( lore );

            item.setItemMeta( meta );

            return item;
        }
        else if ( slotCode == 2) {
            ItemStack item = new ItemStack( Material.YELLOW_CONCRETE );

            ItemMeta meta = item.getItemMeta();

            meta.displayName( Component.text("2단계").color(NamedTextColor.WHITE));

            List<Component> lore = new ArrayList<>();
            lore.add( Component.text("몹이 약간 강해집니다!"));
            lore.add( Component.text("난이도: 보통").color(NamedTextColor.GREEN));
            meta.lore( lore );

            item.setItemMeta( meta );

            return item;
        }
        else if ( slotCode == 3) {
            ItemStack item = new ItemStack( Material.LIME_CONCRETE );

            ItemMeta meta = item.getItemMeta();

            meta.displayName( Component.text("3단계").color(NamedTextColor.WHITE));

            List<Component> lore = new ArrayList<>();
            lore.add( Component.text("난이도가 어려움이 됩니다. 나머지는 2단계와 같습니다."));
            lore.add( Component.text("난이도: 어려움").color(NamedTextColor.RED));
            meta.lore( lore );

            item.setItemMeta( meta );

            return item;
        }
        else if ( slotCode == 4 ) {
            ItemStack item = new ItemStack( Material.GREEN_CONCRETE );

            ItemMeta meta = item.getItemMeta();

            meta.displayName( Component.text("4단계").color(NamedTextColor.WHITE));

            List<Component> lore = new ArrayList<>();
            lore.add( Component.text("3단계에서 난이도가 조금 더 올라갑니다!"));
            lore.add( Component.text("난이도: 어려움").color(NamedTextColor.RED));
            meta.lore( lore );

            item.setItemMeta( meta );

            return item;
        }
        else if ( slotCode == 5) {
            ItemStack item = new ItemStack( Material.RED_CONCRETE );

            ItemMeta meta = item.getItemMeta();

            meta.displayName( Component.text("5단계").color(NamedTextColor.WHITE));

            List<Component> lore = new ArrayList<>();
            lore.add( Component.text("4단계에서 난이도가 조금 더 올라가고, 장비가 강해집니다."));
            lore.add( Component.text("난이도: 어려움").color(NamedTextColor.RED));
            meta.lore( lore );

            item.setItemMeta( meta );

            return item;
        }
        else if ( slotCode == 6) {
            ItemStack item = new ItemStack( Material.GRAY_CONCRETE );

            ItemMeta meta = item.getItemMeta();

            meta.displayName( Component.text("6단계").color(NamedTextColor.WHITE));

            List<Component> lore = new ArrayList<>();
            lore.add( Component.text("6단계는 몹이 매우 강해지며, 일정한 시간을 주기로 위험한 몬스터가 소환됩니다."));
            lore.add( Component.text("난이도: 어려움").color(NamedTextColor.RED));
            meta.lore( lore );

            item.setItemMeta( meta );

            return item;
        }
        else if ( slotCode == 7 ) {
            ItemStack item = new ItemStack( Material.BLACK_CONCRETE );

            ItemMeta meta = item.getItemMeta();

            meta.displayName( Component.text("7단계").color(NamedTextColor.WHITE));

            List<Component> lore = new ArrayList<>();
            lore.add( Component.text("악몽").color(NamedTextColor.DARK_RED).decoration( TextDecoration.BOLD , true));
            lore.add( Component.text("난이도: 어려움").color(NamedTextColor.RED));
            meta.lore( lore );

            item.setItemMeta( meta );

            return item;
        }
        return null;
    }

}
