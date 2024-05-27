package com.mcmaximilian.monsteralpha.Utils;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

public class PlayerUtil {

    private static final Float playerHealth = 34.0f ;

    /**
     * Player의 데이터를 결정하는 함수
     * @param player = 이 플레이어의 속성값을 수정
     */
    @SuppressWarnings("DataFlowIssue")
    public static void PlayerSetup(Player player) {

        player.getAttribute( Attribute.GENERIC_MAX_HEALTH ).setBaseValue( playerHealth );
    }
}
