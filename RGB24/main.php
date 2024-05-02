<?php
require_once 'RGB24.php';

$color1 = RGB24::fromInt(0, 153, 255);
$color2 = RGB24::fromInt(255, 153, 204);
$color3 = RGB24::fromInt(153, 255, 51);

echo $color1->getHex() . "<->" . $color1->getBits() . ". Color: " . $color1->getColorShade() . PHP_EOL;
echo $color2->getHex() . "<->" . $color2->getBits() . ". Color: " . $color2->getColorShade() . PHP_EOL;
echo $color3->getHex() . "<->" . $color3->getBits() . ". Color: " . $color3->getColorShade() . PHP_EOL;

$gray = RGB24::fromInt(123,123,123);
echo $gray->getHex() . "<->" . $gray->getBits() . ". Color: " . $gray->getColorShade() . PHP_EOL;

$color4 = RGB24::fromString("ff99cc");
$color5 = RGB24::fromString("100110011111111100110011");
$color6 = RGB24::fromString("7b7b7b");

echo $color4 . PHP_EOL;
echo $color5 . PHP_EOL;
echo $color6 . PHP_EOL;

$gray->setAsBlack();
echo $gray . PHP_EOL;
$color1->setColorsByHex("2EB656");
echo $color1 . PHP_EOL;