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
public class mata_kuliah {
    private String namaMatkul;
    private int sks;

    public mata_kuliah(String mk,int sks){
        this.namaMatkul = mk;
        this.sks = sks;
    }

    public int getSks() {
        return sks;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }
    
}
