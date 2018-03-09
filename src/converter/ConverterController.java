package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * UI controller for events and initializing components.
 * 
 * @author Patiphan Srisook
 *
 */
public class ConverterController {
	@FXML
	TextField textfield1;
	@FXML
	TextField textfield2;
	@FXML
	private ComboBox<Length> combobox1;
	@FXML
	private ComboBox<Length> combobox2;
	
	/**
	 * JavaFX calls the initialize() method of your controller when
	 * it creates the UI from, after the components have been created
	 * and @FXML annotated attributes have been set.
	 */
	@FXML
	public void initialize() {
		// This is for testing
		System.out.println("Running initialize");
		if(combobox1 != null) {
			combobox1.getItems().addAll(Length.values());
			combobox1.getSelectionModel().select(0); // select an item to show
		}
		if(combobox2 != null) {
			combobox2.getItems().addAll(Length.values());
			combobox2.getSelectionModel().select(1); // select an item to show
		}
	}
	
	/**
	 * Convert a distance from one unit to another.
	 */
	public void handleConvert() {
		// read values from textfield(s)
		String text1 = textfield1.getText().trim();
		String text2 = textfield2.getText().trim();
		double result = 0.0;
		// This is for testing
		Length box1 = combobox1.getValue();
		Length box2 = combobox2.getValue();
		// perform the conversion and output the result	
		if(!text1.equals("")) {
			double n1 = Double.parseDouble(text1);
			System.out.printf("handleConvert converting from %s to %s.\n",box1,box2);
			result = (n1 * box1.getValue()) / box2.getValue();
			textfield2.setText(""+result);
		}
		else if(!text2.equals("")) {
			double n2 = Double.parseDouble(text2);
			System.out.printf("handleConvert converting from %s to %s.\n",box2,box1);
			result = (n2 * combobox2.getValue().getValue()) / combobox1.getValue().getValue();
			textfield1.setText(""+result);
		}
			
	}
	
	public void convertOnEnter(KeyEvent event) {
		if(event.getCode().equals(KeyCode.ENTER)) {
			handleConvert();
		}
	}
	
	/**
	 * Clear the box
	 */
	public void handleClear(ActionEvent event) {
		textfield1.setText("");
		textfield2.setText("");
		System.out.println("Clear!!");
	}
}
