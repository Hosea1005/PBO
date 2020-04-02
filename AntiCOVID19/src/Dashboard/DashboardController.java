/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dashboard;

import hibernate.Covid;
import hibernate.NewHibernateUtil;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Pirates
 */
public class DashboardController implements Initializable {

    @FXML
    private AnchorPane layout;
    @FXML
    private Label totalTerkonfirmasi;
    @FXML
    private Label rasioTerkonfirmasi;
    @FXML
    private Label totalSembuh;
    @FXML
    private Label rasioSembuh;
    @FXML
    private Label totalDirawat;
    @FXML
    private Label rasioDirawat;
    @FXML
    private Label totalMeninggal;
    @FXML
    private Label rasioMeninggal;
    @FXML
    private TextField tambahTanggal;
    @FXML
    private TextField tambahTerkonfirmasi;
    @FXML
    private TextField tambahDirawat;
    @FXML
    private TextField tambahSembuh;
    @FXML
    private TextField tambahMeninggal;
    @FXML
    private Button btnTanggal;
    int hasila;
    Session session;
    private String tanggal;
    @FXML
    private BubbleChart<?, ?> chartBuble;
    @FXML
    private TableView<Datalist> tabel;
    @FXML
    private TableColumn<Datalist, Integer> tbltanggal;
    @FXML
    private TableColumn<Datalist, Integer> tblTerkonfirmasi;
    @FXML
    private TableColumn<Datalist, Integer> tblDirawat;
    @FXML
    private TableColumn<Datalist, Integer> tblsembyh;
    @FXML
    private TableColumn<Datalist, Integer> tblmeninggal;
    ObservableList list = FXCollections.observableArrayList();
    public static Datalist covid = null;
    @FXML
    private PieChart pieChart;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from Car";
        Query q = session.createQuery(hql);
        List lst = q.list();
        session.getTransaction().commit();
        session.close();
        setDataTable(lst);

        // TODO
    }

    

    @FXML
    private void dashboard(ActionEvent event) {
    }

    @FXML
    private void cekResiko(ActionEvent event) {
        
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/Cekresiko/Cekresiko.fxml"));
            Parent p = (Parent) fXMLLoader.load();
            Stage s = new Stage();
            s.setScene(new Scene(p));
            s.show();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void biodata(ActionEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/Biodata/Biodata.fxml"));
        Parent pa = (Parent) fXMLLoader.load();
        Stage s = new Stage();
        s.setScene(new Scene(pa));
        s.show();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void about(ActionEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/Biodata/Biodata.fxml"));
            Parent p = (Parent) fXMLLoader.load();
            Stage s = new Stage();
            s.setScene(new Scene(p));
                    s.show();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void logout(ActionEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/SplashScreen/Splashscreen.fxml"));
            Parent p = (Parent) fXMLLoader.load();
            Stage s = new Stage();
            s.setScene(new Scene(p));
                    s.show();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Exit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void btnTanggal(ActionEvent event) {
        DashboardController ds = new DashboardController();
        tanggal = ds.getTanggal()+","+ds.getWaktu();
        tambahTanggal.setText(tanggal);
    }

    @FXML
    private void btnReset(ActionEvent event) {
        tambahTanggal.setText("");
        tambahTerkonfirmasi.setText("");
        tambahSembuh.setText("");
        tambahDirawat.setText("");
        tambahMeninggal.setText("");
    }

    @FXML
    private void btnSimpan(ActionEvent event) {
        if (tambahTerkonfirmasi.getText().length() == 0 || tambahDirawat.getText().length() == 0 || tambahSembuh.getText().length() == 0 || tambahTanggal.getText().length() == 0 || tambahMeninggal.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(null, "Isi semua Field");
        }
        else{
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "INSERT INTO Covid(date,terkonfirmasi,rawat,sembuh,meninggal) values (:date,:terkonfirmasi,:rawat,:sembuh,:meninggal)";
            Query q = session.createSQLQuery(hql);
            q.setParameter("date", tanggal);
            q.setParameter("terkonfirmasi", tambahTerkonfirmasi.getText());
            q.setParameter("rawat", tambahDirawat.getText());
            q.setParameter("sembuh", tambahSembuh.getText());
            q.setParameter("meninggal", tambahMeninggal.getText());
            q.executeUpdate();
            session.getTransaction().commit();
            session.close();
            Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Hasil Cek Anda");
                a.setHeaderText("Hi , Hasil Test Anda adalah");
                a.setContentText("Resiko Rendah");
                a.showAndWait();
        }
        
    }
    private String getTanggal() {  
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");  
        Date date = new Date();  
        return dateFormat.format(date);  
    }  
     
    private String getWaktu() {  
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");  
        Date date = new Date();  
        return dateFormat.format(date);  
    } 
    private void setDataTable(List lst) {
        int num = 0;
        for (Object lst1 : lst) {
            Covid c = (Covid) lst1;
            list.add(new Datalist(c.getDate(), c.getTerkonfirmasi(), c.getRawat(), c.getSembuh(), c.getMeninggal()));
        }

        tbltanggal.setCellValueFactory(new PropertyValueFactory<>("date"));
        tblTerkonfirmasi.setCellValueFactory(new PropertyValueFactory<>("terkonfirmasi"));
        tblDirawat.setCellValueFactory(new PropertyValueFactory<>("rawat"));
        tblsembyh.setCellValueFactory(new PropertyValueFactory<>("sembuh"));
        tblmeninggal.setCellValueFactory(new PropertyValueFactory<>("meninggal"));

        tabel.setItems(list);
        tabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (tabel.getSelectionModel().getSelectedItem() != null) {
                    covid = tabel.getSelectionModel().getSelectedItem();
                }
            }
        });
    }

    @FXML
    private void pindah(ActionEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/Biodata/Biodata.fxml"));
        Parent pa = (Parent) fXMLLoader.load();
        Stage s = new Stage();
        s.setScene(new Scene(pa));
        s.show();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
