/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SplashScreen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Pirates
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Button btnLogin;
    @FXML
    private TextField tfUsername;
    @FXML
    private Button btnReset;
    @FXML
    private TextField tfPassword;
    private AnchorPane layout;
    File f = new File("D:\\UTS\\AntiCOVID19\\dblogin");
    String username,password;
    int ln;
    void readFile(){
        try {
            FileReader fr = new FileReader(f+"\\64081411.txt");
            System.err.println("file exists");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f+"\\64081411.txt");
                System.out.println("File Created");
            } catch (IOException ex1) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        
    }
    void checkAkun(String user,String pswd){
        
        try {
            RandomAccessFile check = new RandomAccessFile(f+"\\64081411.txt","rw");

            for(int i=0 ;i<ln;i+=3){
                
                String usera = check.readLine().substring(0);
                String pswda = check.readLine().substring(0);
                if(user.equals(usera) & pswd.equals(pswda)){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Anda berhasil login");
                    a.showAndWait();
                    FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/Cekresiko/Cekresiko.fxml"));
                    Parent p = (Parent) fXMLLoader.load();
                    Stage s = new Stage();
                    s.setScene(new Scene(p));
                    s.show();
                    break;
                    
                    
                }
                else if(i==(ln-3)){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Anda gagal login");
                    a.showAndWait();
                break;
                }
            }
            
            for(int k=1;k<=2;k++){
                check.readLine();
            }
        
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    void countLines(){
        try {
            ln=1;
            RandomAccessFile check = new RandomAccessFile(f+"\\64081411.txt","rw");
            for(int i =0;check.readLine()!=null;i++){
                ln++;
            }
            System.out.println("no baris"+ln);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionLogin(ActionEvent event) {
        readFile();
        countLines();
        checkAkun(tfUsername.getText(),tfPassword.getText());
    }

    @FXML
    private void actionReset(ActionEvent event) {
        tfUsername.setText("");
        tfPassword.setText("");
    }
    
}
