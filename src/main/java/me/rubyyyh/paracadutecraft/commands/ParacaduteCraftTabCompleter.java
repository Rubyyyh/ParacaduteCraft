package me.rubyyyh.paracadutecraft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ParacaduteCraftTabCompleter implements TabCompleter {


    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();


        if (command.getName().equalsIgnoreCase("paracadutecraft")) {
            if (args.length == 1) {
                completions.add("get");
                completions.add("give");
            } else if (args.length == 2 && args[0].equalsIgnoreCase("give") && sender instanceof Player) {
                Player player = (Player) sender;
                for (Player onlinePlayer : player.getServer().getOnlinePlayers()) {
                    completions.add(onlinePlayer.getName());
                }
            }
        }

        return completions;
    }


}

