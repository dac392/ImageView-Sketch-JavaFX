package util;

public class Photo {
	private String name;
	private String caption;
	private String filepath;
	
	public Photo(String name, String caption, String filepath) {
		this.name = name;
		this.caption = caption;
		this.filepath = filepath;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCaption() {
		return this.caption;
	}
	
	public String getURL() {
		return this.filepath;
	}
	
	
}
