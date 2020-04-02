/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dashboard;

/**
 *
 * @author Pirates
 */
public class Datalist {
    int idcovid;
    String date;
    Integer terkonfirmasi;
    Integer rawat;
    Integer sembuh;
    Integer meninggal;

    public Datalist(String date, Integer terkonfirmasi, Integer rawat, Integer sembuh, Integer meninggal) {
        this.date = date;
        this.terkonfirmasi = terkonfirmasi;
        this.rawat = rawat;
        this.sembuh = sembuh;
        this.meninggal = meninggal;
    }

    public int getIdcovid() {
        return idcovid;
    }

    public void setIdcovid(int idcovid) {
        this.idcovid = idcovid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTerkonfirmasi() {
        return terkonfirmasi;
    }

    public void setTerkonfirmasi(Integer terkonfirmasi) {
        this.terkonfirmasi = terkonfirmasi;
    }

    public Integer getRawat() {
        return rawat;
    }

    public void setRawat(Integer rawat) {
        this.rawat = rawat;
    }

    public Integer getSembuh() {
        return sembuh;
    }

    public void setSembuh(Integer sembuh) {
        this.sembuh = sembuh;
    }

    public Integer getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(Integer meninggal) {
        this.meninggal = meninggal;
    }
    
    
}
