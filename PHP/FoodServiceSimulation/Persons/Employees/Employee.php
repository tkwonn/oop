<?php

namespace Persons\Employees;

use Persons\Person;

class Employee extends Person
{
    protected int $id;
    protected float $salary;

    public function __constructor(string $name, int $age, string $address, int $id, float $salary)
    {
        parent::__construct($name, $age, $address);
        $this->id = $id;
        $this->salary = $salary;
    }
}