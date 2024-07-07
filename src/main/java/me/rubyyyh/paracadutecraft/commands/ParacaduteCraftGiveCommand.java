package me.rubyyyh.paracadutecraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ParacaduteCraftGiveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("paracadutecraft")) {
            if (args.length == 1 && args[0].equalsIgnoreCase("get")) {

                // /paracadute get
                if (sender instanceof Player player) {
                    if (player.hasPermission("paracadutecraft.commands.get")) {
                        giveParacadute(player);
                    } else {
                        player.sendMessage("Non hai il permesso per questo comando.");
                    }
                } else {
                    sender.sendMessage("Questo comando può essere eseguito solo da un giocatore.");
                }
                return true;
            } else if (args.length == 2 && args[0].equalsIgnoreCase("give")) {


                // /paracadute give <player>
                if (sender.hasPermission("paracadutecraft.commands.give")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target != null) {
                        giveParacadute(target);
                        sender.sendMessage("Hai dato un paracadute a " + target.getName());
                    } else {
                        sender.sendMessage("Player non online");
                    }
                } else {
                    sender.sendMessage("Non hai il permesso per eseguire questo comando.");
                }
                return true;
            }
        }
        return false;
    }

    private void giveParacadute(Player player) {
        ItemStack paracadutebase = new ItemStack(Material.SHULKER_BOX);
        ItemMeta paracadutebase_meta = paracadutebase.getItemMeta();
        assert paracadutebase_meta != null;
        paracadutebase_meta.setDisplayName("Paracadute");
        paracadutebase.setItemMeta(paracadutebase_meta);

        player.getInventory().addItem(paracadutebase);
        player.sendMessage("Hai ricevuto un paracadute.");
    }
}
