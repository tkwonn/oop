<?php

namespace FoodItems;

class HawaiianPizza extends FoodItem
{
    private const CATEGORY = 'HawaiianPizza';
    public function __construct()
    {
        $name = 'Hawaiian Pizza';
        $description = 'A pizza with pineapple and ham';
        $price = 12.99;
        $preparationMinTime = 2;
        parent::__construct($name, $description, $price, $preparationMinTime);
    }

    public static function getCategory(): string
    {
        return self::CATEGORY;
    }
}