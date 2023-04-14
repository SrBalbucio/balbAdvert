package me.balbucio.ad;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Advert extends Command {
    public Advert() {
        super("advert");
    }

    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("badv.use")) {
            if (args.length == 0) {
                sender.sendMessage("§abalbAdvert §f- §eAtivo!");
                sender.sendMessage("§cUse /advert <mensagem>");
            }

            if (args.length > 0) {
                String message = null;
                for (int i = 0; i < args.length; i++) {
                    if (message == null) {
                        message = args[i];
                    } else {
                        message += " " + args[i];
                    }
                }
                for (ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
                    all.sendMessage(Main.getInstance().prefix + " " + message.replace("&", "§"));
                }
            }
        }
    }
}
