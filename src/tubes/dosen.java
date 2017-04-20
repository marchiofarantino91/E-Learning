/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;

/**
 *
 * @author march
 */
public class dosen extends orang {
    private String kd;//kode
    private long nip;
    private ArrayList<kelas> daftarkelas;


   public dosen(String nama, String kd, long nip, String u, String pw) {
      super(nama,u,pw);
        this.nip = nip;
        this.kd = kd;
    }


    

    public String getKode() {
        return kd;
    }

    public long getNip() {
        return nip;
    }
    

    
    public void createKelas (String namaKelas){
      daftarkelas.add(new kelas(namaKelas)); 
         }
    
    public kelas getKelas(String kelas){
        for (kelas k : daftarkelas){
            if (k.getNamaKelas().equals(kelas)){
                return k;
            }
        }
        return null;
    }
    
      
    public void removeKelas(String kelas){
        daftarkelas.remove(getKelas(kelas));
    }
    
    public String showKelas(){
        for (int i =1 ; i<= daftarkelas.size(); i++){
            if (daftarkelas.isEmpty()){
                return  "Kelas Kosong";
            }
            else {
             return  i+" . "+daftarkelas.toString();}
        }
        return null;
    }
    
    public String toString(){
        return "Nama : " + super.getNama() + " - "
                + this.kd + " - ";
    }
    
    public void addTugas(kelas k,String nama){
        
        k.createTugas(nama);
                
    }
    

}


