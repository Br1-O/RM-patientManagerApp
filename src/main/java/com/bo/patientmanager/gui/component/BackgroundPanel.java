/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.gui.component;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Bring Online
 */
public class BackgroundPanel extends JPanel {

    private Image bg;

    public BackgroundPanel(String resourcePath) {
        bg = new ImageIcon(
            getClass().getResource(resourcePath)
        ).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
    
     public void setView(JPanel view) {

        removeAll();
        add(view, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
     
     public static void setDefaultView(JPanel container, JPanel view){
        container.removeAll();
        container.setLayout(new BorderLayout());
        BackgroundPanel bgContent = new BackgroundPanel("/public/bg/bg_nodes.jpg");
        bgContent.setLayout(new BorderLayout());
        container.add(bgContent, BorderLayout.CENTER);
        view.setOpaque(false);
        bgContent.setView(view);
     }

}
