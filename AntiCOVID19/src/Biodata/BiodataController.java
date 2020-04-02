/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Biodata;

import hibernate.NewHibernateUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Pirates
 */
public class BiodataController implements Initializable {

    @FXML
    private AnchorPane layout;
    @FXML
    private TextField tfNama;
    @FXML
    private TextField tfJenisKelamin;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnSimpan;
    
    Session session;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
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
    private void btnReset(ActionEvent event) {
        tfNama.setText("");
        tfJenisKelamin.setText("");
    }

    @FXML
    private void btnSimpan(ActionEvent event) {
        if (tfNama.getText().length() == 0 || tfJenisKelamin.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Isi semua Field");
        }
        else{
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "INSERT INTO Biodata(nama,jeniskelamin) values (:nama,:jeniskelamin)";
            Query q = session.createSQLQuery(hql);
            q.setParameter("nama", tfNama.getText());
            q.setParameter("jeniskelamin", tfJenisKelamin.getText());
            q.executeUpdate();
            session.getTransaction().commit();
            session.close();
            tfNama.setText("");
            tfJenisKelamin.setText("");
        }
    }
    
}
