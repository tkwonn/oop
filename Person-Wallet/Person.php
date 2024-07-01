<?php

require_once 'Wallet.php';

class Person {
    private string $firstName;
    private string $lastName;
    private int $age;
    private float $heightM;
    private float $weightKg;
    private string $denomination = "highestFirst";
    private Wallet $wallet;

    public function __construct(string $firstName, string $lastName, int $age, float $heightM, float $weightKg)
    {
        $this->firstName = $firstName;
        $this->lastName = $lastName;
        $this->age = $age;
        $this->heightM = $heightM;
        $this->weightKg = $weightKg;
        $this->wallet = new Wallet();
    }

    public function getWallet(): Wallet
    {
        return $this->wallet;
    }

    public function setWallet(Wallet $wallet): void
    {
        $this->wallet = $wallet;
    }

    public function getFullName(): string
    {
        return $this->firstName . " " . $this->lastName;
    }

    public function getCash(): int
    {
        if($this->wallet == null) return 0;
        return $this->wallet->getTotalMoney();
    }

    public function spendMoney(int $money): int
    {
        $action = "spend";
        if($this->wallet == null) return [];
        if($this->denomination == "highestFirst") return $this->actionByHighestFirst($money, $action);
        elseif($this->denomination == "twenties") return $this->actionByTwenties($money, $action);
        else return $this->actionByDollars($money, $action);
    }

    public function addMoney(int $money): int
    {
        $action = "add";
        if($this->wallet == null) return [];
        if($this->denomination == "highestFirst") return $this->actionByHighestFirst($money, $action);
        elseif($this->denomination == "twenties") return $this->actionByTwenties($money, $action);
        else return $this->actionByDollars($money, $action);
    }

    public function addWallet(Wallet $wallet): void
    {
        $this->setWallet($wallet);
    }

    public function dropWallet(): Wallet
    {
        $temp = $this->wallet;
        $this->wallet = null;
        return $temp;
    }

    public function actionByHighestFirst(int $money, string $action): int
    {
        if($money == 0) return 0;

        if($money >= 100 && $this->wallet->getBill100() > 0)
        {
            if($action == "spend") 
            {
                $this->wallet->setBill100($this->wallet->getBill100() - 1);
                echo $this->wallet->removeBill(100, 1) . " removed" . PHP_EOL;
                return $this->actionByHighestFirst($money - 100, $action);
            }
            else
            {
                $this->wallet->setBill100($this->wallet->getBill100() + 1);
                echo $this->wallet->insertBill(100, 1) . " inserted" . PHP_EOL;
                return $this->actionByHighestFirst($money - 100, $action);
            }
        }
        elseif($money >= 50 && $this->wallet->getBill50() > 0)
        {
            if($action == "spend") 
            {
                $this->wallet->setBill50($this->wallet->getBill50() - 1);
                echo $this->wallet->removeBill(50, 1) . " removed" . PHP_EOL;
                return $this->actionByHighestFirst($money - 50, $action);
            }
            else
            {
                $this->wallet->setBill50($this->wallet->getBill50() + 1);
                echo $this->wallet->insertBill(50, 1) . " inserted" . PHP_EOL;
                return $this->actionByHighestFirst($money - 50, $action);
            }
        }
        elseif($money >= 20 && $this->wallet->getBill20() > 0)
        {
            if($action == "spend") 
            {
                $this->wallet->setBill20($this->wallet->getBill20() - 1);
                echo $this->wallet->removeBill(20, 1) . " removed" . PHP_EOL;
                return $this->actionByHighestFirst($money - 20, $action);
            }
            else
            {
                $this->wallet->setBill20($this->wallet->getBill20() + 1);
                echo $this->wallet->insertBill(20, 1) . " inserted" . PHP_EOL;
                return $this->actionByHighestFirst($money - 20, $action);
            }
        }
        elseif($money >= 10 && $this->wallet->getBill10() > 0)
        {
            if($action == "spend") 
            {
                $this->wallet->setBill10($this->wallet->getBill10() - 1);
                echo $this->wallet->removeBill(10, 1) . " removed" . PHP_EOL;
                return $this->actionByHighestFirst($money - 10, $action);
            }
            else
            {
                $this->wallet->setBill10($this->wallet->getBill10() + 1);
                echo $this->wallet->insertBill(10, 1) . " inserted" . PHP_EOL;
                return $this->actionByHighestFirst($money - 10, $action);
            }
        }
        elseif($money >= 5 && $this->wallet->getBill5() > 0)
        {
            if($action == "spend") 
            {
                $this->wallet->setBill5($this->wallet->getBill5() - 1);
                echo $this->wallet->removeBill(5, 1) . " removed" . PHP_EOL;
                return $this->actionByHighestFirst($money - 5, $action);
            }
            else
            {
                $this->wallet->setBill5($this->wallet->getBill5() + 1);
                echo $this->wallet->insertBill(5, 1) . " inserted" . PHP_EOL;
                return $this->actionByHighestFirst($money - 5, $action);
            }
        }
        else 
        {
            if($action == "spend") 
            {
                $this->wallet->setBill1($this->wallet->getBill1() - 1);
                echo $this->wallet->removeBill(1, 1) . " removed" . PHP_EOL;
                return $this->actionByHighestFirst($money - 1, $action);
            }
            else
            {
                $this->wallet->setBill1($this->wallet->getBill1() + 1);
                echo $this->wallet->insertBill(1, 1) . " inserted" . PHP_EOL;
                return $this->actionByHighestFirst($money - 1, $action);
            }
        }
    }

    public function actionByTwenties(int $money, string $action): int
    {
        if($money == 0) return 0;

        if($money >= 20 && $this->wallet->getBill20() > 0)
        {
            if($action == "spend") 
            {
                $this->wallet->setBill20($this->wallet->getBill20() - 1);
                echo $this->wallet->removeBill(20, 1) . " removed" . PHP_EOL;
                return $this->actionByTwenties($money - 20, $action);
            }
            else
            {
                $this->wallet->setBill20($this->wallet->getBill20() + 1);
                echo $this->wallet->insertBill(20, 1) . " inserted" . PHP_EOL;
                return $this->actionByTwenties($money - 20, $action);
            }
        }
        else
        {
            if($action == "spend") return $this->actionByHighestFirst($money, "spend");
            else return $this->actionByHighestFirst($money, "add");
        }
    }

    public function actionByDollars(int $money, string $action): int
    {
        while($money > 0 && $this->wallet->getBill1() > 0)
        {
            if($action == "spend")
            {
                $this->wallet->setBill1($this->wallet->getBill1() - 1);
                echo $this->wallet->removeBill(1, 1) . " removed" . PHP_EOL;
                $money--;
            }
            else 
            {
                $this->wallet->setBill1($this->wallet->getBill1() + 1);
                echo $this->wallet->insertBill(1, 1) . " inserted" . PHP_EOL;
                $money--;
            }
        }
        return 0;
    }

    public function printState(): void
    {
        echo "Name: " . $this->getFullName() . PHP_EOL;
        echo "Age: " . $this->age . PHP_EOL;
        echo "Height: " . $this->heightM . "m" . PHP_EOL;
        echo "Weight: " . $this->weightKg . "kg" . PHP_EOL;
        echo "Current money: " . $this->getCash() . PHP_EOL;
    }
}