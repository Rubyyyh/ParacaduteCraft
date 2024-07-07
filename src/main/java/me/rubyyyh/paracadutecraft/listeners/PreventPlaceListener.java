package me.rubyyyh.paracadutecraft.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class PreventPlaceListener implements Listener {

    @EventHandler
    public void onParacadutePlace(BlockPlaceEvent event) {

        Player player = (Player) event.getPlayer();
        Block block = event.getBlockPlaced();

        ItemStack paracadutebase = new ItemStack(Material.SHULKER_BOX);
        ItemMeta paracadutebase_meta = paracadutebase.getItemMeta();
        assert paracadutebase_meta != null;
        paracadutebase_meta.setDisplayName("Paracadute");
        paracadutebase.setItemMeta(paracadutebase_meta);

        if (player.getInventory().getItemInMainHand().getType() == Material.SHULKER_BOX || player.getInventory().getItemInOffHand().getType() == Material.SHULKER_BOX) {
            Material blockType = block.getType();

            if (blockType.equals(Material.SHULKER_BOX)) {
                event.setCancelled(true);

            }

        }


    }

    @EventHandler
    public void onParacaduteInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().getType() == Material.SHULKER_BOX || player.getInventory().getItemInOffHand().getType() == Material.SHULKER_BOX) {
            event.setCancelled(true);
        }

    }


}