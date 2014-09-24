package com.terer10.game;

import java.awt.Dimension;
import java.awt.image.BufferStrategy;

import javax.swing.*;

public class Window{
	String path = "C:/Users/terer10/Desktop/JJGames/SSSP/";
	public JFrame frame;
	public static void main(String[]args){
		Window w = new Window();
		w.frame = new JFrame("Super Swing Side Scroller Project ");
		w.frame.setResizable(false);
		w.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.frame.add(new Panel());
		w.frame.setSize(new Dimension(815,477));
		//w.frame.pack();
		w.frame.setLocationRelativeTo(null);
		w.frame.setVisible(true);
	}
}
