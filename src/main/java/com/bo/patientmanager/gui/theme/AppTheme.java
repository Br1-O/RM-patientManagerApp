/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.bo.patientmanager.gui.theme;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Bring Online
 */
public enum AppTheme {

    NODES(
            false,
            "/public/bg/bg_nodes.jpg",
            "/public/bg/bg_nodes_menu.jpg",
            new Color(52, 152, 219),
            new Color(236, 240, 241),
            new Color(127, 140, 141),
            new Font("Segoe UI", Font.PLAIN, 13)
    ),

    DARK(
            true,
            "/public/bg/bg_nodes.jpg",
            "/public/bg/bg_nodes_menu.jpg",
            new Color(46, 204, 113),
            new Color(44, 62, 80),
            new Color(149, 165, 166),
            new Font("Segoe UI", Font.PLAIN, 13)
    ),

    STARS(
            false,
            "/public/bg/bg_stars.jpg",
            "/public/bg/bg_stars_menu.jpg",
            new Color(0, 168, 150),
            new Color(240, 248, 255),
            new Color(100, 100, 100),
            new Font("Segoe UI", Font.BOLD, 13)
    ),

    NIGHT(
            true,
            "/public/bg/bg_nodes.jpg",
            "/public/bg/bg_nodes_menu.jpg",
            new Color(155, 89, 182),
            new Color(30, 30, 30),
            new Color(180, 180, 180),
            new Font("Consolas", Font.PLAIN, 13)
    ),

    CLASSIC(
            false,
            "/public/bg/bg_nodes.jpg",
            "/public/bg/bg_nodes_menu.jpg",
            new Color(52, 73, 94),
            new Color(250, 250, 250),
            new Color(120, 120, 120),
            new Font("Tahoma", Font.PLAIN, 13)
    );

    public final boolean dark;
    public final String background;
    public final String menuBg;
    public final Color primary;
    public final Color secondary;
    public final Color tertiary;
    public final Font font;

    AppTheme(
            boolean dark,
            String background,
            String menuBg,
            Color primary,
            Color secondary,
            Color tertiary,
            Font font
    ) {
        this.dark = dark;
        this.background = background;
        this.menuBg = menuBg;
        this.primary = primary;
        this.secondary = secondary;
        this.tertiary = tertiary;
        this.font = font;
    }
}
