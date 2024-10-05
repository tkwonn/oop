<?php

class Calculator {
    private int $firstOperand;
    private int $secondOperand;

    public function __construct(int $firstOperand, int $secondOperand) {
        $this->firstOperand = $firstOperand;
        $this->secondOperand = $secondOperand;
    }

    public function getFirstOperand(): int {
        return $this->firstOperand;
    }

    public function getSecondOperand(): int {
        return $this->secondOperand;
    }

    public function setFirstOperand(int $firstOperand): void {
        $this->firstOperand = $firstOperand;
    }

    public function setSecondOperand(int $secondOperand): void {
        $this->secondOperand = $secondOperand;
    }

    public function add(): int {
        return $this->firstOperand + $this->secondOperand;
    }

    public function subtract(): int {
        return $this->firstOperand - $this->secondOperand;
    }

    public function multiply(): int {
        return $this->firstOperand * $this->secondOperand;
    }

    public function divide(): float {
        return $this->firstOperand / $this->secondOperand;
    }
}

$calculator = new Calculator(3, 2);
echo $calculator->add() . PHP_EOL;
echo $calculator->subtract() . PHP_EOL;

$calculator->setFirstOperand(6);
$calculator->setSecondOperand(3);
echo $calculator->multiply() . PHP_EOL;
echo $calculator->divide() . PHP_EOL;