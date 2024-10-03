<?php

require_once 'Person.php';

$p = new Person("John", "Doe", 30, 1.75, 80);
$p->addMoney(500);
$p->spendMoney(125);
echo $p->getCash() . PHP_EOL;
$p->printState();

echo $p->dropWallet() . PHP_EOL;
echo $p->getCash() . PHP_EOL;

$w = new Wallet();
$w->setBill1(1);
$w->setBill5(2);

$p->addWallet($w);
echo $p->getCash() . PHP_EOL;

