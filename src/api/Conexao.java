package api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

import Main.Main;

public class Conexao {
	public static Connection con = null;
	public static ConsoleCommandSender sc = Bukkit.getConsoleSender();
	
	public static void Open() {
		String url = "jdbc:mysql://localhost:3306/tutorial";
		//TYPE + HIST + PORT + DATABASENAME
		String user = "root";
		String password = "bcd127";
		
		try {
			con = DriverManager.getConnection(url, user, password);
			sc.sendMessage(ChatColor.GREEN + "Conexão com o banco de dados!");
		} catch (Exception e) {
			sc.sendMessage(ChatColor.RED + "[ERRO] Não efetuado a conexão com o banco!");
			Main.getPlugin().getPluginLoader().disablePlugin(Main.getPlugin());
		}
	}
	
	public static void close() {
		if(con != null) {
			try {
				con.close();
				sc.sendMessage(ChatColor.GREEN + "Conexão Fechada com o banco de dados!");
			} catch (Exception e) {
				sc.sendMessage(ChatColor.RED + "ERRO 404");
			}
		}
	}
	
	public static void createTable() {
		if(con != null) {
			PreparedStatement stm = null;
			try {
				stm = con.prepareStatement("CREATE TABLE IF NOT EXISTS `cash`(`player` VARCHAR(24), `quantia` DOUBLE())");
				stm.executeUpdate();
				sc.sendMessage(ChatColor.DARK_PURPLE+"Dados da tabelas carregados");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
