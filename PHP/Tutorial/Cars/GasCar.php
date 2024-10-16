<?php

namespace Cars;

use Engines\GasolineEngine;

// parent:: とは、PHP で使われるキーワードの一つです。
// parent:: は親クラスのメソッドやプロパティを参照するために使用します。
// このケースでは、GasCar クラスが Car クラスを継承しています。そして、GasCar の __construct コンストラクタが親クラス Car のコンストラクタを呼び出すために parent::__construct が使われています。

class GasCar extends Car
{
    public function __construct(string $make)
    {
        parent::__construct($make, new GasolineEngine());
    }

    public function drive(): string
    {
        return 'Driving a gas car...';
    }
}
