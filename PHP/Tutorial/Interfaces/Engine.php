<?php

namespace Interfaces;

interface Engine 
{
    public function start(): string;
}

// Note:
// namespace Interfaces; では、Interfaces という名前空間を定義しています。
// これにより、この名前空間に属する全てのコード（クラス、関数、定数など）は Interfaces の下で定義され、他の名前空間と区別されます。
// たとえば、ここで定義される Engine インターフェースは、Interfaces\Engine という名前になります。

