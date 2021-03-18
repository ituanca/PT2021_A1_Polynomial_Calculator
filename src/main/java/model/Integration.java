package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Integration implements UnaryOperation{

    @Override
    public void performOperation(ArrayList<Monomial> monomialsList, ArrayList<Monomial> monomialsListResult) {
        for(Monomial monomial : monomialsList){
            double monomialCoefficientTempResult = monomial.getCoefficient() / (monomial.getPower() + 1);
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            double monomialCoefficientResult = Double.parseDouble(numberFormat.format(monomialCoefficientTempResult));
            int monomialPowerResult = monomial.getPower() + 1;
            Monomial monomialResult = new Monomial(monomialCoefficientResult, monomialPowerResult);
            monomialsListResult.add(monomialResult);
        }
    }
}
