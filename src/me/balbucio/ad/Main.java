package me.balbucio.ad;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Main extends Plugin {
    private static Main instance;
    public String prefix;

	private File file = new File("plugins/balbAdvert", "config.yml");
	private Configuration configuration;

	@Override
    public void onEnable() {
        setInstance(this);
		this.prefix = configuration.getString("prefix");
        BungeeCord.getInstance().pluginManager.registerCommand(this, new Advert());
        BungeeCord.getInstance().getConsole().sendMessage(new TextComponent("§c[BalbucioAdvert] §2Ativado com sucesso!"));
    }

	@Override
	public void onLoad(){
		loadFiles();
	}

	private void loadFiles(){
		try {
			if (!file.exists()) {
				File folder = file.getParentFile();
				if (!folder.exists()) {
					folder.mkdir();
				}
				Files.copy(this.getResourceAsStream("config.yml"), file.toPath());
			}
			configuration = YamlConfiguration.getProvider(YamlConfiguration.class).load(file);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

    public static Main getInstance() {
        return instance;
    }

    private static void setInstance(final Main instance) {
        Main.instance = instance;
    }
}
