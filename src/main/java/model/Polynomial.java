package model;
import controller.CalculatorController;

import java.util.*;

public class Polynomial {
    ArrayList<Monomial> Monomials = new ArrayList<>();

    public Polynomial(ArrayList<Monomial> monomials) {
        Monomials = monomials;
    }

    public ArrayList<Monomial> getMonomials() {
        return Monomials;
    }

    public void setMonomials(ArrayList<Monomial> monomials) {
        Monomials = monomials;
    }

    public void createMonomialsList(String stringPolynomial, ArrayList<String> stringMonomials, ArrayList<Monomial> monomialsList){
        CalculatorController.separateInputIntoMonomialsString(stringPolynomial, stringMonomials);
        for (String stringMonomial: stringMonomials) {
          Monomial monomial = CalculatorController.createMonomialFromString(stringMonomial);
          monomialsList.add(monomial);
        }
    }
}
