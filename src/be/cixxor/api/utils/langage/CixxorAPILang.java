package be.cixxor.api.utils.langage;

import be.cixxor.api.utils.MotdManager;
import be.cixxor.api.utils.TabManager;
import be.cixxor.api.utils.sql.SQLConnectionCAPI;

public class CixxorAPILang {
	
	public static LangageManager getLanguageSystem() {
		return LangageManager.getInstance();
	}
	
	public static MotdManager getMotdSystem() {
		return MotdManager.getInstance();
	}
	
	public static SQLConnectionCAPI getPlayerInfos() {
		return SQLConnection.player_infos;
	}
	
	public static TabManager getTabManager() {
		return TabManager.getInstance();
	}
	
	
	
	
}
