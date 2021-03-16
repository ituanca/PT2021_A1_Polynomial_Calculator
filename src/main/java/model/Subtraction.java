package model;

import java.util.ArrayList;

public class Subtraction implements BinaryOperation {

    @Override
    public void performOperation(ArrayList<Monomial> monomialsListFirstPolynomial, ArrayList<Monomial> monomialsListSecondPolynomial, ArrayList<Monomial>  monomialsListResult) {
        ArrayList<Integer> powersToBeIgnored = new ArrayList<>();
        for(int i = 0; i < monomialsListFirstPolynomial.size(); i++){
            boolean found = false;
            for(int j = 0; j < monomialsListSecondPolynomial.size(); j++){
                if(monomialsListFirstPolynomial.get(i).getPower() == monomialsListSecondPolynomial.get(j).getPower()){
                    int monomialCoefficientResult = (int) (monomialsListFirstPolynomial.get(i).getCoefficient() - monomialsListSecondPolynomial.get(j).getCoefficient());
                    if (monomialCoefficientResult == 0) {
                        powersToBeIgnored.add(monomialsListFirstPolynomial.get(i).getPower());
                    }else{
                        Monomial monomial = new Monomial(monomialCoefficientResult, monomialsListFirstPolynomial.get(i).getPower());
                        monomialsListResult.add(monomial);
                    }
                    found = true;
                }
            }
            if(!found){
                monomialsListResult.add(monomialsListFirstPolynomial.get(i));
            }
        }
        for(Monomial monomial : monomialsListSecondPolynomial){
            boolean found = false;
            if(!powersToBeIgnored.contains(monomial.getPower())) {
                for (Monomial monomialResult : monomialsListResult) {
                    if (monomial.getPower() == monomialResult.getPower()) {
                        found = true;
                    }
                }
                if (!found) {
                    monomialsListResult.add(monomial);
                    monomialsListResult.get(monomialsListResult.size() - 1).setCoefficient((int) ((-1) * monomial.getCoefficient()));
                }
            }
        }
    }

}
