<?php

namespace FoodItems;

class Fettuccine extends FoodItem
{
    private const CATEGORY = 'Fettuccine';
    public function __construct()
    {
        $name = 'Fettuccine';
        $description = 'Fettuccine with Alfredo sauce';
        $price = 11.99;
        $preparationMinTime = 3;
        parent::__construct($name, $description, $price, $preparationMinTime);
    }
    
    public static function getCategory(): string
    {
        return self::CATEGORY;
    }
}