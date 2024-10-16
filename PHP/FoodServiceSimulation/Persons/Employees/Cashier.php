<?php

namespace Persons\Employees;

use FoodOrders\FoodOrder;
use FoodItems\FoodItem;
use Invoices\Invoice;

class Cashier extends Employee
{
    public function __construct(string $name, int $age, string $address, int $employeeId, float $salary)
    {
        parent::__construct($name, $age, $address, $employeeId, $salary);
    }

    public function generateOrder(array $categories, array $menu): FoodOrder
    {
        $result = [];
        foreach($categories as $item => $quantity) {
            for($i = 0; $i < $quantity; $i++) {
                $result[] = new $menu[$item]();
            }
        }
        echo "{$this->name} received the order." . PHP_EOL;
        return new FoodOrder($result);
    }

    private function calcTotalPrice(FoodOrder $foodOrder): float
    {
        $foodItems = $foodOrder->getItems();
        return array_reduce($foodItems, function (float $total, FoodItem $foodItem)
        {
            return $total + $foodItem->getPrice();
        }, 0.0);
    }

    public function generateInvoice(FoodOrder $foodOrder)
    {
        echo "{$this->name} made the invoice." . PHP_EOL;
        $totalPrice = $this->calcTotalPrice($foodOrder);
        return new Invoice($totalPrice);
    }
}