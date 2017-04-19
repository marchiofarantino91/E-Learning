/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.control;

import tubes.GUI.LoginGui;
import tubes.GUI.daftarGUI;
import tubes.GUI.menuGUI;

/**
 *
 * @author MARCHIO
 */
public class menuHandler {
 private LoginGui login;
 private menuGUI view;
 
 private daftarGUI daftar; 

 public menuHandler(){
       view = new menuGUI();
        view.setVisible(true);
        view.addActionListener(this);
        t
 }

}
