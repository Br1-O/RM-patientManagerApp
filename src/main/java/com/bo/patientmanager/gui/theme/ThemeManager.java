/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.bo.patientmanager.gui.theme;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
/**
 *
 * @author Bring Online
 */
public final class ThemeManager {

    private static AppTheme current = AppTheme.CLASSIC;

    private static final List<Runnable> listeners = new ArrayList<>();

    private ThemeManager() {}

    public static void addThemeListener(Runnable r){
        listeners.add(r);
    }

    public static AppTheme getTheme(){
        return current;
    }

    public static void setTheme(AppTheme theme){

        if(theme == current) return;

        current = theme;

        applyLookAndFeel(theme);

        for(Runnable r : listeners){
            r.run();
        }

        refreshAllWindows();
    }

    private static void applyLookAndFeel(AppTheme theme){
        try{
            if(theme.dark){
                com.formdev.flatlaf.FlatDarkLaf.setup();
            }else{
                com.formdev.flatlaf.FlatLightLaf.setup();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private static void refreshAllWindows(){
        for(Window w : Window.getWindows()){
            SwingUtilities.updateComponentTreeUI(w);
            w.pack();
        }
    }

    // accesos rápidos

    public static Color primary(){
        return current.primary;
    }

    public static Color secondary(){
        return current.secondary;
    }

    public static Color tertiary(){
        return current.tertiary;
    }

    public static Font font(){
        return current.font;
    }

    public static String background(){
        return current.background;
    }
    
    public static String menuBackground(){
        return current.menuBg;
    }

}