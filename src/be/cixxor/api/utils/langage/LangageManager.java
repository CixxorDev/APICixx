package be.cixxor.api.utils.langage;

import java.util.UUID;

public class LangageManager {
	
	static final LangageManager instance = new LangageManager();
	public static LangageManager getInstance() {return instance;}
	
	public void setLangage(UUID uuid, Lang langage) {
		SQLConnection.player_infos.setLangage(uuid, langage.getPrefix());
	}
	
	public Lang getLanguage(UUID uuid) {
		return Lang.getByName(SQLConnection.player_infos.getLangage(uuid));
	}
	
	public Boolean isFrench(UUID uuid) {
		return this.getLanguage(uuid) == Lang.fr;
	}
	
	public Boolean isEnglish(UUID uuid) {
		return this.getLanguage(uuid) == Lang.eng;
	}
	
	public String returnStringPlayerLangage(UUID uuid, String french, String english) {
		if(isFrench(uuid)) return french;
		else if(isEnglish(uuid)) return english;
		return french;
	}
	
	public String getLanguageName(UUID uuid) {
		if(isFrench(uuid)) return Lang.fr.getName();
		if(isEnglish(uuid)) return Lang.eng.getName();
		return Lang.fr.getName();
	}
	
	public void broadcastMessage(String french, String english) {
		LangageBukkit.getInstance().broadcastMsg(french, english);
	}
}
