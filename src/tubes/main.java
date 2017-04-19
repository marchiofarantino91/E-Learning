/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import tubes.GUI.daftarGUI;
import tubes.control.daftarHandler;
import tubes.control.loginHandler;

/**
 *
 * @author march
 */
public class main {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       dosen d1 = new dosen("Anto","ant");
//       mahasiswa m1 = new mahasiswa("Tina",1301154254,"Informatika");
//       mahasiswa m2 = new mahasiswa("Ander",1301154223,"Informatika");
//       
       Aplikasi main = new Aplikasi();
       loginHandler login = new loginHandler(main);
       daftarHandler daftaar = new daftarHandler(main);
       /*
       do{
       main.mainMenu();
       } while (main.getIsIsExit() == true);
        System.out.println("Terima Kasih.");
        
}*/
}     
}
        

        

