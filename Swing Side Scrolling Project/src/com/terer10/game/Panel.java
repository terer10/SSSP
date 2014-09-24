package com.terer10.game;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class Panel extends JPanel implements ActionListener, Runnable{
	static Player p = new Player();
	Image map;
	String path;
	Timer updater;
	public static int mX,mY;
	public static Graphics2D g2d;
	public Panel(){
		InputMap IMap = this.getInputMap(WHEN_IN_FOCUSED_WINDOW);
		//Key Binding Actions
		Action left = new LEFT();
		Action right = new RIGHT();
		Action stop = new STOP();
		Action jump = new JUMP();
		//File Path
		path = "C:/Users/terer10/Desktop/JJGames/SSSP/";
		//For Key Listening
		setFocusable(true);
		ImageIcon i = new ImageIcon(path + "City.png");
		map = i.getImage();
		//Sizes for packing
		setPreferredSize(new Dimension(map.getWidth(null),map.getHeight(null)));
		setMinimumSize(new Dimension(map.getWidth(null),map.getHeight(null)));
		setMaximumSize(new Dimension(map.getWidth(null),map.getHeight(null)));
		//System.out.println(map.getWidth(null));
		updater = new Timer(5,this);
		updater.start();
		System.out.println(this.getWidth());
		//Key Bindings
		IMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "right");
		IMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "left");
		IMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "jump");
		IMap.put(KeyStroke.getKeyStroke("released D"), "stop");
		IMap.put(KeyStroke.getKeyStroke("released A"), "stop");
		this.getActionMap().put("jump", jump);
		this.getActionMap().put("right", right);
		this.getActionMap().put("stop", stop);
		this.getActionMap().put("left", left);	
		
		this.addMouseMotionListener(new MouseM());
		this.addMouseListener(new Mouse());
	}
	public void actionPerformed(ActionEvent e){
		System.out.println(p.bx);
		System.out.println(p.getX());
		//902
		//448
		//Background Size: 896 * 448
		p.move();
		repaint();
	}
	public void paint(Graphics g){
		super.paint(g);
		g2d = (Graphics2D) g;
		g2d.drawImage(map,815 - p.bx,0,null);
		g2d.drawImage(p.returnSprite(),(815/2) - p.sprite.getWidth(null),p.getY(),null);
	}
	public void run(){
		new Panel();
	}
}
class MouseM implements MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseMoved(MouseEvent e) {
		Panel.mX = e.getX();
		Panel.mY = e.getY();
	}
}
class Mouse implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		new Thread(new NPC(Panel.mX,Panel.mY, new Player().spriteL,Panel.g2d)).start();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		try {
			new Thread(new NPC(Panel.mX,Panel.mY, new Player().spriteL,Panel.g2d)).join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}}