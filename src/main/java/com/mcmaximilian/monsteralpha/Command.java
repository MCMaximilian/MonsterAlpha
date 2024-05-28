package com.mcmaximilian.monsteralpha;

import com.mcmaximilian.monsteralpha.Utils.ServerUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Command implements CommandExecutor , TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String label, @NotNull String[] args) {
        if ( label.equalsIgnoreCase("alpha") ) {
            if ( args.length == 1) {
                if ( args[0].equalsIgnoreCase("level") && sender instanceof Player player) { //TODO: 서버 난이도를 정하는 부분
                    ServerUtil.onLevelSettingInventory( player );
                    player.sendMessage( Component.text("난이도를 결정하는 인벤토리를 열었습니다. 현재 서버의 레벨은 " + ServerUtil.ServerLevel + "입니다.").color(NamedTextColor.GREEN));
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, org.bukkit.command.@NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> list = new ArrayList<>();
        if ( label.equalsIgnoreCase("alpha")) {
            if ( args.length == 1 ) {
                list.add("level");
                return list;
            }
        }
        return null;
    }
}
