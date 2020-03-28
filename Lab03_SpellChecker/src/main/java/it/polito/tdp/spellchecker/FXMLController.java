package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	ObservableList<String> lingue = FXCollections.observableArrayList("English","Italian");
	
	private String selectedLanguage;

	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextArea txtInput;

    @FXML
    private Button btnSpell;

    @FXML
    private TextArea txtCorrect;

    @FXML
    private Label labelError;

    @FXML
    private Button btnClearTxt;

    @FXML
    private Label labelTime;

    @FXML
    void doClear(ActionEvent event) {
    	txtCorrect.clear();
    	txtInput.clear();
    	labelError.setVisible(false);
    	labelTime.setVisible(false);
    
    	
    }

    @FXML
    void doLanguage(ActionEvent event) {
    	
    	this.selectedLanguage = comboBox.getValue();
    	

    }

    @FXML
    void doSpell(ActionEvent event) {
    	    	
    	labelError.setVisible(true);
    	labelTime.setVisible(true);
    	long initialTime = System.nanoTime();
    	
    	if(this.selectedLanguage == null) {
    		txtCorrect.setText("Selezionare una lingua per tradurre!");
    	}else {
    		
    		String inputText = txtInput.getText();
    		String error = model.checkTest(selectedLanguage,inputText);
    		if(error.equals(""))
    			txtCorrect.setText("Non vi sono errori");
    		else {
    			txtCorrect.setText(error);
    			if(model.getErrorNumber()==1)
        			labelError.setText("The text contain "+ model.getErrorNumber()+ " error");
    			else
    				labelError.setText("The text contains "+ model.getErrorNumber()+ " errors");
    		}
        	long endTime = System.nanoTime();
        	labelTime.setText("Spell check time: " +(endTime-initialTime)/10e9+ " seconds");
    	}
    
    }

    @FXML
    void initialize() {
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorrect != null : "fx:id=\"txtCorrect\" was not injected: check your FXML file 'Scene.fxml'.";
        assert labelError != null : "fx:id=\"labelError\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClearTxt != null : "fx:id=\"btnClearTxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert labelTime != null : "fx:id=\"labelTime\" was not injected: check your FXML file 'Scene.fxml'.";
        
        comboBox.setItems(lingue);

    }

	public void setModel(Model model) {
		this.model = model;
	}
    
    
}

