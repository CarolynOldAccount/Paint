/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapaint.Tools;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Shape;
import java.util.ArrayList;
import javapaint.CreateInput;

/**
 *
 * @author carol_8wybosj
 */
public class FreeDraw extends Tools{

    private ArrayList<Point> lines = new ArrayList<Point>();
    private ArrayList<Color> color = new ArrayList<Color>();
    private Color colorNow;
    private CreateInput mouse;
    
  public FreeDraw(Canvas canvas){
    mouse = new CreateInput(canvas);
  }  
   
    @Override
    public ArrayList<Color> getArrayColor() {
        return color;
    }
    
     public void setColor(Color c){
        colorNow = c;
    }
    
    public ArrayList<Point> getArrayLines() {
        return lines;
    }
    
    public void draw(Graphics g) {
            lines.add(mouse.getPosition());
            color.add(g.getColor());
            System.out.print("Down\n");
    }   
    
    public void AddLines(Graphics g){
    for (int i = 0; i < lines.size() - 1; ++i) {
            Point p1 = lines.get(i);
            Point p2 = lines.get(i + 1);
            g.setColor(color.get(i));
            // Adding a null into the list is used
            // for breaking up the lines when
            // there are two or more lines
            // that are not connected
            if (!(p1 == null || p2 == null)) {
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }
    @Override
    public void clear() {
        lines.clear();
        color.clear();
    }
    
}
