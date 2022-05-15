/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author silkroad
 */
public class GUIManager {
    
     private JFrame frame;

      public void setFrame(JFrame frame) {
        this.frame = frame;
    }
      
    public void iExitSystem() {
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Billing",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }
    
    
}
