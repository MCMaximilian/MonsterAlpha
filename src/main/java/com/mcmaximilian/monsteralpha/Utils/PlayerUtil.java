package com.mcmaximilian.monsteralpha.Utils;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public class PlayerUtil {

    /**
     * Player의 데이터를 결정하는 함수
     * @param player = 이 플레이어의 속성값을 수정
     */
    public static void PlayerSetup(Player player) {

        //noinspection DataFlowIssue
        player.getAttribute( Attribute.GENERIC_MAX_HEALTH ).setBaseValue( 34.0f );
    }
}
