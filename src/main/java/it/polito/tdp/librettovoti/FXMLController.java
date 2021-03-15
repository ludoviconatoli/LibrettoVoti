package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNomeEsame;

    private Libretto model;
    
    @FXML
    private TextField txtVoto;

    @FXML
    private DatePicker pickerEsame;
    
    @FXML
    private Button btInserisci;
    
    /*@FXML
    private TextField txtData;
*/
    @FXML
    private TextArea txtResult;

    public void setModel(Libretto model) {
    	this.model = model;
    }
    
    @FXML
    void handleInserisci(ActionEvent event) {
    	//controllo i dati
    	String nomeEsame = txtNomeEsame.getText();
    	if(nomeEsame.length() == 0) {
    		txtResult.setText("ERRORE: nome esame vuoto");
    		return;
    	}
    	
    	String votoEsame = txtVoto.getText();
    	int votoInt = 0;
    	try {
    	   votoInt = Integer.parseInt(votoEsame);
    	}catch(NumberFormatException nfe) {
    		txtResult.setText("ERRORE: voto deve essere un numero intero");
    		return;
    	}
    	if(votoInt < 18 || votoInt > 30)
    	{
    		txtResult.setText("ERRORE: Il voto deve essere compreso tra 18 e 30");
    		return;
    	}
    	
    	/*String dataEsame = txtData.getText();
    	LocalDate data;
    	try{
    		data = LocalDate.parse(dataEsame);
    	}catch(DateTimeParseException ex) {
    		txtResult.setText("ERRORE: la data non e nel formato corretto");
    		return;
    	}*/
    	
    	LocalDate data = pickerEsame.getValue();
    	if(data == null) {
    		txtResult.setText("ERRORE: la data è obbligatoria");
    		return;
    	}
    	//esegui l'azione
    	Voto voto = new Voto(nomeEsame, votoInt, data);
    	model.add(voto);
    	
    	//Aggiorna i risultati nella view
    	txtResult.setText(model.toString());
    	txtNomeEsame.clear();
    	txtVoto.clear();
    	//txtData.clear();
    	pickerEsame.setValue(null);
    }
    
    @FXML
    void initialize() {
        assert txtNomeEsame != null : "fx:id=\"txtNomeEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
  //      assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btInserisci != null : "fx:id=\"btInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert pickerEsame != null : "fx:id=\"pickerEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}