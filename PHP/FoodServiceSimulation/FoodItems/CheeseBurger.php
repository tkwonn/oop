<?php

namespace FoodItems;

class CheeseBurger extends FoodItem
{
    private const CATEGORY = 'CheeseBurger';
    public function __construct()
    {
        $name = 'Cheese Burger';
        $description = 'A burger with cheese';
        $price = 8.99;
        $preparationMinTime = 5;
        parent::__construct($name, $description, $price, $preparationMinTime);
    }

    public static function getCategory(): string
    {
        return self::CATEGORY;
    }
}