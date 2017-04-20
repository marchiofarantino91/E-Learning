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
public class kelas {
    private mata_kuliah mk;
    private  ArrayList<mahasiswa> anggota;
    private String namaKelas;
    private ArrayList<tugas> Tugas;
    private int jmlMhs = 0; //jml mhs
    private int jmlTgs = 0; //jml tugas
    
    public kelas(String namaKelas){
        this.namaKelas = namaKelas;
              
    }

    public void setMk(mata_kuliah mk) {
        this.mk = mk;
    } 
    


    public mata_kuliah getMk() {
        return mk;
    }

    public String getNamaKelas() {
        return namaKelas;
    }
  

public void addMahasiswa(mahasiswa m){
    anggota.add(m);
}

public void addMataKuliah(mata_kuliah mkl){
    mk = mkl;
 }

public void createTugas(String tugas){
    Tugas.add(new tugas(tugas));
}

    public int getJml() {
        return jmlMhs;
    }

    public int getJmlT() {
        return jmlTgs;
    }
    public tugas getTugas(String name){
        for (tugas t : Tugas) {
            if (t.equals(name))
                return t;
        }
        return null;
    }
    
    public void removeTugas(String tugas){
        Tugas.remove(getTugas(tugas));
        
    }
    
public mahasiswa getMhsID(long id){
    for (mahasiswa m : anggota) {
        if (m.getNim() == id){
            return m;
        }
    }
    return null;
    
}


   public String showMahasiswa() {
       if (anggota != null) {
           for (int i = 0; i < anggota.size(); i++) {
               return i + anggota.toString();
           }
       }
       return null;
   }

   public String showTugas(){
       for (int i = 0; i < Tugas.size(); i++) {
           if (!Tugas.isEmpty()){
           return i+" . "+ Tugas.toString();
           }
           else return "Tidak ada Tugas";
       }
       return null;
   }
   
   
   public String toString(){
       return this.namaKelas + " - " + this.jmlMhs + " Orang. \n";
   }
   
   
}
