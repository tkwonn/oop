<?php

namespace Restaurants;

use Persons\Employees\Cashier;
use Persons\Employees\Chef;
use Invoices\Invoice;

class Restaurant
{
    private array $menuMap;
    private array $employeeList;

    public function __construct(array $menuList, array $employeeList)
    {
        $this->menuMap = $this->toMenuMap($menuList);
        $this->employeeList = $employeeList;
    }

    private function toMenuMap(array $objects)
    {
        $mapped = [];
        foreach ($objects as $object) {
            $exploded = explode('\\', get_class($object));
            $classname = end($exploded);
            $mapped[$classname] = $object;
        }
        return $mapped;
    }

    public function getCategories(): array
    {
        return array_keys($this->menuMap);
    }

    public function order(array $categories): Invoice
    {
        # CashierにgenerateOrderしてもらう
        $foodOrder = $this->callCashier()->generateOrder($categories, $this->menuMap);

        # OrderをChefに渡して、料理時間も受け取る？
        $this->callChef()->prepareFood($foodOrder);

        # InvoiceをCashierに作ってもらいそれを返す
        return $this->callCashier()->generateInvoice($foodOrder);
    }
    public function callChef(): Chef
    {
        # TODO: need refactoring.
        $chefs = array_filter($this->employeeList, function($employee)
        {
            return $employee instanceof Chef;
        });
        $chefs = array_values($chefs);
        return $chefs[0];
    }

    public function callCashier(): Cashier
    {
        $cashiers = array_filter($this->employeeList, function($employee)
        {
            return $employee instanceof Cashier;
        });
        $cashiers = array_values($cashiers);
        return $cashiers[0];
    }
}