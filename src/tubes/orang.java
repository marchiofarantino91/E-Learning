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
public abstract class orang {
     
private String nama;
private String user;
private String pw;


public orang(String nama,String u,String pw){
    this.nama = nama;
    this.user = u;
    this.pw = pw;
}

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public String getUser() {
        return user;
    }

    public String getPw() {
        return pw;
    }





}
