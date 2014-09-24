package com.terer10.game;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Player {
	public static boolean PRunning = false;
	public static boolean keyDown = false;
	public static int runMeter = 500;
	//jumpingTime
	public static long jumpingTime = 200;
	public static boolean jumping = false;
	String path = "C:/Users/terer10/Desktop/JJGames/SSSP/";
	//coords for player
	public static int counter,counter2;
	public static int x,y;
	//coords for background
	public static int bx,bx2,dbx,standard;
	//Sprite Image State
	public static Image sprite,spriteL,spriteR, spriteStill;
	Panel panel = new Panel();
	//Timer
	public Player(){
		if(jumping){
			y--;
		}
		//Setting Images
		try {
			spriteR = ImageIO.read(new File(path + "SpriteRight.png"));
			spriteL = ImageIO.read(new File(path + "SpriteLeft.png"));
			spriteStill = ImageIO.read(new File(path + "SpriteStill.png"));
			sprite = ImageIO.read(new File(path + "SpriteStill.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR: " + e);
		}
		//Coords 
		counter = 1;
		counter2 =1;
		bx = 815;
		bx2 = 815;
		bx2+=dbx;
		bx+=dbx;
		standard = 902;
		x = (815/2) - sprite.getWidth(null);
		y = (448-7)-sprite.getHeight(null);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public Image returnSprite(){
		return sprite;
	}
	public void move(){
		x+=dbx;
		bx+=dbx;
}
}
//left action
class LEFT extends AbstractAction{
	public void actionPerformed(ActionEvent e){
		Player.keyDown = true;
		Player.dbx=-1;
		Player.sprite = Player.spriteL;
	}
}
//Right Action
class RIGHT extends AbstractAction{
	public void actionPerformed(ActionEvent e){
		Player.keyDown = true;
		Player.dbx=1;
		Player.sprite = Player.spriteR;
	}
}
class SRIGHT extends AbstractAction{
	public void actionPerformed(ActionEvent e){
		Player.keyDown = true;
		Player.dbx=4;
		Player.sprite = Player.spriteR;
	}
}
class STOP extends AbstractAction{
	public void actionPerformed(ActionEvent e){
		Player.dbx = 0;
		Player.sprite = Player.spriteStill;
	}
}
class JUMP extends AbstractAction{
	public void actionPerformed(ActionEvent e){
		Player.jumping = true;
		new Thread(new jumping()).start();
	}
}
class jumping implements Runnable{
	public void run(){
		try{
			Thread.sleep(Player.jumpingTime);
			Player.jumping = false;
		}catch(Exception e){
			new Thread(this);
			System.out.println("ERROR: " + e);}
	}
}