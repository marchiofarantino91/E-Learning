/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;
import java.lang.reflect.Array;
import java.util.*;
/**
 *
 * @author MARCHIO
 */
public class Aplikasi {
    private ArrayList<orang> person;
    private ArrayList<mata_kuliah> daftarMatakuliah;
    private int bykPerson = 0;
    private int mk = 0;//daftar matkul
    private Scanner cin = new Scanner(System.in);
    private  int x = 0;
    private dosen call; //caller
    private mahasiswa call1; //caller
    private dosen userD; //caller
    private mahasiswa userM; //caller                                     
    private orang user;
    
    
    //function add
    
    public void addMatkul(String nama,int sks){
       this.daftarMatakuliah.add(new mata_kuliah(nama,sks));
    }
       public void addMahasiswa(String nama, long nim,String u,String pw){
      this.person.add(new mahasiswa(nama,nim,u,pw)) ;
    }
    public void addDosen(String nama, String kd,long nip,String u, String pw){
        this.person.add(new dosen(nama,kd,nip,u,pw));
    }
    public void addKelas(String kelas,String kode){
       this.call= (dosen) getDosenKD(kode);
    }
    
    
    //end function add
    //getter
    
public orang getOrang(String user){
    for (orang o : person) {
        if (o.getUser().equals(user))
            return o;
            }
    return null;
}
    public orang getNIMMahasiswa(long nim){//getMahasiswaByNimTerdaftar
        for (orang o : person){
            if (o instanceof mahasiswa){
                this.call1 = (mahasiswa) o;
                    if (this.call1.getNim() == nim){
                       return o;
                    }
    }
        }
        return null;
}
    
    public orang getDosenKD(String kd){
          for (orang o : person){
           if (o instanceof dosen ){
               this.call = (dosen) o;
               if (this.call.getKode().equals(kd)){
               return o;
               }
           }
        }
        return null;
    }    
    public mata_kuliah getMatkul(String nama){//getMatkulByName
        for (mata_kuliah o : daftarMatakuliah){
            if (o.getNamaMatkul().equals(nama)){
                return o;
            } 
        }
        return null;
    }
    
    public kelas getKelas(String nama){
        return userD.getKelas(nama);
    }
    
    
    //end getter
    //delete
    
    
public void deletePersonName(String nama){//deletePersonOnName
            person.remove(this.getOrang(nama));
    }
    public void deleteDosen(String kd){
        person.remove(this.getDosenKD(kd));
    }
    public void deleteMahasiswa(long nim){
        person.remove(this.getNIMMahasiswa(nim));
        
    }
    public void deleteMatkul(String nama){
        person.remove(this.getMatkul(nama));
    }
    //end Delete1
    
public boolean isCorrect(String pw){
    for (orang o : person){
        if (o.getPw().equals(pw))
            return true;
    }
    return false;
}

public void setUser(orang o){
    this.user = o;
}
      
  
  public void ShowlistDosen(){//showListDosen
        for (orang o : person){
            if (o instanceof dosen){
                this.call = (dosen) o;
                 this.call.toString();
            }           
        }
    }
  
  //show list 
      public void listMahasiswa(dosen D,String kelas){
          D.getKelas(kelas).showMahasiswa();
      }
       public void ShowlistMatkul(){//showListMatkulTerdaftar
        for (mata_kuliah o :daftarMatakuliah){
           o.toString();
        }
    }
         
    
    
}
