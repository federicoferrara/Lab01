package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;
    
    @FXML
    private TextField txtEsecuzione;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	// TODO
    	double inizio= System.nanoTime();
    	this.txtResult.clear();
//    	this.txtParola.clear();
    	
    	String p;
    	
//    	try {
//    		p=this.txtParola.getText();
//    	} catch(Exception e) {
//    		this.txtResult.appendText("Devi inserire una parola!");
//    		return;
//    	}
    	
    	p=this.txtParola.getText();
    	
    	this.elenco.addParola(p);
    	
    	for(String s: this.elenco.getElenco()) {
    		this.txtResult.appendText(s+"\n");
    	}
    
    	double fine= System.nanoTime();
    	this.txtEsecuzione.setText(""+(fine-inizio));
    }

    @FXML
    void doCancella(ActionEvent event) {

    	double inizio= System.nanoTime();
    	
    	String s= this.txtResult.getSelectedText();
    	this.elenco.cancella(s);
    	
    	this.txtResult.clear();
    	
    	for(String ss: this.elenco.getElenco()) {
    		this.txtResult.appendText(ss+"\n");
    	}
    	
    	double fine= System.nanoTime();
    	this.txtEsecuzione.setText(""+(fine-inizio));
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	double inizio= System.nanoTime();
    	
    	this.txtResult.clear();
    	this.txtParola.clear();
    	this.elenco.reset();
    	
    	double fine= System.nanoTime();
    	this.txtEsecuzione.setText(""+(fine-inizio));
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtEsecuzione != null : "fx:id=\"txtEsecuzione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
