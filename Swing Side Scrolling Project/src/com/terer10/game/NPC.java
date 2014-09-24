package com.terer10.game;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;

public class NPC implements Runnable{
	Image npc;
	String path = "C:/Users/terer10/Desktop/JJGames/SSSP/";
	Graphics2D g;
	int startX,startY;
	public NPC(int startX, int startY,Image npc, Graphics2D g2d){
		try{
			this.npc = npc ;
		}catch(Exception e){
			System.out.println("Error: " + e);
		}
		this.startX = startX;
		this.startY = startY;		
		g = g2d;
	}
	public void run(){
		g.drawImage(npc,startX,startY,null);
		System.out.println("New npc created at X: " + startX + " Y: " + startY );
	}
}
