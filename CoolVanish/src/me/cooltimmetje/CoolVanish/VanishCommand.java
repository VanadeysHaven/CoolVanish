package me.cooltimmetje.CoolVanish;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Tim on 5-1-2015.
 */
public class VanishCommand implements CommandExecutor {

    @Override
    @SuppressWarnings("ambiguous")
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player p = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("v")){
            if(p.hasPermission("coolvanish.use")){
                if(!Main.vansihedPlayers.contains(p.getName())){
                    for(Player pl : Bukkit.getServer().getOnlinePlayers()){
                        if(!pl.getName().equals(p.getName())){
                            if (!pl.hasPermission("coolvanish.see")){
                                pl.hidePlayer(p);
                            }
                        }
                    }
                    p.sendMessage(Main.PluginTag + "You have been vanished.");
                    Main.vansihedPlayers.add(p.getName());
                    return true;
                } else {
                   for(Player pl : Bukkit.getServer().getOnlinePlayers()){
                       if(!pl.getName().equals(p.getName())){
                           if(!pl.hasPermission("coolvanish.see")){
                               pl.showPlayer(p);
                           }
                       }
                   }
                    p.sendMessage(Main.PluginTag + "You have been unvanished.");
                    Main.vansihedPlayers.remove(p.getName());
                    return true;
                }
            }
        } else {
            p.sendMessage(Main.PluginTag + "&cYou do not have permission to do that".replace('&', '§'));
            return false;
        }
        return false;
    }
}
