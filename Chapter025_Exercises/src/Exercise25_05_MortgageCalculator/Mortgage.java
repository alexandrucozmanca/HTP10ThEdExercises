package Exercise25_05_MortgageCalculator;
	
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



public class Mortgage extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Parent root = 
		    	         FXMLLoader.load(getClass().getResource("Mortgage.fxml"));
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("app.css").toExternalForm());
			primaryStage.setTitle("Mortgage Calculator");
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
		private static int duration = 1;
						
		@FXML
		TextField purchasePriceTextField;
		
		@FXML
		TextField downPaymentTextField;
		
		@FXML
		TextField loanAmountField;
		
		@FXML
		TextField interestRateTextField;
		
		@FXML
		TextField tenYearsTextField;
		
		@FXML
		TextField twentyYearsTextField;
		
		@FXML
		TextField thirtyYearsTextField;
		
		@FXML
		Slider durationSlider; 
		
		@FXML
		Label customLabel;
		
		@FXML
		TextField customTextField;
		
		@FXML
		private void computeButtonPressed(ActionEvent event)
		{
			try // parse input for purchase price
			{
				BigDecimal purchasePrice = new BigDecimal(purchasePriceTextField.getText()); 
							
				try // parse input for down-payment
				{
					BigDecimal downPayment = new BigDecimal(downPaymentTextField.getText());
					
					loanAmountField.setText(purchasePrice.subtract(downPayment).toString());
					
					try // parse input for interest and compute scenarios
					{ 
						BigDecimal interest = new BigDecimal(interestRateTextField.getText());
						
						//verify that interest rate is positive
						if(interest.compareTo(BigDecimal.ZERO) < 0)
						{
							interestRateTextField.setText("Must be positive");
							interestRateTextField.selectAll();
							interestRateTextField.requestFocus();
						}
						// verify that credit amount is positive
						else if (purchasePrice.subtract(downPayment).compareTo(BigDecimal.ZERO) > 0)
						{
							
							tenYearsTextField.setText(
									new ComputeMonthlyPayment(purchasePrice.subtract(downPayment), interest, 10).toString());
							twentyYearsTextField.setText(
									new ComputeMonthlyPayment(purchasePrice.subtract(downPayment), interest, 20).toString());
							thirtyYearsTextField.setText(
									new ComputeMonthlyPayment(purchasePrice.subtract(downPayment), interest, 30).toString());
							
							// only compute custom duration if slider is used
							if (duration != 1)
								customTextField.setText(
										new ComputeMonthlyPayment(purchasePrice.subtract(downPayment), interest, duration).toString());
						}
						else 
						{
							downPaymentTextField.setText("Value too big.");
							downPaymentTextField.selectAll();
							downPaymentTextField.requestFocus();
						}
					}
					catch (NumberFormatException interestInputException)
					{
						interestRateTextField.setText("Input interest");
						interestRateTextField.selectAll();
						interestRateTextField.requestFocus();
					}
				}
				catch (NumberFormatException downPaymentInputException)
				{
					downPaymentTextField.setText("Input down-payment");
					downPaymentTextField.selectAll();
					downPaymentTextField.requestFocus();
				}
			}
			catch(NumberFormatException purchasePriceInputException)
			{
				purchasePriceTextField.setText("Input purchase price");
				purchasePriceTextField.selectAll();
				purchasePriceTextField.requestFocus();
			}
			
			 
			
		}
		
		// called by FXMLLoader to initialize the controller
		public void initialize()
		{
			
			//listener for changes to tipPercentageSlider`s value
			durationSlider.valueProperty().addListener(
				new ChangeListener<Number>()
				{
					@Override
					public void changed(ObservableValue<? extends Number> ov, 
							Number oldValue, Number newValue)
					{
						duration = newValue.intValue();
						customLabel.setText(String.format("%d years", duration));
					}
				}
			);
			
		}

}
