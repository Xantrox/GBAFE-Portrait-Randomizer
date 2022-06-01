package files;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import models.ImgFile;

public class FilePathManager {
	private ArrayList<ImgFile> chest = new ArrayList<ImgFile>();
	final int width = 96; // Pixels
	final int height = 80; // Pixels
	private String selectedDirectory;
	
	public FilePathManager() {
		
	}

	public String browseDirectory(String currentDir) throws IOException {
		/*
		 * //A bad attempt at trying to make the Java FileChooser look like Windows
		 * FileDialog diag = new FileDialog((Frame)null, "Select File to Open");
		 * diag.setMode(FileDialog.LOAD); diag.setVisible(true);
		 */
		selectedDirectory = checkDirectory(currentDir);
		
		JFileChooser chooser = new JFileChooser();
		//chooser.setCurrentDirectory(new java.io.File(selectedDirectory));
		chooser.setDialogTitle("Select the root folder");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setSelectedFile(new java.io.File(new java.io.File(selectedDirectory).getCanonicalPath()));
		chooser.setCurrentDirectory(new java.io.File(selectedDirectory));
		chooser.showSaveDialog(null);
		//chooser.setApproveButtonText(new java.io.File(selectedDirectory).toString());
		selectedDirectory = chooser.getSelectedFile().toString();
		return selectedDirectory;
	}
	
	private String checkDirectory(String currentDir) {
		String selectedDir;
		if(currentDir.isEmpty()) {
			selectedDir = ".";
		} else {
			selectedDir = currentDir;
		}
		return selectedDir;
	}

	private ArrayList<ImgFile> getImageFiles(String tmpPath, ArrayList<File> files, Boolean checkSub) {
		ArrayList<ImgFile> chest = new ArrayList<ImgFile>();
		File tmpF = new File(tmpPath);
		
		// Original solution: https://stackoverflow.com/questions/19714235/how-to-get-png-files-alone-from-one-folder
		// https://stackoverflow.com/questions/14676407/list-all-files-in-the-folder-and-also-sub-folders/14676464#14676464
		File[] fList = tmpF.listFiles();
	    if(fList != null)
	        for (File file : fList) { 
	        	// Doen't check if file is at least 96 x 80 px. Doing so makes it run slow. Please try to use bigger images as files.
	            if (file.isFile() && file.getName().toLowerCase().endsWith(".png")) {
	            	files.add(file);
	            } else if (file.isDirectory() && checkSub) {
	                getImageFiles(file.getAbsolutePath(), files, checkSub);
	            }
	        }
		ImgFile imgF;

		int i = 0;
		while (files.size() > i) {
			imgF = new ImgFile();
			imgF.setParam(files.get(i));
			chest.add(imgF);
			i++;
		}
		
		return chest;
	}

	public BufferedImage getPortrait(String tmpPath, int index, Boolean checkSub) {	
		BufferedImage randPort;
		BufferedImage resImg;
		Graphics2D g2d;
		chest = getImageFiles(tmpPath, new ArrayList<File>(), checkSub);
		
		//Can fail if images are smaller than 96 x 80
		try {
			randPort = ImageIO.read(new File(chest.get(index).imgPath));
			Image tmp = randPort.getSubimage(0, 0, width, height).getScaledInstance(width * 4, height * 4,
					Image.SCALE_SMOOTH);
			resImg = new BufferedImage(width * 4, height * 4, BufferedImage.TYPE_INT_ARGB);

			g2d = resImg.createGraphics();
			g2d.drawImage(tmp, 0, 0, null);
			g2d.dispose();

			return resImg;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getImgName(String tmpPath, int index, Boolean checkSub, Boolean completeName) {	
		String portName;
		chest = getImageFiles(tmpPath, new ArrayList<File>(), checkSub);
		
		if(!completeName) {
			portName = chest.get(index).imgName.toString();
		} else {
			portName = chest.get(index).imgPath.toString();
		}
		return portName;
	}
	
	public void exportPortraits(String tmpPath, int index, Boolean checkSub) throws IOException {
		String originalPath = getImgName(tmpPath, index, checkSub, true);
		File src = new File(originalPath);
		// Weird error
		// System.out.println(src.getName());
		String exportPath = new File(".").getCanonicalPath().toString() + "/0Export/" + src.getName();
		File dst = new File(exportPath);
		// https://stackoverflow.com/questions/16433915/how-to-copy-file-from-one-location-to-another-location
		// https://stackoverflow.com/questions/1146153/copying-files-from-one-directory-to-another-in-java
		try {
			Files.copy(src.toPath(), dst.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	public Integer generateIndex(String tmpPath, Boolean checkSub) {
		chest = getImageFiles(tmpPath, new ArrayList<File>(), checkSub);
		int index;
		if(chest.size() > 0) {
			if(chest.size() > 8) {
				index = ThreadLocalRandom.current().nextInt(0, chest.size());
			}
			else {
				JOptionPane.showMessageDialog(null, "Not enough files to randomize.");
				index = (Integer) null;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Files not found.");
			index = (Integer) null;
		}
		
		return index;
	}
}