<?php

namespace Engines;

// 名前空間から定数や関数、クラス、インターフェース、トレイト、列挙型、そして他の名前空間をインポートするためには、use キーワードを使用します。
use Interfaces\Engine;

class GasolineEngine implements Engine
{
    public function start(): string
    {
        return 'Gasoline engine starting...';
    }
}