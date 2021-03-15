package model;
import controller.CalculatorController;

public class Monomial {

    private int coefficient;
    private int power;

    public Monomial(int coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public Monomial() {
        this.coefficient = 0;
        this.power = 0;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
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
        if(this.coefficient == 1 && this.power == 1){
            stringMonomial = "+x";
        }else if(this.coefficient == -1 && this.power == 1){
            stringMonomial = "-x";
        }else if(this.coefficient == 1 && this.power > 1){
            stringMonomial = "+x^" + this.power;
        }else if(this.coefficient == -1 && this.power > 1){
            stringMonomial = "-x^" + this.power;
        }else if(this.coefficient > 0 && this.power == 0){
            stringMonomial = "+" + this.coefficient;
        }else if(this.coefficient < 0 && this.power == 0){
            stringMonomial = Integer.toString(this.coefficient);
        }else if(this.coefficient > 0 && this.power == 1){
            stringMonomial = "+" + this.coefficient + "x";
        }else if(this.coefficient > 0){
            stringMonomial =  "+" + this.coefficient + "x^" + this.power;
        }else{
            stringMonomial = this.coefficient + "x^" + this.power;
        }
        return stringMonomial;
    }
}
