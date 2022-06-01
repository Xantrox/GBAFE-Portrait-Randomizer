package main;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import portraits.GUI;

public class Main {
	
	//public static ArrayList<GenericClass> chest = new ArrayList<GenericClass>();

	public static void main(String[] args) {
		//Makes Java UI components look and feel like in Windows
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		GUI myGUI = new GUI();
		myGUI.windowConfig();
		
		//https://stackoverflow.com/questions/621835/how-to-extract-part-of-this-image-in-java
		//https://stackoverflow.com/questions/5895829/resizing-image-in-java
		//https://stackoverflow.com/questions/40255039/how-to-choose-file-in-java
	}
}