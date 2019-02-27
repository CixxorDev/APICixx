package be.cixxor.api.utils.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class SQLConnectionCAPI {
	
	private String baseurl;
	private String host;
	private String database;
	private String username;
	private String password;
	private String table;
	private Connection connection;
	
	public SQLConnectionCAPI(String baseurl, String host, String database, String username, String password, String table) {
		this.baseurl = baseurl;
		this.host = host;
		this.database = database;
		this.username = username;
		this.password = password;
		this.table = table;
	}
	
	public void connection(){
		if(!isConnected()) {
			try {
				this.connection = DriverManager.getConnection(this.baseurl + this.host + "/" + this.database);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void disconnect() {
		if(isConnected()) {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isConnected() {
		try {
			if(this.connection == null || this.connection.isClosed() || this.connection.isValid(5)) {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private Connection getConnection() {
		return this.connection;
	}
	
	public void createPlayerAccount(UUID uuid) {
		try {
			PreparedStatement st = getConnection().prepareStatement("SELECT pseudo FROM " + this.table + " WHERE UUID = ?");
			st.setString(1, uuid.toString());
			ResultSet rs = st.executeQuery();
			if(!rs.next()) {
				st.close();
				PreparedStatement st2 = getConnection().prepareStatement("INSERT INTO " + this.table + " (uuid, pseudo, langage, allowmsg) VALUES (?, ?, ?, ?)");
				st2.setString(1, uuid.toString());
				st2.setString(2, Bukkit.getPlayer(uuid).getName());
				st2.setString(3, "fr");
				st2.setInt(4, 1);
				st2.executeUpdate();
				st2.close();
			}
			updatePlayerName(Bukkit.getPlayer(uuid));
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePlayerName(Player player) {
		try {
			PreparedStatement st = getConnection().prepareStatement("SELECT pseudo FROM " + this.table + " WHERE UUID = ?");
			st.setString(1, player.getUniqueId().toString());
			ResultSet rs = st.executeQuery();
			if(!rs.next()) {
				return;
			}
			if(!rs.getString("pseudo").equals(player.getName())) {
				st.close();
				PreparedStatement stp = getConnection().prepareStatement("UPDATE " + this.table + " SET pseudo = ? WHERE UUID = ?");
				stp.setString(1, player.getName());
				stp.setString(2, player.getUniqueId().toString());
				stp.executeUpdate();
				stp.close();
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setLangage(UUID uuid, String langage) {
		try {
			PreparedStatement sts = getConnection().prepareStatement("UPDATE " + this.table + " SET langage = ? WHERE UUID = ?");
			sts.setString(0, langage);
			sts.setString(1, uuid.toString());
			sts.executeUpdate();
			sts.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getLangage(UUID uuid) {
		String langage = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT langage FROM " + this.table + " WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			if(!rs.next()) {
				return langage;
			}
			langage = rs.getString("langage");
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return langage;
	}
	
	public void allowMessage(UUID uuid, Integer value) {
		
		try {
			PreparedStatement ps = getConnection().prepareStatement("UPDATE " + this.table + " SET allowmsg = ?");
			ps.setInt(1, value);
			ps.setString(2, uuid.toString());
			ps.executeQuery();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Integer getValueMSG(UUID uuid) {
		Integer value = null;
		try {
			PreparedStatement ps = getConnection().prepareStatement("SELECT allowmsg FROM " + this.table + " WHERE UUID = ?");
			ps.setString(1, uuid.toString());
			ResultSet rs = ps.executeQuery();
			if(!rs.next()) {
				return value;
			}
			value = rs.getInt("allowmsg");
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return value;
	}
}
