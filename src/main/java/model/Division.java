package model;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public class Division implements BinaryOperation{

    @Override
    public void performOperation(ArrayList<Monomial> monomialsListDividend, ArrayList<Monomial> monomialsListDivisor, ArrayList<Monomial> monomialsListResult) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if( monomialsListDivisor.get(0).getPower() == 0 && monomialsListDivisor.get(0).getCoefficient() == 0 ){
            alert.setContentText("Division by zero polynomial");
            alert.show();
            throw new RuntimeException("Division by zero polynomial!");
        }
        if(monomialsListDividend.get(0).getPower() < monomialsListDivisor.get(0).getPower()){
            alert.setContentText("Divident has smaller degree than the divisor!");
            alert.show();
           throw new RuntimeException("Division by zero polynomial");
        }
        double coefficient = monomialsListDividend.get(0).getCoefficient() / monomialsListDivisor.get(0).getCoefficient();
        int power = monomialsListDividend.get(0).getPower() - monomialsListDivisor.get(0).getPower();
       /* ArrayList<Monomial> monomialsListResult = new ArrayList<>();
        int i = 1;
        Monomial divident = monomialsListDividend.get(i);
        while(){
            Monomial monomial = new Monomial();
            dividePolynomials(monomial, divident, monomialsListDivisor.get(1), monomialsListResult, monomialsListDivisor, monomialsListDividend);
            i++;

            Multiplication multiplication = new Multiplication();
            ArrayList<Monomial> resultMultiplication = new ArrayList<>();
            multiplication.performOperation(monomialsListDivisor, monomialsListResult, resultMultiplication);

            Subtraction subtraction = new Subtraction();
            ArrayList<Monomial> resultSubtraction = new ArrayList<>();
            subtraction.performOperation(monomialDivident, resultMultiplication, resultSubtraction);
        }
        */
    }

    public void dividePolynomials(Monomial monomial, Monomial monomialDivident, Monomial monomialDivisor, ArrayList<Monomial> monomialsListResult){
        monomial = new Monomial(monomialDivident.getCoefficient() / monomialDivisor.getCoefficient(),
                monomialDivident.getPower() - monomialDivisor.getPower());
        monomialsListResult.add(monomial);

    }
}
