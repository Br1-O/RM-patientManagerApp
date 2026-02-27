/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.gui.component;

import com.bo.patientmanager.gui.theme.ThemeManager;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Bring Online
 */
public class BackgroundPanel extends JPanel {


    private Image bg;
    
    private boolean useMenuBackground = false;

    public BackgroundPanel() {

        loadBackground();

        ThemeManager.addThemeListener(() -> {
            loadBackground();
            repaint();
        });
    }
    
    public BackgroundPanel(boolean useMenuBackground) {
        this.useMenuBackground = useMenuBackground;

        loadBackground();

        ThemeManager.addThemeListener(() -> {
            loadBackground();
            repaint();
        });
    }

    private void loadBackground(){

        String path = useMenuBackground ? ThemeManager.menuBackground() : ThemeManager.background();

        bg = new ImageIcon(
                getClass().getResource(path)
        ).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(bg != null){
            g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public void setView(JPanel view){

        removeAll();
        setLayout(new BorderLayout());

        view.setOpaque(false);
        add(view, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    // helper para tus ventanas

    public static void setDefaultView(JPanel container, JPanel view){

        container.removeAll();
        container.setLayout(new BorderLayout());

        BackgroundPanel bg = new BackgroundPanel();
        bg.setLayout(new BorderLayout());

        container.add(bg, BorderLayout.CENTER);
        bg.setView(view);
    }

}
