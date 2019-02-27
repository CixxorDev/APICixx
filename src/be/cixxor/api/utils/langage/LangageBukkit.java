package be.cixxor.api.utils.langage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LangageBukkit {
	
	static LangageBukkit instance;
	
	public void broadcastMsg(String french, String english) {
		for(Player pls : Bukkit.getOnlinePlayers()) {
			if(LangageManager.getInstance().isFrench(pls.getUniqueId())) {
				pls.sendMessage(french);
			}
			else if(LangageManager.getInstance().isEnglish(pls.getUniqueId())) {
				pls.sendMessage(english);
			} else {
				pls.sendMessage(french);
			}
		}
	}
	
	public static LangageBukkit getInstance() {return instance;}
}
