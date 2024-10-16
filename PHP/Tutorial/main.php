<?php

// require_once 'Interfaces/Engine.php';
// require_once 'Engines/GasolineEngine.php';
// require_once 'Engines/ElectricEngine.php';
// require_once 'Cars/Car.php';
// require_once 'Cars/GasCar.php';
// require_once 'Cars/ElectricCar.php';

// Solution 1: 多くのプロジェクトでは、ファイルのインクルードは手間がかかる作業となります。手動での推奨解決策としては、必要なすべての include 文を含むファイルを持つ requires フォルダを作成することです。

// COMMENT OUT BELOW
// require_once __DIR__ . '/requires/autoload.php';

// Solution 2-1: 自動ロード機能も存在します。自動ロードスクリプトは、名前が要求されたときに自動的にファイルを読み込むことができます。全てのクラス名やインターフェース名、そしてそれらの名前空間が一定の構造に従っている場合、初期設定のまま spl_autoload_register を使用することができます。
// spl_autoload_extensions(".php") は PHP の関数で、デフォルトのオートローダーが対象とするファイル拡張子を設定します。

// COMMENT OUT BELOW
// spl_autoload_extensions(".php");
// spl_autoload_register();

// Solution 2-2: spl_autoload_register に引数を渡すこともできます。この関数に引数として渡すことができるのは、どのようにその未定義のクラスを読み込むかを指定するコールバック関数です。
// 例のコードでは、未定義のクラス名が $name としてコールバック関数に渡されます。

spl_autoload_register(function ($name) {
    // __DIR__は、現在のファイルの絶対ディレクトリパスを取得します。
    $filepath = __DIR__ . "/" . str_replace('\\', '/', $name) . ".php";
    echo "\nRequiring...." . $name . " once ($filepath).\n";
    // バックスラッシュ(\)をフロントスラッシュ(/)に置き換えます。
    require_once $filepath;
});

$gasCar = new Cars\GasCar('Toyota');
$electricCar = new Cars\ElectricCar('Tesla');

echo $gasCar->drive() . PHP_EOL;
echo $gasCar->start() . PHP_EOL;

echo $electricCar->drive() . PHP_EOL;
echo $electricCar->start() . PHP_EOL;