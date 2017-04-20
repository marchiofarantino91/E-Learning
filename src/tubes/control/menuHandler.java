/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tubes.Aplikasi;
import tubes.GUI.menuGUI;

/**
 *
 * @author MARCHIO
 */
public class menuHandler implements ActionListener {
 Aplikasi model;
 private menuGUI view;
 

 public menuHandler(Aplikasi model){
        view = new menuGUI();
        view.setVisible(true);
        view.addActionListener(this);
        this.model = model;
 }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object click = e.getSource();
        if (click.equals(view.getBtnDaftar())) {
            new daftarHandler(model);
            view.dispose();
        }
        else if (click.equals(view.getBtnLogin())){
        new loginHandler(model);
        view.dispose();
    }
        else if (click.equals(view.getBtnKeluar())){
            view.dispose();
        }
        
    }
 
 

}
