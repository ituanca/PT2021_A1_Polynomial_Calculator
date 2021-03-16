package model;

import java.util.ArrayList;

public interface BinaryOperation {
     void performOperation(ArrayList<Monomial> monomialsListFirstPolynomial, ArrayList<Monomial> monomialsListSecondPolynomial, ArrayList<Monomial> monomialsListResult);
}
