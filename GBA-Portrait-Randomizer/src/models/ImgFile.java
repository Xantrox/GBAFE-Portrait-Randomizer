package models;

import java.io.File;

public class ImgFile {
	public File img;
	public String imgName;
	public String imgPath;

	public void setParam(File tmp) {
		this.img = tmp;
		this.imgName = img.getName();
		this.imgPath = img.getAbsolutePath();
	}
}