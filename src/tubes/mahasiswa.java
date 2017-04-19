/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author march
 */
public class mahasiswa extends orang {
    private long nim; //nim
    


    public mahasiswa(String nama, long nim, String u, String pw) {
       super(nama,u,pw);
    
        this.nim = nim;
    }
    

    public long getNim() {
        return nim;
    }
 
    public String toString(){
        return super.getNama() + " - "+ this.nim ;
    }
    
    
}
