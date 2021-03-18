package model;
import controller.CalculatorController;

public class Monomial {

    private double coefficient;
    private int power;

    public Monomial(double coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public Monomial() {
        this.coefficient = 0;
        this.power = 0;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String createStringFromMonomial(){
        String stringMonomial;
        if(this.coefficient % 1 == 0){
            if(this.coefficient == 1 && this.power == 1){ stringMonomial = "+x"; }
            else if(this.coefficient == -1 && this.power == 1){ stringMonomial = "-x"; }
            else if(this.coefficient == 1 && this.power > 1){ stringMonomial = "+x^" + this.power; }
            else if(this.coefficient == -1 && this.power > 1){ stringMonomial = "-x^" + this.power; }
            else if(this.coefficient > 0 && this.power == 0){ stringMonomial = "+" + (int)this.coefficient; }
            else if(this.coefficient < 0 && this.power == 0){ stringMonomial = Integer.toString((int)this.coefficient); }
            else if(this.coefficient > 0 && this.power == 1){ stringMonomial = "+" + (int)this.coefficient + "x"; }
            else if(this.coefficient > 0){ stringMonomial =  "+" + (int)this.coefficient + "x^" + this.power; }
            else if(this.coefficient == 0 && this.power == 0){ stringMonomial = "0"; }
            else{ stringMonomial = (int)this.coefficient + "x^" + this.power; }
        }else{
            if(this.coefficient == 1 && this.power == 1){ stringMonomial = "+x"; }
            else if(this.coefficient == -1 && this.power == 1){ stringMonomial = "-x"; }
            else if(this.coefficient == 1 && this.power > 1){ stringMonomial = "+x^" + this.power; }
            else if(this.coefficient == -1 && this.power > 1){ stringMonomial = "-x^" + this.power; }
            else if(this.coefficient > 0 && this.power == 0){ stringMonomial = "+" + this.coefficient; }
            else if(this.coefficient < 0 && this.power == 0){ stringMonomial = Double.toString(this.coefficient); }
            else if(this.coefficient > 0 && this.power == 1){ stringMonomial = "+" + this.coefficient + "x"; }
            else if(this.coefficient > 0){ stringMonomial =  "+" + this.coefficient + "x^" + this.power; }
            else if(this.coefficient == 0 && this.power == 0){ stringMonomial = "0"; }
            else{ stringMonomial = this.coefficient + "x^" + this.power; }
        }
        return stringMonomial;
    }
}
