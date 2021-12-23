package Main;

import org.bukkit.plugin.java.JavaPlugin;

import api.Conexao;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		Conexao.Open();
	}
	
	@Override
	public void onDisable() {
		Conexao.close();
	}
	
	public static Main getPlugin() {
		return getPlugin(Main.class);
	}
}
