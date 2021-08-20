package com.company;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

    public static void main(String[] args) {

        new Main();
    }

    public Main(){
        KeyListener listener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent event) {
                if(event.getKeyChar()==KeyEvent.VK_ENTER && !Contents.wasHit) {
                    Contents.yV = -2;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_BACK_SLASH && !Contents.wasHit){
                    Contents.yV = 2;
                    event.consume();
                }
                if(event.getKeyChar()==KeyEvent.VK_SPACE){
                    Contents.yV = 1;
                    Contents.zV = 9;
                    Contents.y = 200;
                    Contents.z = 850;
                    Contents.score = 0;
                    Contents.wasHit = false;
                    event.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent event) {

            }

            @Override
            public void keyTyped(KeyEvent event) {
            }

        };
        JFrame frame = new JFrame();
        frame.setTitle("Plane Game - Don't Hit The Walls!!!");
        frame.setSize(900, 600);
        frame.setLocation(100, 50);
        frame.addKeyListener(listener);
        frame.add(new Contents());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
