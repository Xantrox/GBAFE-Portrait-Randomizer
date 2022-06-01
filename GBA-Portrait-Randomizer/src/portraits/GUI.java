package portraits;

import java.awt.Color;
import java.awt.Desktop;
//import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import files.FilePathManager;

public class GUI implements ActionListener {
	private String path = "";
	private ImageIcon myIcon;
	private JButton browseB;
	private JButton exportB;
	private JButton randAllB;
	private JButton randB1;
	private JButton randB2;
	private JButton randB3;
	private JButton randB4;
	private JButton lastB1;
	private JButton lastB2;
	private JButton lastB3;
	private JButton lastB4;
	private JButton openB1;
	private JButton openB2;
	private JButton openB3;
	private JButton openB4;
	private JTextArea fPath;
	private JTextArea fName1;
	private JTextArea fName2;
	private JTextArea fName3;
	private JTextArea fName4;
	private JLabel pathLb;
	private JPanel port1;
	private JPanel port2;
	private JPanel port3;
	private JPanel port4;
	private JFrame frame;
	private JComboBox gendCombo;
	private JComboBox classCombo;
	private int cImg1 = -1;
	private int cImg2 = -1;
	private int cImg3 = -1;
	private int cImg4 = -1;
	private int pImg1 = -2;
	private int pImg2 = -2;
	private int pImg3 = -2;
	private int pImg4 = -2;
	private int tmpImg = -3;
	/*
	 * JScrollPane scroller1; JScrollPane scroller2; JScrollPane scroller3;
	 * JScrollPane scroller4; JScrollPane scroller5;
	 */

	public GUI() {

	}

	public void windowConfig() {
		pathLb = new JLabel();
		port1 = new JPanel();
		port2 = new JPanel();
		port3 = new JPanel();
		port4 = new JPanel();
		frame = new JFrame();
		browseB = new JButton("Browse");
		exportB = new JButton("Export");
		randAllB = new JButton("Randomize All");
		randB1 = new JButton("Randomize");
		randB2 = new JButton("Randomize");
		randB3 = new JButton("Randomize");
		randB4 = new JButton("Randomize");
		lastB1 = new JButton("Last");
		lastB2 = new JButton("Last");
		lastB3 = new JButton("Last");
		lastB4 = new JButton("Last");
		openB1 = new JButton("Open");
		openB2 = new JButton("Open");
		openB3 = new JButton("Open");
		openB4 = new JButton("Open");
		fPath = new JTextArea();
		fName1 = new JTextArea();
		fName2 = new JTextArea();
		fName3 = new JTextArea();
		fName4 = new JTextArea();

		// ComboBox setup & layout
		String[] gendArr = { "Any", "Male", "Female", "Other" };
		String[] classArr = { "Any", "Archer", "Brigand", "Cavalier", "Civilian", "Dancer", "Extra", "Fighter",
				"Healer", "Knigh", "Lord", "Mage", "Manakete", "Meme", "Merc", "Monk", "Monster", "Myrm",
				"Pegasus", "Pirate", "Shaman", "Soldier", "Thief", "Wyvern" };
		gendCombo = new JComboBox(gendArr);
		classCombo = new JComboBox(classArr);

		gendCombo.setFont(new Font("Arial", Font.PLAIN, 14));
		gendCombo.setBounds(1392, 70, 110, 30);
		gendCombo.setBackground(Color.white);
		gendCombo.setFocusable(false);

		classCombo.setFont(new Font("Arial", Font.PLAIN, 14));
		classCombo.setBounds(1522, 70, 110, 30); // (1308, 70, 130, 30);
		classCombo.setBackground(Color.white);
		classCombo.setFocusable(false);

		// Button layout
		browseB.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		browseB.setBounds(945, 70, 130, 30);
		browseB.setBackground(Color.lightGray);
		browseB.setFocusable(false);
		browseB.addActionListener(this);

		exportB.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		exportB.setBounds(958, 770, 130, 30);
		exportB.setBackground(Color.lightGray);
		exportB.setFocusable(false);
		exportB.addActionListener(this);

		randAllB.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		randAllB.setBounds(748, 770, 130, 30);
		randAllB.setBackground(Color.lightGray);
		randAllB.setFocusable(false);
		randAllB.addActionListener(this);

		port1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		port1.setLayout(new GridLayout(1, 1)); // GridLayout
		port1.setBounds(60, 280, 384, 320);

		randB1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		randB1.setBounds(289, 630, 110, 30);
		randB1.setBackground(Color.lightGray);
		randB1.setFocusable(false);
		randB1.addActionListener(this);

		lastB1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		lastB1.setBounds(105, 630, 110, 30);
		lastB1.setBackground(Color.lightGray);
		lastB1.setFocusable(false);
		lastB1.addActionListener(this);

		openB1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		openB1.setBounds(197, 690, 110, 30);
		openB1.setBackground(Color.lightGray);
		openB1.setFocusable(false);
		openB1.addActionListener(this);

		port2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		port2.setLayout(new GridLayout(1, 1)); // GridLayout
		port2.setBounds(504, 280, 384, 320);

		randB2.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		randB2.setBounds(733, 630, 110, 30);
		randB2.setBackground(Color.lightGray);
		randB2.setFocusable(false);
		randB2.addActionListener(this);

		lastB2.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		lastB2.setBounds(549, 630, 110, 30);
		lastB2.setBackground(Color.lightGray);
		lastB2.setFocusable(false);
		lastB2.addActionListener(this);

		openB2.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		openB2.setBounds(641, 690, 110, 30);
		openB2.setBackground(Color.lightGray);
		openB2.setFocusable(false);
		openB2.addActionListener(this);

		port3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		port3.setLayout(new GridLayout(1, 1)); // GridLayout
		port3.setBounds(948, 280, 384, 320);

		randB3.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		randB3.setBounds(1177, 630, 110, 30);
		randB3.setBackground(Color.lightGray);
		randB3.setFocusable(false);
		randB3.addActionListener(this);

		lastB3.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		lastB3.setBounds(993, 630, 110, 30);
		lastB3.setBackground(Color.lightGray);
		lastB3.setFocusable(false);
		lastB3.addActionListener(this);

		openB3.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		openB3.setBounds(1085, 690, 110, 30);
		openB3.setBackground(Color.lightGray);
		openB3.setFocusable(false);
		openB3.addActionListener(this);

		port4.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		port4.setLayout(new GridLayout(1, 1)); // GridLayout
		port4.setBounds(1392, 280, 384, 320);

		randB4.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		randB4.setBounds(1621, 630, 110, 30);
		randB4.setBackground(Color.lightGray);
		randB4.setFocusable(false);
		randB4.addActionListener(this);

		lastB4.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		lastB4.setBounds(1437, 630, 110, 30);
		lastB4.setBackground(Color.lightGray);
		lastB4.setFocusable(false);
		lastB4.addActionListener(this);

		openB4.setFont(new Font("Segoe UI Variable", Font.PLAIN, 14));
		openB4.setBounds(1529, 690, 110, 30);
		openB4.setBackground(Color.lightGray);
		openB4.setFocusable(false);
		openB4.addActionListener(this);

		// Labels layout
		pathLb.setText("Path: ");
		pathLb.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
		pathLb.setBounds(60, 70, 110, 30);

		// Text fields and areas layout
		fPath.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		fPath.setBorder(BorderFactory.createLineBorder(Color.gray));
		fPath.setEditable(false);
		fPath.setBounds(125, 70, 800, 30);
		/*
		 * scroller5 = new JScrollPane(fPath, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
		 * JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); scroller5.setBounds(125, 70,
		 * 800, 30);
		 */

		fName1.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		fName1.setBorder(BorderFactory.createLineBorder(Color.gray));
		fName1.setEditable(false);
		fName1.setBounds(60, 235, 384, 25);
		/*
		 * scroller1 = new JScrollPane(fName1, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
		 * JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); scroller1.setBounds(60, 235,
		 * 384, 25);
		 */

		fName2.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		fName2.setBorder(BorderFactory.createLineBorder(Color.gray));
		fName2.setEditable(false);
		fName2.setBounds(504, 235, 384, 25);
		/*
		 * scroller2 = new JScrollPane(fName2, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
		 * JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // fName2.setBounds(504, 235,
		 * 384, 25); scroller2.setBounds(504, 235, 384, 25);
		 */

		fName3.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		fName3.setBorder(BorderFactory.createLineBorder(Color.gray));
		fName3.setEditable(false);
		fName3.setBounds(948, 235, 384, 25);
		/*
		 * scroller3 = new JScrollPane(fName3, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
		 * JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); scroller3.setBounds(948, 235,
		 * 384, 25);
		 */

		fName4.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		fName4.setBorder(BorderFactory.createLineBorder(Color.gray));
		fName4.setEditable(false);
		fName4.setBounds(1392, 235, 384, 25);
		/*
		 * scroller4 = new JScrollPane(fName4, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
		 * JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); scroller4.setBounds(1392, 235,
		 * 384, 25);
		 */

		// Frame setup
		frame = new JFrame();
		myIcon = new ImageIcon("touhou_icon.png");
		frame.setIconImage(myIcon.getImage());
		frame.setTitle("Portrait randomizer");
		frame.setSize(1856, 950);

		/*
		 * frame.add(scroller1); frame.add(scroller2); frame.add(scroller3);
		 * frame.add(scroller4); frame.add(scroller5);
		 */

		/*
		 * frame.setUndecorated(!transp);
		 * frame.getContentPane().setBackground(new
		 * Color(1.0f, 1.0f, 1.0f, 0.0f));
		 * frame.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
		 */

		frame.add(port1);
		frame.add(port2);
		frame.add(port3);
		frame.add(port4);

		frame.add(pathLb);

		frame.add(fPath);
		frame.add(fName1);
		frame.add(fName2);
		frame.add(fName3);
		frame.add(fName4);

		frame.add(gendCombo);
		frame.add(classCombo);

		frame.add(browseB);
		frame.add(exportB);
		frame.add(randAllB);
		frame.add(randB1);
		frame.add(randB2);
		frame.add(randB3);
		frame.add(randB4);
		frame.add(lastB1);
		frame.add(lastB2);
		frame.add(lastB3);
		frame.add(lastB4);
		frame.add(openB1);
		frame.add(openB2);
		frame.add(openB3);
		frame.add(openB4);

		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	private Integer getPortIndex(Boolean checkSub) throws IOException {
		String tmpPath = path;
		int index;
		FilePathManager portManag = new FilePathManager();
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		indexList.add(cImg1);
		indexList.add(cImg2);
		indexList.add(cImg3);
		indexList.add(cImg4);
		indexList.add(pImg1);
		indexList.add(pImg2);
		indexList.add(pImg3);
		indexList.add(pImg4);
		//indexList.add(tmpImg);
		
		tmpPath += getTmpPath();
		
		do {
			index = portManag.generateIndex(tmpPath, checkSub);
		}while(indexList.contains(index));
		
		return index;
	}
	
	private void setPort1(String tmpStr, int i) throws IOException {
		FilePathManager portManag = new FilePathManager();
		JLabel picLb;
		int index;
		Boolean checkSubdirectories = false;
		String tmpPath = path;
		
		if(tmpStr.isEmpty()) {
			checkSubdirectories = true;
		}
		
		if(i > 0) {
			index = i;
		} else {
			index = getPortIndex(checkSubdirectories);
		}
		
		//tmpImg = pImg2;
		pImg1 = cImg1;
		cImg1 = index;
		port1.removeAll();
		fName1.removeAll();
		tmpPath += tmpStr;
		picLb = new JLabel(new ImageIcon(portManag.getPortrait(tmpPath, index, checkSubdirectories)));
		fName1.setText(portManag.getImgName(tmpPath, index, checkSubdirectories, false));
		port1.add(picLb);
		fName1.revalidate();
		port1.revalidate();
	}
	
	private void setPort2(String tmpStr, int i) throws IOException {
		FilePathManager portManag = new FilePathManager();
		JLabel picLb;
		int index;
		Boolean checkSubdirectories = false;
		String tmpPath = path;
		
		if(tmpStr.isEmpty()) {
			checkSubdirectories = true;
		}
		
		if(i > 0) {
			index = i;
		} else {
			index = getPortIndex(checkSubdirectories);
		}
		
		//tmpImg = pImg2;
		pImg2 = cImg2;
		cImg2 = index;
		port2.removeAll();
		fName2.removeAll();
		tmpPath += tmpStr;
		picLb = new JLabel(new ImageIcon(portManag.getPortrait(tmpPath, index, checkSubdirectories)));
		fName2.setText(portManag.getImgName(tmpPath, index, checkSubdirectories, false));
		port2.add(picLb);
		fName2.revalidate();
		port2.revalidate();
	}
	
	private void setPort3(String tmpStr, int i) throws IOException {
		FilePathManager portManag = new FilePathManager();
		JLabel picLb;
		int index;
		Boolean checkSubdirectories = false;
		String tmpPath = path;
		
		if(tmpStr.isEmpty()) {
			checkSubdirectories = true;
		}
		
		if(i > 0) {
			index = i;
		} else {
			index = getPortIndex(checkSubdirectories);
		}
		
		//tmpImg = pImg2;
		pImg3 = cImg3;
		cImg3 = index;
		port3.removeAll();
		fName3.removeAll();
		tmpPath += tmpStr;
		picLb = new JLabel(new ImageIcon(portManag.getPortrait(tmpPath, index, checkSubdirectories)));
		fName3.setText(portManag.getImgName(tmpPath, index, checkSubdirectories, false));
		port3.add(picLb);
		fName3.revalidate();
		port3.revalidate();
	}
	
	private void setPort4(String tmpStr, int i) throws IOException {
		FilePathManager portManag = new FilePathManager();
		JLabel picLb;
		int index;
		Boolean checkSubdirectories = false;
		String tmpPath = path;
		
		if(tmpStr.isEmpty()) {
			checkSubdirectories = true;
		}
		
		if(i > 0) {
			index = i;
		} else {
			index = getPortIndex(checkSubdirectories);
		}
		
		//tmpImg = pImg2;
		pImg4 = cImg4;
		cImg4 = index;
		port4.removeAll();
		fName4.removeAll();
		tmpPath += tmpStr;
		picLb = new JLabel(new ImageIcon(portManag.getPortrait(tmpPath, index, checkSubdirectories)));
		fName4.setText(portManag.getImgName(tmpPath, index, checkSubdirectories, false));
		port4.add(picLb);
		fName4.revalidate();
		port4.revalidate();
	}
	
	private void exportPorts(String tmpStr, int i) throws IOException {
		FilePathManager portManag = new FilePathManager();
		int index;
		Boolean checkSubdirectories = false;
		String tmpPath = path;
		
		if(tmpStr.isEmpty()) {
			checkSubdirectories = true;
		}
		
		if(i > 0) {
			index = i;
		} else {
			index = getPortIndex(checkSubdirectories);
		}
		
		tmpPath += tmpStr;
		portManag.exportPortraits(tmpPath, index, checkSubdirectories);
	}
	
	private String getTmpPath() {
		String tmpPath = "";
		
		if(classCombo.getSelectedIndex() != 0) {
			tmpPath += "/" + classCombo.getSelectedItem().toString();
			if(gendCombo.getSelectedIndex() != 0) {
				tmpPath += "/" + gendCombo.getSelectedItem().toString();
			}
		} else if(gendCombo.getSelectedIndex() != 0) {
			tmpPath += "/" + gendCombo.getSelectedItem().toString();
		}
		return tmpPath;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == browseB) {
			fPath.removeAll();
			FilePathManager selManag = new FilePathManager();
			// Returns a String with the path from the FileChooser
			try {
				path = selManag.browseDirectory(path);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			fPath.setText(path);
			fPath.revalidate();
		}
		if (e.getSource() == exportB) {
			try {
				exportPorts(getTmpPath(), cImg1);
				exportPorts(getTmpPath(), cImg2);
				exportPorts(getTmpPath(), cImg3);
				exportPorts(getTmpPath(), cImg4);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == randAllB) {
			try {
				setPort1(getTmpPath(), -1);
				setPort2(getTmpPath(), -1);
				setPort3(getTmpPath(), -1);
				setPort4(getTmpPath(), -1);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == randB1) {
			try {
				setPort1(getTmpPath(), -1);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == randB2) {
			try {
				setPort2(getTmpPath(), -1);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == randB3) {
			try {
				setPort3(getTmpPath(), -1);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == randB4) {
			try {
				setPort4(getTmpPath(), -1);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == lastB1) {
			try {
				setPort1(getTmpPath(), pImg1);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == lastB2) {
			try {
				setPort2(getTmpPath(), pImg2);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == lastB3) {
			try {
				setPort3(getTmpPath(), pImg3);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == lastB4) {
			try {
				setPort4(getTmpPath(), pImg4);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == openB1) {
			try {
				exportPorts(getTmpPath(), cImg1);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == openB2) {
			try {
				exportPorts(getTmpPath(), cImg2);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == openB3) {
			try {
				exportPorts(getTmpPath(), cImg3);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == openB4) {
			try {
				exportPorts(getTmpPath(), cImg4);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}