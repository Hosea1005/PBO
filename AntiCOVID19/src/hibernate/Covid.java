package hibernate;
// Generated Apr 1, 2020 9:05:24 PM by Hibernate Tools 4.3.1



/**
 * Covid generated by hbm2java
 */
public class Covid  implements java.io.Serializable {


     public int idcovid;
     private String date;
     private Integer terkonfirmasi;
     private Integer rawat;
     private Integer sembuh;
     private Integer meninggal;

    public Covid() {
    }

	
    public Covid(int idcovid) {
        this.idcovid = idcovid;
    }
    public Covid(String date, Integer terkonfirmasi, Integer rawat, Integer sembuh, Integer meninggal) {
       this.date = date;
       this.terkonfirmasi = terkonfirmasi;
       this.rawat = rawat;
       this.sembuh = sembuh;
       this.meninggal = meninggal;
    }
   
    public int getIdcovid() {
        return this.idcovid;
    }
    
    public void setIdcovid(int idcovid) {
        this.idcovid = idcovid;
    }
    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    public Integer getTerkonfirmasi() {
        return this.terkonfirmasi;
    }
    
    public void setTerkonfirmasi(Integer terkonfirmasi) {
        this.terkonfirmasi = terkonfirmasi;
    }
    public Integer getRawat() {
        return this.rawat;
    }
    
    public void setRawat(Integer rawat) {
        this.rawat = rawat;
    }
    public Integer getSembuh() {
        return this.sembuh;
    }
    
    public void setSembuh(Integer sembuh) {
        this.sembuh = sembuh;
    }
    public Integer getMeninggal() {
        return this.meninggal;
    }
    
    public void setMeninggal(Integer meninggal) {
        this.meninggal = meninggal;
    }




}


