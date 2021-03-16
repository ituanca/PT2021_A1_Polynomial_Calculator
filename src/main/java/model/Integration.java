package model;

import java.util.ArrayList;

public class Integration implements UnaryOperation{

    @Override
    public void performOperation(ArrayList<Monomial> monomialsList, ArrayList<Monomial> monomialsListResult) {
        for(Monomial monomial : monomialsList){
            double monomialCoefficientResult = monomial.getCoefficient() / (monomial.getPower() + 1);
            int monomialPowerResult = monomial.getPower() + 1;
            Monomial monomialResult = new Monomial(monomialCoefficientResult, monomialPowerResult);
            monomialsListResult.add(monomialResult);
        }
    }
}
