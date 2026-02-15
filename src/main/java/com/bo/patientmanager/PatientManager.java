/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.bo.patientmanager;

import com.bo.patientmanager.gui.MainWindow;

/**
 *
 * @author Bring Online
 */
public class PatientManager {

    public static void main(String[] args) {
        
        //call to gui main menu
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        mainWindow.setLocationRelativeTo(null);
    }
}
