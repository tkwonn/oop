<?php

class RGB24 {
    public int $red;
    public int $green;
    public int $blue;

    private function __construct(){}

    // Using factory pattern with a private constructor
    // since function overload is not supported in PHP
    public static function fromInt(int $red, int $green, int $blue): self {
        if ($red < 0 || $red > 255 || $green < 0 || $green > 255 || $blue < 0 || $blue > 255) {
            throw new InvalidArgumentException('Color values must be between 0 and 255.');
        }
        $obj = new self();
        $obj->red = $red;
        $obj->green = $green;
        $obj->blue = $blue;
        return $obj;
    }

    public static function fromString(string $inputString): self {
        $obj = new self();
        $len = strlen($inputString);
        if($len == 6) $obj->setColorsByHex($inputString);
        elseif($len == 24) $obj->setColorsByBin($inputString);
        else $obj->setAsBlack();
        return $obj;
    }

    public function setColorsByHex(string $hex): void {
        $this->red = base_convert(substr($hex, 0, 2), 16, 10);
        $this->green = base_convert(substr($hex, 2, 2), 16, 10);
        $this->blue = base_convert(substr($hex, 4, 2), 16, 10);
    }

    public function setColorsByBin(string $bin): void {
        $this->red = base_convert(substr($bin, 0, 8), 2, 10);
        $this->green = base_convert(substr($bin, 8, 8), 2, 10);
        $this->blue = base_convert(substr($bin, 16, 8), 2, 10);
    }

    public function setAsBlack(): void {
        $this->red = 0;
        $this->green = 0;
        $this->blue = 0;
    }

    public function getHex(): string {
        $hex = dechex($this->red);
        $hex .= dechex($this->green);
        $hex .= dechex($this->blue);

        return $hex;
    }

    public function getBits(): string {
        return base_convert($this->getHex(), 16, 2);
    }

    public function getColorShade(): string {
        if($this->red == $this->green && $this->green == $this->blue) return "grayscale";
        $strArr = ["red", "green", "blue"];
        $intArr = [$this->red, $this->green, $this->blue];

        $max = $intArr[0];
        $maxIndex = 0;
        for($i = 1; $i < count($intArr); $i++){
            if($intArr[$i] >= $max) {
                $max = $intArr[$i];
                $maxIndex = $i;
            }
        }

        return $strArr[$maxIndex];
    }

    // automatically called when you try to use an object as a string
    public function __toString(): string {
        return "The color is rgb(" . $this->red . "," . $this->green . "," . $this->blue . "). Hex: " . $this->getHex() . ", binary: " . $this->getBits(); 
    }
}