package controller;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.*;
import view.CalculatorInterface;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorController {

    public TextField tfFirstPolynomial;
    public TextField tfSecondPolynomial;
    public TextField tfResult;
    public Button btnAddition;
    public Button btnSubtraction;
    public Button btnMultiplication;
    public Button btnDivision;
    public Button btnDerivation;
    public Button btnIntegration;
    public Label labelResult;

    private static ArrayList<String> stringMonomials1 = new ArrayList<String>();
    private static ArrayList<Monomial> monomialsList1 = new ArrayList<Monomial>();
    private static Polynomial firstPolynomial = new Polynomial(monomialsList1);
    private static ArrayList<String> stringMonomials2 = new ArrayList<String>();
    private static ArrayList<Monomial> monomialsList2 = new ArrayList<Monomial>();
    private static Polynomial secondPolynomial = new Polynomial(monomialsList2);

    public void start() throws Exception {
       new Thread(() -> Application.launch(CalculatorInterface.class)).start();
    }

    @FXML
    private void executeAddition(ActionEvent actionEvent) {
        actionEvent.consume();
        managePolynomials();
        ArrayList<Monomial> result = new ArrayList<Monomial>();
        String stringResult = "";
        Addition addition = new Addition();
        addition.performOperation(monomialsList1, monomialsList2, result);
        sortMonomialsList(result);
        stringResult = convertResultIntoString(result);
        System.out.println(stringResult);
    }

    public void executeSubtraction(ActionEvent actionEvent) {
        actionEvent.consume();
        managePolynomials();
        ArrayList<Monomial> result = new ArrayList<Monomial>();
        String stringResult = "";
        Subtraction subtraction = new Subtraction();
        subtraction.performOperation(monomialsList1, monomialsList2, result);
        sortMonomialsList(result);
        stringResult = convertResultIntoString(result);
        System.out.println(stringResult);
    }

    public void executeMultiplication(ActionEvent actionEvent) {
        actionEvent.consume();
        managePolynomials();
        ArrayList<Monomial> result = new ArrayList<Monomial>();
        String stringResult = "";
        Multiplication multiplication = new Multiplication();
        multiplication.performOperation(monomialsList1, monomialsList2, result);
        sortMonomialsList(result);
        managePolynomial(result);
        stringResult = convertResultIntoString(result);
        System.out.println(stringResult);
    }

    public void executeDivision(ActionEvent actionEvent) {
        actionEvent.consume();
        managePolynomials();
    }

    public void executeDerivation(ActionEvent actionEvent) {
        actionEvent.consume();
        managePolynomials();
    }

    public void executeIntegration(ActionEvent actionEvent) {
        actionEvent.consume();
        managePolynomials();
    }

    public String getFirstPolynomial(){
        return tfFirstPolynomial.getText();
    }

    public String getSecondPolynomial(){
        return tfSecondPolynomial.getText();
    }

    private void validateInputBinaryOperation(){
        String firstPolynomial = getFirstPolynomial();
        String secondPolynomial = getSecondPolynomial();
        Alert alert = new Alert(Alert.AlertType.NONE);
        if(firstPolynomial.isEmpty() || secondPolynomial.isEmpty()){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please enter 2 polynomials!");
            alert.show();
        }
    }

    private void validateInputUnaryOperation(){
        Alert alert = new Alert(Alert.AlertType.NONE);
        if(getFirstPolynomial().isEmpty()){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Please enter a polynomial in the Polynomial 1 field!");
            alert.show();
        }
    }

    public static void separateInputIntoMonomialsString(String stringPolynomial, ArrayList<String> stringMonomials){
//        String delimiters = "[+ ]+";
//        stringPolynomial = stringPolynomial.replace("-", "+-");
//        String[] tokens = stringPolynomial.split(delimiters);
//
//        stringMonomials.addAll(Arrays.asList(tokens));

        Pattern patternPolynomial = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcherPolynomial = patternPolynomial.matcher(stringPolynomial);
        while (matcherPolynomial.find()) {
            stringMonomials.add(matcherPolynomial.group());
        }
    }

    public static Monomial createMonomialFromString(String stringMonomial){
        Monomial monomial = new Monomial();
        String stringCoefficient, stringPower;

        if(stringMonomial.length() > 0 && stringMonomial.charAt(0) == '+'){
            stringMonomial = stringMonomial.substring(1);
        }
        int xPosition = stringMonomial.indexOf("x");
        int powPosition = stringMonomial.indexOf("^");

        if(xPosition == 0){
            stringCoefficient = "1";
        }else if(xPosition == 1 && stringMonomial.length() > 0  && stringMonomial.charAt(0) == '-'){
            stringCoefficient = "-1";
        }else if(xPosition == -1){
            stringCoefficient = stringMonomial;
        }else {
            stringCoefficient = stringMonomial.substring(0, xPosition);
        }
        if(powPosition == -1){
            if(xPosition == -1) {
                stringPower = "0";
            }else {
                stringPower = "1";
            }
        }else{
            stringPower = stringMonomial.substring(powPosition + 1);
        }
        monomial.setCoefficient(Integer.parseInt(stringCoefficient));
        monomial.setPower(Integer.parseInt(stringPower));
        System.out.println(monomial.getCoefficient() + " " + monomial.getPower());
        return monomial;
    }

    private static void managePolynomial(ArrayList<Monomial> monomialsList){
        for(int i = 0; i < monomialsList.size(); i++){
            for(int j = i + 1; j < monomialsList.size(); j++){
                if(monomialsList.get(i).getPower() == monomialsList.get(j).getPower()){
                    int newCoefficient = monomialsList.get(i).getCoefficient() + monomialsList.get(j).getCoefficient();
                    monomialsList.get(i).setCoefficient(newCoefficient);
                    monomialsList.remove(monomialsList.get(j));
                    j = j - 1;
                }
            }
        }
        for(Monomial monomial : monomialsList){
            System.out.println(monomial.createStringFromMonomial());
        }
    }

    public void managePolynomials(){
        validateInputBinaryOperation();

        String firstStringPolynomial = getFirstPolynomial();
        firstPolynomial.createMonomialsList(firstStringPolynomial, stringMonomials1, monomialsList1);
        managePolynomial(monomialsList1);

        String secondStringPolynomial = getSecondPolynomial();
        secondPolynomial.createMonomialsList(secondStringPolynomial, stringMonomials2, monomialsList2);
        managePolynomial(monomialsList2);
    }

    public void sortMonomialsList(ArrayList<Monomial> monomialsList){
        monomialsList.sort(Comparator.comparing(Monomial::getPower));
    }

    public String convertResultIntoString(ArrayList<Monomial> monomialsList){
        String result = "";
        for(Monomial monomial : Reversed.reversed(monomialsList)){
           result = result.concat(monomial.createStringFromMonomial());
        }
        return result;
    }
}
