package com.mcmaximilian.monsteralpha.Utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Stray;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EntityUtil {


    /**
     * 스켈레톤을 수정하는 명령어
     * @param skeleton = 스켈레톤
     */
    public static void onSkeletonSetUp(Skeleton skeleton) {

        skeleton.setCanPickupItems( false ); //TODO: 아이템을 못들게 하는 명령어
        skeleton.getEquipment().setItemInMainHand( onSkeletonBow() );
        skeleton.getEquipment().setDropChance( EquipmentSlot.HAND , 0.0f );
    }

    /**
     * 스트레이를 수정하는 명령어
     * @param stray = 스트레이
     */
    public static void onStraySetup(Stray stray) {
        stray.setCanPickupItems( false ); //TODO: 아이템을 못들게 하는 명령어
        stray.getEquipment().setItemInMainHand( onSkeletonBow() );
        stray.getEquipment().setDropChance( EquipmentSlot.HAND , 0.0f );
    }

    public static void onZombieSetUp(Zombie zombie) {
        ItemStack sword = new ItemStack( Material.IRON_SWORD );
        sword.addEnchantment( Enchantment.DAMAGE_ALL , 2 );

    }

    /**
     * 힘 3 활을 만드는 함수
     * @return = 힘 3활을 itemstack의 형태로 반환
     */
    private static ItemStack onSkeletonBow() {
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta meta = bow.getItemMeta();
        meta.addEnchant(Enchantment.ARROW_DAMAGE , 3, true);
        bow.setItemMeta( meta );

        return bow;
    }
}
