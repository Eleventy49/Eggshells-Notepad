package com;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Application extends Canvas{
	
	public static int windowWidth = 800;
	public static int windowHeight = 600;
	private static int TEXT_SIZE = 20;
	protected static JTextArea textArea = new JTextArea();
    
    public Application() {
    	//The Windows frame
        JFrame frame = new JFrame("Eggshell's Notepad");
        frame.getContentPane().setLayout(new java.awt.BorderLayout());
        GridBagLayout gridLayout = new GridBagLayout();
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.gridx=1;
        gridConstraints.gridy = 1;

        //The content
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridLayout(1,1));
        
        //The actual text editing area itself
        
        textArea.setFont(new Font("Arial", Font.PLAIN, TEXT_SIZE));

        JMenuBar menu = new JMenuBar();
        JMenu menuOptions = new JMenu("TextSize");
        JMenuItem textSize = new JMenuItem("Text Size");
        
        JSlider textSlider = new JSlider();
        textSlider.setMinimum(10);
        textSlider.setMaximum(200);
        textSlider.setValue(TEXT_SIZE);
        SliderListener sliderListener = new SliderListener();
        textSlider.addChangeListener(sliderListener);
        menuOptions.add(textSlider);
        menu.add(menuOptions);

        jpanel.add(textArea);

        frame.setJMenuBar(menu);
        frame.setPreferredSize(new Dimension(windowWidth, windowHeight));
        frame.getContentPane().add(jpanel);
        frame.pack();
        frame.setVisible(true);
        
    }
    
    public class SliderListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider)e.getSource();
			TEXT_SIZE = source.getValue();
			Application.textArea.setFont(new Font("Arial", Font.PLAIN, TEXT_SIZE));
			
		}
    	
    }

    public static void ProcessListener(ActionEvent e) {
    	
    }
    
    public static void main(String[] args) {
    	Application app = new Application();
    	
    }
}
