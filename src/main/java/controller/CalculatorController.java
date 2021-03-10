package controller;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import view.CalculatorInterface;

public class CalculatorController {

    public TextField tfFirstPolynomial;
    public TextField tfSecondPolynomial;
    public TextField tfResult;
    public Button btnAddition;
    public Button btnSubtraction;
    public Button btnMultiplication;
    public Button btnDivision;
    public Button btnDerivative;
    public Button btnIntegrate;

    public void start() throws Exception {
       new Thread(() -> Application.launch(CalculatorInterface.class)).start();
    }

    public String getFirstPolynomial(){
        return tfFirstPolynomial.getText();
    }

    public String getSecondPolynomial(){
        return tfSecondPolynomial.getText();
    }

    private void validateInput(){
        Alert alert = new Alert(Alert.AlertType.NONE);
        if(getFirstPolynomial().isEmpty() && getSecondPolynomial().isEmpty()){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please enter 2 polynomials!");
            alert.show();
        }
    }

    public void createPolynomial(){
        //inputValidation.verifyPolynomial();
    }

}
