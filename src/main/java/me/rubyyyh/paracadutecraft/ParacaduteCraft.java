package me.rubyyyh.paracadutecraft;

import me.rubyyyh.paracadutecraft.commands.ParacaduteCraftGiveCommand;
import me.rubyyyh.paracadutecraft.commands.ParacaduteCraftTabCompleter;
import me.rubyyyh.paracadutecraft.listeners.PreventPlaceListener;
import me.rubyyyh.paracadutecraft.listeners.paracaduteuselistener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class ParacaduteCraft extends JavaPlugin {


    public static ParacaduteCraft plugin;

    @Override
    public void onEnable() {
        System.out.println("ParacaduteCraft Abilitato");


        Bukkit.getPluginManager().registerEvents(new paracaduteuselistener(), this);
        Bukkit.getPluginManager().registerEvents(new PreventPlaceListener(), this);


        getCommand("paracadutecraft").setExecutor(new ParacaduteCraftGiveCommand());
        getCommand("paracadutecraft").setTabCompleter(new ParacaduteCraftTabCompleter());

        plugin = this;
    }}



