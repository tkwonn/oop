<?php

class Wallet {
    private int $bill1;
    private int $bill5;
    private int $bill10;
    private int $bill20;
    private int $bill50;
    private int $bill100;

    public function __construct() 
    {
        $this->bill1 = 0;
        $this->bill5 = 0;
        $this->bill10 = 0;
        $this->bill20 = 0;
        $this->bill50 = 0;
        $this->bill100 = 0;
    }

    public function getBill1(): int
    {
        return $this->bill1;
    }

    public function getBill5(): int
    {
        return $this->bill5;
    }

    public function getBill10(): int
    {
        return $this->bill10;
    }

    public function getBill20(): int
    {
        return $this->bill20;
    }

    public function getBill50(): int
    {
        return $this->bill50;
    }

    public function getBill100(): int
    {
        return $this->bill100;
    }

    public function setBill1(int $bill1): void
    {
        $this->bill1 = $bill1;
    }

    public function setBill5(int $bill5): void
    {
        $this->bill5 = $bill5;
    }

    public function setBill10(int $bill10): void
    {
        $this->bill10 = $bill10;
    }

    public function setBill20(int $bill20): void
    {
        $this->bill20 = $bill20;
    }

    public function setBill50(int $bill50): void
    {
        $this->bill50 = $bill50;
    }

    public function setBill100(int $bill100): void
    {
        $this->bill100 = $bill100;
    }

    public function getTotalMoney(): int 
    {
        return $this->bill1 + ($this->bill5 * 5) + ($this->bill10 * 10) + ($this->bill20 * 20) + ($this->bill50 * 50) + ($this->bill100 * 100);
    }

    public function insertBill(int $bill, int $amount): int
    {
        switch ($bill) {
            case 1:
                $this->bill1 += $amount;
                break;
            case 5:
                $this->bill5 += $amount;
                break;
            case 10:
                $this->bill10 += $amount;
                break;
            case 20:
                $this->bill20 += $amount;
                break;
            case 50:
                $this->bill50 += $amount;
                break;
            case 100:
                $this->bill100 += $amount;
                break;
            default:
                return 0;
        }
        return $bill * $amount;
    }

    public function removeBill(int $bill, int $amount): int
    {
        switch ($bill) {
            case 1:
                $this->bill1 -= $amount;
                break;
            case 5:
                $this->bill5 -= $amount;
                break;
            case 10:
                $this->bill10 -= $amount;
                break;
            case 20:
                $this->bill20 -= $amount;
                break;
            case 50:
                $this->bill50 -= $amount;
                break;
            case 100:
                $this->bill100 -= $amount;
                break;
            default:
                return 0;
        }
        return $bill * $amount;
    }
}