package model;

import java.util.ArrayList;

public class Derivation implements UnaryOperation {

    @Override
    public void performOperation(ArrayList<Monomial> monomialsList, ArrayList<Monomial> monomialsListResult) {
        for(Monomial monomial : monomialsList){
            if(monomial.getPower() != 0){
                int monomialCoefficientResult = (int) (monomial.getCoefficient() * monomial.getPower());
                int monomialPowerResult = monomial.getPower() - 1;
                Monomial monomialResult = new Monomial(monomialCoefficientResult, monomialPowerResult);
                monomialsListResult.add(monomialResult);
            }else{
                if(monomialsList.size() == 1){
                    Monomial zeroMonomial = new Monomial();
                    monomialsListResult.add(zeroMonomial);
                }
            }
        }
    }
}
