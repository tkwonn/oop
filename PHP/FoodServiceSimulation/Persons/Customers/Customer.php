<?php

namespace Persons\Customers;

use Persons\Person;
use Restaurants\Restaurant;
use Invoices\Invoice;

class Customer extends Person
{
    private array $tasteMap;
    public function __construct(string $name, int $age, string $address, array $tasteMap)
    {
        parent::__construct($name, $age, $address);
        $this->tasteMap = $tasteMap;
    }

    public function interestedCategories(Restaurant $restaurant): array
    {
        $categories = $restaurant->getCategories();
        $categoriesMap = array_flip($categories);
        $interestedList = array_intersect_key($this->tasteMap, $categoriesMap);

        echo "{$this->name} wanted to eat " . implode(", ", array_keys($this->tasteMap)) . "." . PHP_EOL;

        return $interestedList;
    }

    private function toOrdersString(array $orderMap): array
    {
        $ordersStrings = [];
        foreach ($orderMap as $item => $quantity) {
            $ordersStrings[] = "{$item} × {$quantity}";
        }

        return $ordersStrings;
    }

    public function order(Restaurant $restaurant): Invoice
    {
        $interestedList = $this->interestedCategories($restaurant);
        echo "{$this->name} was looking at the menu, and ordered "
        . implode(', ', $this->toOrdersString($interestedList)). "." . PHP_EOL;
        return $restaurant->order($interestedList);
    }
}