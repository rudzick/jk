package de.cimdata.imageviewer.data;

public class Picture {
	
	private String description="";
	private String title ="";
	private String path="";
	
	public Picture(){
		this("Description Description Description Description",
				"Bild Title","img/La1.jpg");
	}
	public Picture(String description, String title, String path) {
		
		this.description = description;
		this.title = title;
		this.path = path;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "Picture [description=" + description + ", title=" + title
				+ ", path=" + path + "]";
	}
	
	

}
