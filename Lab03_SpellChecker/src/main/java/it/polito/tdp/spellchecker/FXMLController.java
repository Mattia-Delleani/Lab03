package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<?> choiceBox;

    @FXML
    private TextArea txtResult;

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

    }

    @FXML
    void doSpell(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorrect != null : "fx:id=\"txtCorrect\" was not injected: check your FXML file 'Scene.fxml'.";
        assert labelError != null : "fx:id=\"labelError\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClearTxt != null : "fx:id=\"btnClearTxt\" was not injected: check your FXML file 'Scene.fxml'.";
        assert labelTime != null : "fx:id=\"labelTime\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}



