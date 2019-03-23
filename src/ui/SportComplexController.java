package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import model.SportComplex;
import javafx.fxml.Initializable;

// Class

public class SportComplexController implements Initializable {

	// Attributes

    @FXML
    private TextArea taView;
    private SportComplex sportComplex;

    // Methods

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sportComplex = new SportComplex();
	}

	@FXML
	public void controlBtImport(ActionEvent event) {
		try {
			sportComplex.importData();
			taView.setText(sportComplex.getInformation());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void controlBtExport(ActionEvent event) {
		try {
			sportComplex.exportReport();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}


}
