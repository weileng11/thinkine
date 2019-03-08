package com.gallery.model;

import java.io.Serializable;

/**
 * @author LittleLiByte
 * 
 */
public class FilmInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String filmName;
	private String filmImageLink;
	private String fileDetailUrl;
	
	private int rs;

	public FilmInfo(String filmName, String filmImageLink, String fileDetailUrl,int resIds) {
		super();
		this.filmName = filmName;
		this.filmImageLink = filmImageLink;
		this.fileDetailUrl = fileDetailUrl;
		this.rs=resIds;
	}

	
	


	public int getRs() {
		return rs;
	}





	public void setRs(int rs) {
		this.rs = rs;
	}





	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getFilmImageLink() {
		return filmImageLink;
	}

	public void setFilmImageLink(String filmImageLink) {
		this.filmImageLink = filmImageLink;
	}

	public String getFileDetailUrl() {
		return fileDetailUrl;
	}

	public void setFileDetailUrl(String fileDetailUrl) {
		this.fileDetailUrl = fileDetailUrl;
	}

	@Override
	public String toString() {
		return "FilmInfo [filmName=" + filmName + ", filmImageLink="
				+ filmImageLink + ", fileDetail=" + fileDetailUrl + "]";
	}

}
