/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;
import java.util.*;
/**
 *
 * @author MARCHIO
 */
public class Aplikasi {
    private mata_kuliah daftarMatakuliah[] = new mata_kuliah[30];
    private orang person[] = new orang[30];
    private int bykPerson = 0;
    private int mk = 0;//daftar matkul
    private Scanner cin = new Scanner(System.in);
    private  int x = 0;
    private dosen call; //caller
    private mahasiswa call1; //caller
    private dosen userD; //caller
    private mahasiswa userM; //caller                                     
    private orang user;
    
    
public orang getOrang(String user){
    for (orang o : person) {
        if (o.getUser().equals(user))
            return o;
            }
    return null;
}
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
    
public void deletePerson(String nama){//deletePersonOnName
    for (int i = 1; i<= this.bykPerson; i++){
        if (person[i].getNama().equals(nama) ){
            if (i == bykPerson){
                person[i]=null;
            }
            else{
                for(int j = i; j <= this.bykPerson; j++){
                    person[j] = person[j+1];
                }
                person[bykPerson] = null;
            }
        }
    }
}

//mahasiswa
    public void deleteMahasiswa(long nim){//deleteMhsByNim
        for (int i = 1; i<= this.bykPerson; i++){ //mencari mahasiswa di person
            if (this.person[i] instanceof mahasiswa && i != this.bykPerson){   //cek instance
                this.call1 = (mahasiswa) this.person[i];    //call1
                    if (this.call1.getNim() == nim){   //cek call1 cocok nim
                       for (int j = i; i<= this.bykPerson; j++){//geser person
                          if (j!= this.bykPerson){
                             this.person[j]=this.person[j+1];
                                                 }
                            else {
                                this.person[j]=null;
                                 }
                   break;  
                   }
                                                    } 
                                                    }
            else {
                System.out.println("Maaf, data Tidak ditemukan.");
                break;
            }
                            }
        }
        
    public mahasiswa getNIMMahasiswa(long nim){//getMahasiswaByNimTerdaftar
        for (int i = 1; i<= this.bykPerson; i++){
            if (this.person[i] instanceof mahasiswa){
                this.call1 = (mahasiswa) this.person[i];
                    if (this.call1.getNim() == nim){
                        return this.call1;
                    }
    }
        }
        return null;
    }
    //endMhs
    
    //dosen
    public dosen getDosenKD(String kd){
          for (int i = 1; i<= this.bykPerson; i++){
           if (this.person[i] instanceof dosen ){
               this.call = (dosen) this.person[i];
               if (this.call.getKode().equals(kd)){
               return this.call;
               }
           }
        }
        return null;
    }
    
  
  public void ShowlistDosen(){//showListDosen
        for (int i = 1; i<= this.bykPerson; i++){
            if (this.person[i] instanceof dosen){
                this.call = (dosen) this.person[i];
                 System.out.println(i+". "+ this.call.getKode()+ " - "+ this.call.getNama());
            }           
        }
    }
  
  //show list mahasiswa di kelas
      public void listMahasiswa(dosen D,String kelas){
          D.getKelas(kelas).showMahasiswa();
      }
    
//endDosen
    
    
    
    //matkul           
 
    
    public void ShowlistMatkul(){//showListMatkulTerdaftar
        for (int i = 1; i<= this.mk; i++){
            System.out.println(i+ " . "+ this.daftarMatakuliah[i].getNamaMatkul()+ " - "+ this.daftarMatakuliah[i].getSks() );
        }
    }
    
    public mata_kuliah getMatkul(String nama){//getMatkulByName
        for (int i = 1; i<this.mk; i++){
            if (this.daftarMatakuliah[i].getNamaMatkul().equals(nama)){
                return this.daftarMatakuliah[i];
            } 
        }
        return null;
    }
    
   
                        //endMatkul
//------------------------------------------------------------------------------
                        //menuSection
    public void mainMenu(){
        System.out.println("Selamat datang di aplikasi e-Learning");
        System.out.println("Silahkan pilih menu:");
        System.out.println("1. Mendaftar");
        System.out.println("2. Login");        
        System.out.println("3. Exit");
        x = cin.nextInt();
 switch (x){
           case 1 : {
               System.out.println("Pilihan mendaftar: ");
               System.out.println("1. Mahasiswa ");
               System.out.println("2. Dosen ");
               x = cin.nextInt();
               switch (x){
                   case 1 :
                       this.regMahasiswa();
                       break;
                   case 2 :
                       this.regDosen();
                       break;
                }
           }
          case 2 : {
               this.menuLogin();break;
           }
           case 3 : {
               System.out.println("Terima Kasih");
               break;
           }          
           default:
               System.out.println("Perintah salah silahkan coba lagi");
               this.mainMenu();
               break;
    }
 
       }

    
    
    public void menuLogin(){//Login
        System.out.println("Masukkan Username: ");String u = cin.next();
        System.out.println("Masukkan Password: ");String p = cin.next();
        //cek di databese person
        for (int i = 1; i<=this.bykPerson+3; i++){
             if (!(this.person[i].getUser().equals(u)) && !(this.person[i].getPw().equals(p)) && i == this.bykPerson ){//kalau tidak ada yg cocok
                System.out.println("Maaf User tidak terdaftar");
                this.mainMenu();
                break;
            }else 
            if (this.person[i].getUser().equals(u) && this.person[i].getPw().equals(p)){//kalo cocok
                System.out.println("Login Berhasil");
                System.out.println("Selamat Datang "+ person[i].getNama());
                    if (person[i] instanceof mahasiswa ){//kalo mahasiswa
                        this.menuMahasiswa();
                        break;
                    }
                    else {//kalo dosen
                        this.menuDosen();
                        break;
                    }
            }
           
        }
    }
    
    
    public void menuMahasiswa(){//menuMahasiswa
        
        System.out.println("1. Mendaftar Kelas");
        System.out.println("2. Lihat Tugas");
        System.out.println("3. Lihat Kelas");
        System.out.println("4. Lihat Dosen");
        System.out.println("5. Lihat Mata Kuliah");
        System.out.println("6. Logout");
        
        x = cin.nextInt();
       switch(x){
           case 1 : this.regKelas();break;
           case 2 : this.seeTugas();break;
           case 4 : this.ShowlistDosen();break;
           case 3: this.showKelas();break;
           case 5: this.ShowlistMatkul();break;
           case 6: {
               this.userM = null;
               this.mainMenu();break;
           
           }
       }
       
    }
    

 public void menuDosen(){//menuDosen
     System.out.println("1. Tambah Kelas");
     System.out.println("2. Hapus Kelas ");
     System.out.println("3. Tambah Mata Kuliah");
     System.out.println("4. Tambah Tugas");
     System.out.println("5. Logout");
     x = cin.nextInt();
           switch(x){
         case 1:{
             this.TambahKelas();break;
         }
         case 4 : 
             this.addTugas();break;
         
         case 3 :
             this.regMatkul();break;
         case 2 :
             this.hapusKelas();break;
         case 5 : 
             this.userD = null;
             this.mainMenu();break;
             
     }
 }
                        //endMenu


                    //Menu Mahasiswa
    public void addMahasiswa(String nama, long nim,String u,String pw){
       this.bykPerson++;
        this.person[this.bykPerson] = new mahasiswa(nama,nim,u,pw);
    }
    
    
    
    public void regMahasiswa(){//daftar mahasiswa ke person
        System.out.println("Silahkan masukkan data diri anda");
        System.out.println("Username : "); String u = cin.next();
        System.out.println("Password : "); String p = cin.next();
        System.out.println("Nama : "); String nm = cin.next();
        System.out.println("NIM: "); long nim = cin.nextLong();
        this.addMahasiswa(nm, nim,u, p);
        System.out.println("Mahasiswa Telah ditambahkan");
        this.mainMenu();
    }
    
    public void regKelas(){//daftarkan kelas ke list kelas
        //get dosen by kode dosen
        System.out.println("Masukkan Kelas: ");String s = cin.next();
        System.out.println("Masukkan Kode Dosen:");String k = cin.next();
        dosen d = this.getDosenKD(k);
        if (d != null){
            kelas kls = d.getKelas(s);
            kls.addMahasiswa(userM);
            System.out.println("Berhasil mendaftarkan.");
        }
        else {System.out.println("maaf, dosen tidak terdaftar.");
    }
        this.mainMenu();
    }
    
    public void showKelas(){ //show kelas diajar oleh dosen
       System.out.println("Masukkan Kode Dosen:");String k = cin.next();
        dosen d = this.getDosenKD(k);
        if (d != null){
           d.showKelas();
        }
        else {
            System.out.println("maaf, dosen tidak terdaftar."
            );
        this.menuMahasiswa();
    }
    }
    
    public void seeTugas(){//menunjukkan list kelas
       
        System.out.println("Masukkan Kelas: ");String s = cin.next();
        System.out.println("Masukkan Kode Dosen:");String k = cin.next();
        dosen d = this.getDosenKD(k);
        if (d != null){
            kelas kls = d.getKelas(s);
            if (kls != null){
            kls.showTugas();}
            else {
                System.out.println("Maaf, Kelas tidak terdaftar.");
            }
        }
        else {
            System.out.println("maaf, dosen tidak terdaftar.");
       
    }
         this.menuMahasiswa();
    }
                        //EndMenuMahasiswaDirect
   //-------------------------------------------------------------------------
                            //MENU DOSEN
    
    public void addDosen(String nama, String kd,long nip,String u, String pw){
        this.bykPerson++;
        this.person[bykPerson] = new dosen(nama,kd,nip,u,pw);
        
    }
    
    public void regDosen(){//registrasi dosen ke person
        System.out.println("Silahkan masukkan data diri anda");
        System.out.println("User: "); String u = cin.next();
        System.out.println("Password: "); String p = cin.next();
        System.out.println("Nama: "); String n = cin.next();
        System.out.println("NIP: "); long ni = cin.nextLong();
        System.out.println("Kode: "); String k = cin.next();
       this.addDosen(n, k, ni,u,p);
       System.out.println("Data Terdaftar");
       this.mainMenu();
}
    
    
    public void regMatkul(){//registrasi matkul
        System.out.println("Masukkan data mata kuliah yang ingin ditambahkan: ");
        System.out.print ("Nama Mata Kuliah : "); String n = cin.next();
        System.out.print("SKS  : "); int s = cin.nextInt();
        this.addMatkul(n, s);
        System.out.println("Mata Kuliah Telah ditambahkan");
        this.menuDosen();
       }
  
        public void TambahKelas(){//tambah kelas ke list dosen
        System.out.println("Masukkan nama kelas :"); String n = cin.next();
        this.userD.createKelas(n);
        System.out.println("Kelas telah ditambahkan.");
        menuDosen();
    }
        
     public void hapusKelas(){
        System.out.println("Masukkan nama kelas :"); String n = cin.next();
           if (!this.userD.removeKelas(n)){
               System.out.println("Data kelas tidak ada.");
           }
           else{
               System.out.println("Kelas telah dihapus.");
           }
           menuDosen();
          }   
    
        
      public void addMatkul(String nama, int sks){
        this.mk++;
        this.daftarMatakuliah[mk] = new mata_kuliah(nama,sks);
    }
      
      public void asignMatkul(){
        System.out.println("Masukkan nama Maka Kuliah");String t = cin.next();
        System.out.println("Masukkan Kelas"); String k = cin.next();
        this.userD.getKelas(k).addMataKuliah(this.getMatkul(t));
        System.out.println("Mata Kuliah berhasil didaftarkan ke kelas");
        menuDosen();
      }
      
      public void addTugas(){
          System.out.println("Masukkan nama Tugas");String t = cin.next();
          System.out.println("Masukkan Kelas yang ingin ditambahkan tugas"); String k = cin.next();
          if (this.userD.getKelas(k)!= null){
          this.userD.addTugas(this.userD.getKelas(k), t);
              System.out.println("Tugas berhasil ditambahkan.");
          }
          else{
              System.out.println("Kelas tidak terdaftar.");
          }
          menuDosen();
      }
      
      public void removeTugas(){
          System.out.print("Masukkan Kelas yang ingin dihapus tugasnya: "); String k = cin.next(); 
          System.out.print("Masukkan nama Tugas");String tu = cin.next();
          if (!this.userD.removeTugas(this.userD.getKelas(k), tu))
              System.out.println("Tugas tidak ditemukan");
          else {
              System.out.println("Tugas berhasil dihapus.");
        }
          menuDosen();
      }
         
    
    
}
