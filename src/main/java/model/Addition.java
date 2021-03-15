package model;

import java.util.ArrayList;

public class Addition implements Operation{

    @Override
    public void performOperation(ArrayList<Monomial> monomialsListFirstPolynomial, ArrayList<Monomial> monomialsListSecondPolynomial, ArrayList<Monomial> monomialsListResult) {
        for(int i = 0; i < monomialsListFirstPolynomial.size(); i++){
            boolean found = false;
            for(int j = 0; j < monomialsListSecondPolynomial.size(); j++){
                if(monomialsListFirstPolynomial.get(i).getPower() == monomialsListSecondPolynomial.get(j).getPower()){
                    int monomialCoefficientResult = monomialsListFirstPolynomial.get(i).getCoefficient() + monomialsListSecondPolynomial.get(j).getCoefficient();
                    Monomial monomial = new Monomial(monomialCoefficientResult, monomialsListFirstPolynomial.get(i).getPower());
                    monomialsListResult.add(monomial);
                    found = true;
                }
            }
            if(!found){
                monomialsListResult.add(monomialsListFirstPolynomial.get(i));
            }
        }
        for(Monomial monomial : monomialsListSecondPolynomial){
            boolean found = false;
            for(Monomial monomialResult : monomialsListResult){
                if(monomial.getPower() == monomialResult.getPower()){
                    found = true;
                }
            }
            if(!found){
                monomialsListResult.add(monomial);
            }
        }
    }
}
