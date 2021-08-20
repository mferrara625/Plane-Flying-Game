package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contents extends JPanel implements ActionListener {

    private Image image;
    private int x = 100, y = 200, z = 850, h = 200;
    int score = 0;
    public static boolean wasHit = false;
    int finalScore = 0;


    private Timer t;

    public Contents(){
        super.setDoubleBuffered(true);
        t = new Timer(7, this);
        t.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon ii = new ImageIcon(this.getClass().getResource("plane.png"));
        image = ii.getImage();
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(image, x, y, this);

        g2d.fillRect( z, 0, 50, h);
        g2d.fillRect( z, h + 225, 50, 300);

        g2d.drawString("Score: " + score, 800, 25);
        g2d.drawString( "Enter = \uD83E\uDC15   Backslash = \uD83E\uDC17 ", 10, 25);
        if(wasHit){
            g2d.drawString("GAME OVER - Final Score: " + finalScore, 450, 300);
        }


    }

    public static int xV = 0;
    public static int yV = 1;
    public static int zV = 9;

    public void move(){
        x = x + xV;
        y = y + yV;
        z = z - zV;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();

        if(x == 0){
            xV = 1;
        } else if (x == 770){
            xV = -1;
        }

        if(y == 0){
            yV = 1;
        } else if (y == 450){
            yV = -1;
        }

        if(z == -50){
            z = 850;
            h = (int) ((Math.random() * 250) + 50);
        }

        if(z >= x - 25 && z <= x + 100 && (y <= h - 25 || y + 100 >= h + 225)){
            yV = 0;
            zV = 0;
            finalScore = score;
            wasHit = true;
        } else {
            if(!wasHit)
            score += 10;
        }

        repaint();
    }
}
