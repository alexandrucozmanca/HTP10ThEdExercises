package Exercise25_04_EnhancedTipCalculator;
	
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;



public class TipCalculator extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Parent root = 
		    	         FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("Exercise25_04_EnhancedTipCalculator.css").toExternalForm());
			primaryStage.setTitle("Tip Calculator");
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	// formatters for currency and percentages
		private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
		private static final NumberFormat percent = NumberFormat.getPercentInstance();
		
		private BigDecimal tipPercentage = new BigDecimal(0.15); // 15% default
		
		// GUI controls defined in FXML and used by the controller`s code 
		@FXML
		private TextField amountTextField;
		
		@FXML
		private TextField personsTextField;
		
		@FXML
		private Label tipPercentageLabel;
		
		@FXML
		private Slider tipPercentageSlider;
		
		@FXML
		private TextField tipTextField;
		
		@FXML
		private TextField totalTextField;
		
		@FXML
		private TextField totalPerPersonTextField;
		
		@FXML
		private void calculateButtonPressed(ActionEvent event)
		{
			try
			{
				BigDecimal amount = new BigDecimal(amountTextField.getText());
				BigDecimal tip = amount.multiply(tipPercentage);
				BigDecimal total = amount.add(tip);
				
				tipTextField.setText(currency.format(tip));
				totalTextField.setText(currency.format(total));
				
				try
				{
					BigDecimal persons = new BigDecimal(personsTextField.getText());
					BigDecimal totalPerPerson = total.divide(persons, RoundingMode.HALF_UP);
					
					totalPerPersonTextField.setText(currency.format(totalPerPerson));
				}
				catch (NumberFormatException ex1)
				{
					personsTextField.setText("1");
					personsTextField.selectAll();
					personsTextField.requestFocus();
					ex1.printStackTrace();
				}
			}
			catch(NumberFormatException ex)
			{
				amountTextField.setText("Enter amount");
				amountTextField.selectAll();
				amountTextField.requestFocus();
				
				ex.printStackTrace();
			}
		}
		
		// called by FXMLLoader to initialize the controller
		public void initialize()
		{
			//0-4 rounds down, 5-9 rounds up
			currency.setRoundingMode(RoundingMode.HALF_UP);
			
			
			//listener for changes to tipPercentageSlider`s value
			tipPercentageSlider.valueProperty().addListener(
				new ChangeListener<Number>()
				{
					@Override
					public void changed(ObservableValue<? extends Number> ov, 
							Number oldValue, Number newValue)
					{
						tipPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
						tipPercentageLabel.setText(percent.format(tipPercentage));
					}
				}
			);
			
		}

}
