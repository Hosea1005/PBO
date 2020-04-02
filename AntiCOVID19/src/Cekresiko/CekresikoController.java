/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cekresiko;

import hibernate.NewHibernateUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Pirates
 */
public class CekresikoController implements Initializable {

    @FXML
    private RadioButton ya;
    @FXML
    private ToggleGroup satu;
    @FXML
    private RadioButton ta;
    @FXML
    private RadioButton yb;
    @FXML
    private ToggleGroup dua;
    @FXML
    private RadioButton yc;
    @FXML
    private ToggleGroup tiga;
    @FXML
    private RadioButton yd;
    @FXML
    private ToggleGroup empat;
    @FXML
    private RadioButton ye;
    @FXML
    private ToggleGroup lima;
    @FXML
    private RadioButton yf;
    @FXML
    private ToggleGroup enam;
    @FXML
    private RadioButton yg;
    @FXML
    private ToggleGroup tujuh;
    @FXML
    private RadioButton yh;
    @FXML
    private ToggleGroup delapan;
    @FXML
    private RadioButton yi;
    @FXML
    private ToggleGroup sembilan;
    @FXML
    private RadioButton yj;
    @FXML
    private ToggleGroup sepuluh;
    @FXML
    private RadioButton yk;
    @FXML
    private ToggleGroup sebelas;
    @FXML
    private RadioButton yl;
    @FXML
    private ToggleGroup duabelas;
    @FXML
    private RadioButton ym;
    @FXML
    private ToggleGroup tigabelas;
    @FXML
    private RadioButton yn;
    @FXML
    private ToggleGroup empatbelas;
    @FXML
    private RadioButton yo;
    @FXML
    private ToggleGroup limabelas;
    @FXML
    private RadioButton yp;
    @FXML
    private ToggleGroup enambelas;
    @FXML
    private RadioButton yq;
    @FXML
    private ToggleGroup tujuhbelas;
    @FXML
    private RadioButton tb;
    @FXML
    private RadioButton tc;
    @FXML
    private RadioButton td;
    @FXML
    private ToggleGroup duasatu;
    @FXML
    private ToggleGroup sembilanbelas;
    @FXML
    private ToggleGroup duapuluh;
    @FXML
    private ToggleGroup delapanbelas;
    @FXML
    private RadioButton yr;
    @FXML
    private RadioButton ys;
    @FXML
    private RadioButton yt;
    @FXML
    private RadioButton yu;
    @FXML
    private Label nilai;
    
    private int h;
    Session session;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        // TODO
    }    

    @FXML
    private void dashboard(ActionEvent event) {
    }

    @FXML
    private void cekResiko(ActionEvent event) {
    }

    @FXML
    private void biodata(ActionEvent event) {
    }

    @FXML
    private void about(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) {
    }

    @FXML
    private void Exit(ActionEvent event) {
    }

    @FXML
    private void btnCek(ActionEvent event) {
        String tinggi="Resiko Tinggi";
        String sedang = "Resiko Sedang";
        String rendah = "Resiko Rendah";
        check();
        nilai.setText(Integer.toString(h));
        session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "INSERT INTO Cek(hasil) values (:hasil)";
            Query q = session.createSQLQuery(hql);
            
            if(h>=0 && h<=7){
                q.setParameter("hasil", rendah);
                q.executeUpdate();
                session.getTransaction().commit();
                session.close();
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Hasil Cek Anda");
                a.setHeaderText("Hi , Hasil Test Anda adalah");
                a.setContentText("Resiko Rendah");
                a.showAndWait();
            }
            if(h>=8 && h<=14){
                q.setParameter("hasil", sedang);
                q.executeUpdate();
                session.getTransaction().commit();
                session.close();
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Hasil Cek Anda");
                a.setHeaderText("Hi , Hasil Test Anda adalah");
                a.setContentText("Resiko Sedang");
                a.showAndWait();
            }
            if(h>=15 && h<=21){
                q.setParameter("hasil", tinggi);
                q.executeUpdate();
                session.getTransaction().commit();
                session.close();
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Hasil Cek Anda");
                a.setHeaderText("Hi , Hasil Test Anda adalah");
                a.setContentText("Resiko Tinggi");
                a.showAndWait();
            }
            
    }
    public void check(){
        if(ya.isSelected()){
            h ++;
        }
        if(yb.isSelected()){
            h ++;
        }
        if(yc.isSelected()){
            h ++;
        }
        if(yd.isSelected()){
            h ++;
        }
        if(ye.isSelected()){
            h ++;
        }
        if(yf.isSelected()){
            h ++;
        }
        if(yg.isSelected()){
            h ++;
        }
        if(yh.isSelected()){
            h ++;            
        }
        if(yi.isSelected()){
            h ++;            
        }
        if(yj.isSelected()){
            h ++;
        }
        if(yk.isSelected()){
            h ++;
        }
        if(yl.isSelected()){
            h ++;
        }
        if(ym.isSelected()){
            h ++;
        }
        if(yn.isSelected()){
            h ++;
        }
        if(yo.isSelected()){
            h ++;
        }
        if(yp.isSelected()){
            h ++;
        }
        if(yq.isSelected()){
            h ++;
        }
        if(yr.isSelected()){
            h ++;
        }
        if(ys.isSelected()){
            h ++;
        }
        if(yt.isSelected()){
            h ++;
        }
        if(yu.isSelected()){
            h ++;
        }
    }
    
}
