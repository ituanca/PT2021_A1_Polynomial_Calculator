package model;

import java.util.ArrayList;

public interface Operation {
     void performOperation(ArrayList<Monomial> monomialsListFirstPolynomial, ArrayList<Monomial> monomialsListSecondPolynomial, ArrayList<Monomial> monomialListResult);
}
