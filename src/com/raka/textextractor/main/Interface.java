package com.raka.textextractor.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Interface {
	
	public String imageFilePath;
	public String textFilePath;
	private String imageName;
	private String textName;
	private File imageFile;

	private JFrame frame;
	private JTextField imageField;
	private JTextField textField;
	private JRadioButton samePath;
	private JLabel informLabel;
	private File currentDirectory = new File("C:\\Users\\RAKESH KUMAR\\Desktop");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Text Extractor");
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(100, 100, 500, 400);
		frame.getContentPane().setLayout(null);
		
		JLabel header = new JLabel("This desktop application will convert your IMAGE into TEXT");
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setBounds(10, 10, 466, 36);
		frame.getContentPane().add(header);
		
		JLabel imageLabel = new JLabel("Enter path to your image file :");
		imageLabel.setBounds(10, 56, 231, 20);
		frame.getContentPane().add(imageLabel);
		
		imageField = new JTextField();
		imageField.setBounds(10, 83, 376, 26);
		frame.getContentPane().add(imageField);
		imageField.setColumns(10);
		
		JLabel textLabel = new JLabel("Enter path to text file directory :");
		textLabel.setBounds(10, 172, 231, 20);
		frame.getContentPane().add(textLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 198, 376, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Generate Text File");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setBounds(153, 263, 179, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton browseImageFile = new JButton("Browse");
		browseImageFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(currentDirectory);
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg", "gif");
				fileChooser.setFileFilter(filter);
				
				int result = fileChooser.showOpenDialog(null);
				
				if(result == JFileChooser.APPROVE_OPTION) {
					imageFile = fileChooser.getSelectedFile();
					imageFilePath = imageFile.getAbsolutePath();
					
					imageField.setText(imageFilePath);
					if(samePath.isSelected()) {
						String imageFileParent = imageFile.getParent();
						imageName = imageFile.getName();
						textName = imageName.substring(0, imageName.lastIndexOf('.')) + ".txt";
						
						textFilePath = imageFileParent + File.separator + textName;
						
						textField.setText(textFilePath);
					}
					
				}
				else {
					informLabel.setText("No File Selected!");
					setTimer(5000);
				}
			}
		});
		browseImageFile.setBackground(new Color(192, 192, 192));
		browseImageFile.setBounds(391, 85, 85, 24);
		frame.getContentPane().add(browseImageFile);
		
		JButton browseTextFile = new JButton("Browse");
		browseTextFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!imageField.getText().isEmpty()) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(currentDirectory);
					fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					
					int result = fileChooser.showOpenDialog(null);
					
					if(result == JFileChooser.APPROVE_OPTION) {
						File file = fileChooser.getSelectedFile();
						
						String textFileParent = file.getAbsolutePath();
						
						textName = imageName.substring(0, imageName.lastIndexOf('.')) + ".txt";
						
						textFilePath = textFileParent + File.separator + textName;
						textField.setText(textFileParent);
					}
				}
				else {
					informLabel.setText("Enter the image file path first");
					setTimer(5000);
				}
				
			}
		});
		browseTextFile.setBackground(new Color(192, 192, 192));
		browseTextFile.setBounds(391, 198, 85, 24);
		frame.getContentPane().add(browseTextFile);
		
		samePath = new JRadioButton("Set text file path same as image file path");
		samePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(samePath.isSelected()) {
					String imageFileParent = imageFile.getParent();
					imageName = imageFile.getName();
					textName = imageName.substring(0, imageName.lastIndexOf('.')) + ".txt";
					
					textFilePath = imageFileParent + File.separator + textName;
					
					textField.setText(textFilePath);
				}
				else {
					if(imageFilePath.equals(textFilePath)) {
						textField.setText("");
						textFilePath = "";
					}
				}
			}
		});
		samePath.setBackground(new Color(173, 216, 230));
		samePath.setBounds(10, 150, 322, 21);
		
		
		frame.getContentPane().add(samePath);
		
		informLabel = new JLabel("");
		informLabel.setHorizontalAlignment(SwingConstants.CENTER);
		informLabel.setBounds(10, 309, 444, 36);
		frame.getContentPane().add(informLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setTimer(int millis) {
		Timer timer = new Timer(millis, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				informLabel.setText("");
				
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
}
