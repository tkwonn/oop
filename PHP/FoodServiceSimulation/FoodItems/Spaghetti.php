<?php

namespace FoodItems;

class Spaghetti extends FoodItem
{
    private const CATEGORY = 'Spaghetti';
    public function __construct()
    {
        $name = 'Spaghetti';
        $description = 'Spaghetti with tomato sauce';
        $price = 9.99;
        $preparationMinTime = 4;
        parent::__construct($name, $description, $price, $preparationMinTime);
    }

    public static function getCategory(): string
    {
        return self::CATEGORY;
    }
}