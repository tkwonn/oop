<?php

class MutableString {
    private array $strArr;

    public function __construct(string $string)
    {
        $this->strArr = str_split($string);
    }

    public function getString(): string {
        return implode('', $this->strArr);
    }

    public function setString(string $string): void {
        $this->strArr = str_split($string);
    }

    public function append(string $c): void {
        if (strlen($c) !== 1) {
            throw new InvalidArgumentException('Argument must be a single character');
        }
        array_push($this->strArr, $c);
    }

    public function substring(int $start): MutableString {
        return new MutableString(implode('', array_slice($this->strArr, $start)));
    }

    public function concat(array $cArr) {
        $this->strArr = array_merge($this->strArr, $cArr);
    }
}

$str = new MutableString("Hello");
$str->append("!");
echo $str->getString() . PHP_EOL; // Hello World

$str2 = $str->substring(6);
echo $str2->getString() . PHP_EOL; // World

$str->concat(['!', '!', '!']);
echo $str->getString() . PHP_EOL; // Hello World!!!
