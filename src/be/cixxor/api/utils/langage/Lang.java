package be.cixxor.api.utils.langage;

public enum Lang {
	
	fr("Français","fr"),
	eng("English","eng");
	
	private String name;
	private String langage;
	
	private Lang(String name, String langage) {
		this.name = name;
		this.langage = langage;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPrefix() {
		return langage;
	}
	
	public static Lang getByName(String name) {
		for(Lang lang : Lang.values()){
			if(lang.name.equalsIgnoreCase(name)) {
				return lang;
			}
		}
		return null;
	}
	
	
	
}
