<?php

require_once 'Person.php';

$p = new Person("John", "Doe", 30, 1.75, 80);
$p->addMoney(500);
$p->spendMoney(125);
echo $p->getCash() . PHP_EOL;