package api;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.bukkit.entity.Player;

public class Metodos extends Conexao{
	
	public static boolean contains(Player player) {
		PreparedStatement stm = null;
		
		try {
			stm = con.prepareStatement("SELECT * FROM `cash` WHERE `player` = ?");
			stm.setString(1, player.getUniqueId().toString());
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public static void setPlayer(Player player) {
		PreparedStatement stm = null;
		
		try {
			stm = con.prepareStatement("INSERT INTO `cash` (`player`, `quantia`) VALUES (? ,?)");
			stm.setString(1, player.getUniqueId().toString());
			stm.setDouble(2, 0);
			stm.executeUpdate();
		} catch (Exception e) {
			
		}
	}
}
