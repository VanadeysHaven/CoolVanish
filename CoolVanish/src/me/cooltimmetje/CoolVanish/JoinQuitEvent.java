package me.cooltimmetje.CoolVanish;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Tim on 5-1-2015.
 */
public class JoinQuitEvent implements Listener {

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        for(Player pl : Bukkit.getServer().getOnlinePlayers()){
            if(!pl.getName().equals(p.getName())){
                if(Main.vansihedPlayers.contains(pl.getName())){
                    if(!p.hasPermission("coolvanish.see")) {
                        p.hidePlayer(pl);
                    }
                } else {
                    p.showPlayer(pl);
                }
            }
        }

    }

}
