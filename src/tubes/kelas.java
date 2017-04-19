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
public class kelas {
    private mata_kuliah mk;
    private mahasiswa[] anggota;
    private String namaKelas;
    private tugas[] Tugas;
    private int jmlMhs = 0; //jml mhs
    private int jmlTgs = 0; //jml tugas
    
    public kelas(String namaKelas){
        this.namaKelas = namaKelas;
        //this.mk = mk;
        this.anggota = new mahasiswa[40];
        this.Tugas = new tugas[10];
        
    }

    public void setMk(mata_kuliah mk) {
        this.mk = mk;
    } 
    
public boolean isAdaTugas(String tugas){
    for (int i = 1; i<= this.jmlTgs+1; i++){
        if (this.Tugas[i].getNt().equals(tugas))
            return true;
            break;
    }
    return false;
    
}

    public mata_kuliah getMk() {
        return mk;
    }

    public String getNamaKelas() {
        return namaKelas;
    }
    
    public tugas getTugasIdx(int x){
        return this.Tugas[x];
    }

public void addMahasiswa(mahasiswa m){
    this.jmlMhs++;
    anggota[jmlMhs] = m;
}

public void addMataKuliah(mata_kuliah mkl){
    mk = mkl;
 }

public void createTugas(String tugas){
    this.jmlTgs++;
    this.Tugas[this.jmlTgs] = new tugas(tugas);
}

    public int getJml() {
        return jmlMhs;
    }

    public int getJmlT() {
        return jmlTgs;
    }
    
    public boolean removeTugas(String tugas){
      for (int i = 1; i<= this.jmlTgs+1; i++){
        if (this.Tugas[i].getNt().equals(tugas)){
            if ( i != this.jmlTgs ){
             for (int j = i; i<= this.jmlTgs; i++){
                 this.Tugas[j] = this.Tugas[j+1];
             } 
        } else {
            this.Tugas[i] = null;
        }return true;
        }
    }
return false;
    }
    
public mahasiswa getMhsID(long id){
    for (int i = 1; i<= this.jmlMhs; i++){
        long x = this.anggota[i].getNim();        
        if (x == id){
            return anggota[i];           
        }
     }
    return null;
    
}

public mahasiswa getMhsIdx(int x){//get kelas by indeks
 return anggota[x];   
}


   public String showMahasiswa() {
   if (jmlMhs != 0){
       for (int i = 1; i< this.jmlMhs; i++){
       return i + " . "+ this.anggota[i].toString() ;
    }
   }
   else return "Kelas kosong";
   return null;
   }

   public String showTugas(){
       for (int i = 0; i<=this.jmlTgs+1; i++){
           if (jmlTgs >=1)
           return i+" . "+ this.Tugas[i].toString();
           else return "Tidak ada Tugas";
       }
       return null;
   }
   public String toString(){
       return this.namaKelas + " - " + this.jmlMhs + " Orang. \n";
   }
   
   
}
