package model;

import java.util.ArrayList;

public interface UnaryOperation {
    void performOperation(ArrayList<Monomial> monomialsList, ArrayList<Monomial> monomialsListResult);
}
