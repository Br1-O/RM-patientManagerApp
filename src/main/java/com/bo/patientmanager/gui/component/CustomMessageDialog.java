/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bo.patientmanager.gui.component;

/**
 *
 * @author Bring Online
 */
import javax.swing.*;
import java.awt.*;

public class CustomMessageDialog extends JDialog {

    public enum Position {
        UP_RIGHT,
        UP_LEFT,
        DOWN_RIGHT,
        DOWN_LEFT,
        CENTER
    }

    private CustomMessageDialog(
            Window parent,
            String message,
            Icon icon,
            Color background,
            Color foreground,
            boolean undecorated,
            int autoCloseMillis
    ) {

        super(parent);
        setUndecorated(undecorated);
        setModal(false);

        JPanel content = new JPanel(new BorderLayout(10, 10));
        content.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));
        content.setBackground(background);

        JLabel lblIcon = new JLabel(icon);

        JLabel lblMessage = new JLabel(message);
        lblMessage.setForeground(foreground);
        lblMessage.setFont(lblMessage.getFont().deriveFont(Font.BOLD, 13f));

        content.add(lblIcon, BorderLayout.WEST);
        content.add(lblMessage, BorderLayout.CENTER);

        setContentPane(content);
        pack();

        if (autoCloseMillis > 0) {
            Timer t = new Timer(autoCloseMillis, e -> dispose());
            t.setRepeats(false);
            t.start();
        }
    }

    // ---------------------------------------
    // API – usando posiciones tipo enum
    // ---------------------------------------
    public static void show(
            Component parent,
            String message,
            Icon icon,
            Color background,
            Color foreground,
            boolean undecorated,
            int autoCloseMillis,
            Position position
    ) {

        Window w = SwingUtilities.getWindowAncestor(parent);

        CustomMessageDialog d = new CustomMessageDialog(
                w,
                message,
                icon,
                background,
                foreground,
                undecorated,
                autoCloseMillis
        );

        d.setLocation(calculatePosition(d, w, position));
        d.setVisible(true);
    }

    // ---------------------------------------
    // API – posición manual X / Y
    // ---------------------------------------
    public static void showAt(
            Component parent,
            String message,
            Icon icon,
            Color background,
            Color foreground,
            boolean undecorated,
            int autoCloseMillis,
            int x,
            int y
    ) {

        Window w = SwingUtilities.getWindowAncestor(parent);

        CustomMessageDialog d = new CustomMessageDialog(
                w,
                message,
                icon,
                background,
                foreground,
                undecorated,
                autoCloseMillis
        );

        d.setLocation(x, y);
        d.setVisible(true);
    }

    // ---------------------------------------
    // Cálculo de posiciones
    // ---------------------------------------
    private static Point calculatePosition(
            JDialog dialog,
            Window parent,
            Position position
    ) {

        Rectangle area;

        if (parent != null) {
            area = parent.getBounds();
        } else {
            Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
            area = new Rectangle(0, 0, s.width, s.height);
        }

        int margin = 16;

        int x = 0;
        int y = 0;

        switch (position) {

            case UP_RIGHT:
                x = area.x + area.width - dialog.getWidth() - margin;
                y = area.y + margin;
                break;

            case UP_LEFT:
                x = area.x + margin;
                y = area.y + margin;
                break;

            case DOWN_RIGHT:
                x = area.x + area.width - dialog.getWidth() - margin;
                y = area.y + area.height - dialog.getHeight() - margin;
                break;

            case DOWN_LEFT:
                x = area.x + margin;
                y = area.y + area.height - dialog.getHeight() - margin;
                break;

            case CENTER:
            default:
                x = area.x + (area.width - dialog.getWidth()) / 2;
                y = area.y + (area.height - dialog.getHeight()) / 2;
        }

        return new Point(x, y);
    }
}
