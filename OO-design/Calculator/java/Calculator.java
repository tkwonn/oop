class Calculator {
    private int firstOperand;
    private int secondOperand;

    public Calculator(int firstOperand, int secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    public int getFirstOperand() {
        return firstOperand;
    }

    public int getSecondOperand() {
        return secondOperand;
    }

    public void setFirstOperand(int firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setSecondOperand(int secondOperand) {
        this.secondOperand = secondOperand;
    }

    public int getAdditionResult() {
        return this.firstOperand + this.secondOperand;
    }

    public int getSubtractionResult() {
        return this.firstOperand - this.secondOperand;
    }

    public int getMultiplicationResult() {
        return this.firstOperand * this.secondOperand;
    }

    public int getDivisionResult() {
        return this.firstOperand / this.secondOperand;
    }
}

class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(3, 2);
        System.out.println(calculator.getAdditionResult());
        System.out.println(calculator.getSubtractionResult());

        calculator.setFirstOperand(6);
        calculator.setSecondOperand(3);
        System.out.println(calculator.getMultiplicationResult());
        System.out.println(calculator.getDivisionResult());
    }
}