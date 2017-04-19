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
public class dosen extends orang {
    private String kd;//kode
    private long nip;
    private kelas daftarkelas[] = new kelas[5];
    private int listKelas= 0;

   public dosen(String nama, String kd, long nip, String u, String pw) {
      super(nama,u,pw);
        this.nip = nip;
        this.kd = kd;
        this.daftarkelas = new kelas[5];
    }

    public int getListKelas() {
        return listKelas;
    }
 
    

    public String getKode() {
        return kd;
    }

    public long getNip() {
        return nip;
    }
    

    
    public void createKelas (String namaKelas){
        this.listKelas++;
        kelas k = new kelas(namaKelas);
        this.daftarkelas[listKelas] = k;
    }
    
    public kelas getKelas(String kelas){
        for (int i = 1; i<= this.listKelas; i++){
            if (this.daftarkelas[i].getNamaKelas() == kelas){
                return this.daftarkelas[i];
            }
        }
        return null;
    }
    public kelas getKelasIdx(int x){
        return this.daftarkelas[x];
    }
    
    public boolean removeKelas(String kelas){
    for (int i = 1; i <= this.listKelas; i++){
        if (this.daftarkelas[i].getNamaKelas() == kelas){//cek di data
           for (int j = i; i< this.listKelas; i++){ // geser
                if (j != this.listKelas){
                    this.daftarkelas[j]=this.daftarkelas[j+1];
                }
                else{
                    this.daftarkelas[j]=null;
                }
            }
           return true;           
                    }
            
    }
    return false;
    }
    
    public void removeKelasIdx(int x){
        if (x == this.listKelas){
            this.daftarkelas[x]=null;
        }
        else {
            for (int i = x; i<=this.listKelas; i++){
                this.daftarkelas[x] = this.daftarkelas[x+1];
            }
            this.daftarkelas[listKelas]=null;
        }
    }
    
    
    
    public String showKelas(){
        for (int i =1 ; i<= this.listKelas; i++){
            if (this.listKelas < 1 ){
                return  "Kelas Kosong";
            }
            else {
             return  i+" . "+this.daftarkelas[i].toString();}
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
    
    public boolean removeTugas(kelas k, String nama){
        if (k.isAdaTugas(nama)){
            if (k.removeTugas(nama));
            return true;
        }
        return false;
    }
    

}


