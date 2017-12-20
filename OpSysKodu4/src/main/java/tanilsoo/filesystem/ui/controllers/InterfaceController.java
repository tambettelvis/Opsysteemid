package tanilsoo.filesystem.ui.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import tanilsoo.filesystem.FilesSystem;
import tanilsoo.filesystem.Memory;
import tanilsoo.filesystem.ui.UserInterface;

public class InterfaceController implements Initializable {

	@FXML
	private BorderPane mainPanel;
	@FXML
	private GridPane gridPanel;
	@FXML
	private TextArea solutionTextArea;
	@FXML
	private TextField userPatternField;
	
	@FXML private Label patternLabel1;
	@FXML private Label patternLabel2;
	@FXML private Label patternLabel3;
	
	@FXML private ToggleGroup inputToggleGroup;
	@FXML private RadioButton rb1;
	@FXML private RadioButton rb2;
	@FXML private RadioButton rb3;
	@FXML private RadioButton rb4;
	
	private TableDrawer tableDrawer;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tableDrawer = new TableDrawer(UserInterface.WIDTH, 500);
		mainPanel.setBottom(tableDrawer);
	}
	
	
	@FXML
	private void startButtonClicked(ActionEvent event){
		List<Memory> memoryTable = null;
		
		if(inputToggleGroup.getSelectedToggle() == rb1){
			memoryTable = FilesSystem.calculateDataBlocks(patternLabel1.getText());
			tableDrawer.drawTabel(memoryTable);
		} else if(inputToggleGroup.getSelectedToggle() == rb2){
			memoryTable = FilesSystem.calculateDataBlocks(patternLabel2.getText());
			tableDrawer.drawTabel(memoryTable);
		} else if(inputToggleGroup.getSelectedToggle() == rb3){
			memoryTable = FilesSystem.calculateDataBlocks(patternLabel3.getText());
			tableDrawer.drawTabel(memoryTable);
		} else if(inputToggleGroup.getSelectedToggle() == rb4){
			if(userPatternField.getText().isEmpty()){
				showError("Sisesta muster!");
				return;
			}
			
			memoryTable = FilesSystem.calculateDataBlocks(userPatternField.getText().trim());
			
			tableDrawer.drawTabel(memoryTable);
			
		}
		String fragmentedInfo = "Fail ületas mälumahtu!";
		if(memoryTable.get(memoryTable.size()-1) != null){
			fragmentedInfo = "Allesjäänud failidest on fragmenteerunud " + FilesSystem.getFragmentedAmountPrecentage(memoryTable) + "%." +
				System.lineSeparator() + "Fragmenteerunud failidele kuulub " + FilesSystem.fragmentedFilesPecentageOfUsedSpace(memoryTable) + "% kasutatud ruumist.";
		}
		solutionTextArea.setText(fragmentedInfo);
	}
	
	@FXML
	private void clearButtonClicked(ActionEvent event){
		userPatternField.clear();
		tableDrawer.clearCanvas();
	}
	
	private void showError(String msg){
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(msg);
		alert.show();
	}

	
}
