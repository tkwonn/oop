<?php

namespace Persons\Employees;

use FoodOrders\FoodOrder;

class Chef extends Employee
{
    public function __construct(string $name, int $age, string $address, int $id, float $salary)
    {
        parent::__construct($name, $age, $address, $id, $salary);
    }

    public function prepareFood(FoodOrder $foodOrder): int
    {
        $foodItems = $foodOrder->getItems();
        $totalTime = 0;
        foreach ($foodItems as $foodItem) {
            echo "{$this->name} is preparing {$foodItem->getCategory()}." . PHP_EOL;
            $totalTime += $foodItem->getPreparationTime();
        }
        echo "{$this->name} took {$totalTime} minutes to cook." . PHP_EOL;
        return $totalTime;
    }
}