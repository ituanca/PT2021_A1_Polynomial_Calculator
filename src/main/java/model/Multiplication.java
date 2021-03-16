package model;

import java.util.ArrayList;

public class Multiplication implements BinaryOperation {

    public void performOperation(ArrayList<Monomial> monomialsListFirstPolynomial, ArrayList<Monomial> monomialsListSecondPolynomial,
                                 ArrayList<Monomial>  monomialsListResult) {
        for (Monomial monomial1 : monomialsListFirstPolynomial) {
            for (Monomial monomial2 : monomialsListSecondPolynomial) {
                int resultCoefficient = (int) (monomial1.getCoefficient() * monomial2.getCoefficient());
                int resultPower = monomial1.getPower() + monomial2.getPower();
                Monomial monomial = new Monomial(resultCoefficient, resultPower);
                monomialsListResult.add(monomial);
            }
        }
    }
}
