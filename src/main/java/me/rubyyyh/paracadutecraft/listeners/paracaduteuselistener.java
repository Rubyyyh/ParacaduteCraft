package me.rubyyyh.paracadutecraft.listeners;

import me.rubyyyh.paracadutecraft.ParacaduteCraft;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class paracaduteuselistener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent e) {

        Player p = e.getPlayer();


        if (!Objects.equals(e.getHand(), EquipmentSlot.OFF_HAND)) {
            return;
        }


        //Paracadute chiuso

        ItemStack paracadutebase = new ItemStack(Material.SHULKER_BOX);
        ItemMeta paracadutebase_meta = paracadutebase.getItemMeta();
        assert paracadutebase_meta != null;
        paracadutebase_meta.setDisplayName("Paracadute");
        paracadutebase.setItemMeta(paracadutebase_meta);


        // Paracadute aperto
        ItemStack paracaduteaperto = new ItemStack(Material.FEATHER);
        ItemMeta paracaduteaperto_meta = paracaduteaperto.getItemMeta();
        assert paracaduteaperto_meta != null;
        paracaduteaperto_meta.setDisplayName("Paracadute");
        paracaduteaperto.setItemMeta(paracaduteaperto_meta);


        if (!p.getInventory().getItemInOffHand().equals(paracadutebase)) {
            return;
        }

        if (p.isOnGround()) {
            return;
        }



        p.getInventory().setItemInOffHand(paracaduteaperto);
        p.playSound(p.getLocation(), Sound.ITEM_ARMOR_EQUIP_ELYTRA, 10L, 10L);


        if (p.getInventory().getItemInOffHand().equals(paracaduteaperto)) {


                new BukkitRunnable() {
                    @Override
                    public void run() {
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            if (!player.isOnGround() && player.getInventory().getItemInOffHand().equals(paracaduteaperto)) {

                                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 50, 1, true, false));
                            } else if(player.isOnGround() && player.getInventory().getItemInOffHand().equals(paracaduteaperto)) {
                                p.getInventory().setItemInOffHand(paracadutebase);
                            }
                        }
                    }
                }.runTaskTimer(ParacaduteCraft.plugin, 0, 10);
            }



        }


    }



