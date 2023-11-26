package com.raka.textextractor.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.sourceforge.tess4j.TesseractException;

public class Interface {
	
	public String imageFilePath;
	public String textFilePath;
	private File imageFile;

	private JFrame frame;
	private JTextField imageField;
	private JTextField textField;
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
					JOptionPane.showMessageDialog(null, "Error occurred in the application");
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
		
		JLabel instruction = new JLabel("(Do add extension to the file path)");
		instruction.setHorizontalAlignment(SwingConstants.CENTER);
		instruction.setBounds(10, 41, 466, 26);
		frame.getContentPane().add(instruction);
		
		JLabel imageLabel = new JLabel("Enter path to your image file : (.jpg, .jpeg, .png, .gif)");
		imageLabel.setBounds(10, 83, 348, 20);
		frame.getContentPane().add(imageLabel);
		
		imageField = new JTextField();
		imageField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updatePath();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updatePath();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updatePath();
				
			}
			
			private void updatePath() {
				imageFilePath = imageField.getText();
			}
		});
		imageField.setBounds(10, 113, 376, 26);
		frame.getContentPane().add(imageField);
		imageField.setColumns(10);
		
		JLabel textLabel = new JLabel("Enter path to text file directory : ( .txt)");
		textLabel.setBounds(10, 172, 231, 20);
		frame.getContentPane().add(textLabel);
		
		textField = new JTextField();
		textField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updatePath();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updatePath();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updatePath();
				
			}
			
			private void updatePath() {
				textFilePath = textField.getText();
			}
		});
		textField.setBounds(10, 198, 376, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
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
					
				}
				else {
					informLabel.setText("No File Selected!");
					setTimer(5000);
				}
			}
		});
		browseImageFile.setBackground(new Color(192, 192, 192));
		browseImageFile.setBounds(391, 113, 85, 24);
		frame.getContentPane().add(browseImageFile);
		
		JButton browseTextFile = new JButton("Browse");
		browseTextFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(currentDirectory);
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files (*.txt)", "txt");
				fileChooser.setFileFilter(filter);
				
				int result = fileChooser.showOpenDialog(null);
				
				if(result == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					
					textFilePath = file.getAbsolutePath();
					textField.setText(textFilePath);
				}
				else {
					informLabel.setText("No File Selected");
					setTimer(5000);
				}
				
			}
		});
		browseTextFile.setBackground(new Color(192, 192, 192));
		browseTextFile.setBounds(391, 198, 85, 24);
		frame.getContentPane().add(browseTextFile);
		
		JButton generateText = new JButton("Generate Text File");
		generateText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isValidFilePath(imageFilePath)) {
					if (isValidFilePath(textFilePath)) {
						TextOCR converter = new TextOCR(imageFilePath, textFilePath);
						
						try {
							converter.runOCR();
							
							informLabel.setText("Text File Created Successfully!");
						}
						catch (TesseractException | IOException e1) {
							informLabel.setText("Error occurred while creating text file");
						}
					}
					else {
						informLabel.setText("Invalid Text File Path");
						setTimer(5000);
					}
				}
				else {
					informLabel.setText("Invalid Image File Path");
					setTimer(5000);
				}
				
			}
		});
		generateText.setBackground(new Color(0, 255, 0));
		generateText.setBounds(153, 263, 179, 33);
		frame.getContentPane().add(generateText);
		
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
	
	private boolean isValidFilePath(String path) {
		try {
			Paths.get(path);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
