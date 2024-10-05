> 問題のレベル: Easy  
> コンテンツの挿入箇所：staticメソッド(2)の MathThingsエディタの後

## 問題文

PhysicsThingsを定義するステートレスライブラリを作成してください。  
PhysicsThingsが持つ静的メンバ変数とstaticメソッドは以下のようになります。

`double` GRAVITATION : 6.67438e-11 ($6.67438*10^{-11}$)  
`double` getSurfaceGravity(double massKg, double meanRadiusKm) : ある惑星の質量と半径(km)を受け取り、惑星の重力加速度 $g(m/s^2)$を返します  
`double` getFallingDistance(double gravity, int time) : ある惑星の重力加速度 $g(m/s^2)$と落下時間 time(s)を受け取り、重力加速度 $g(m/s^2)$で、高さ h(m)から物体をそっと落下させ、地上に到達するまで t 秒を要するとき、$h = 1/2 gt^2$ が成り立つとした場合の落下距離(mile)を返します。また、求めた落下距離(mile)の少数第2位以降を切り捨ててください。

## テストケース

double massOfEarth = 5.974e24;  
double meanRadiusKmOfEarth = 6.3782e3;  
double gravityOfEarth = PhysicsThings.getSurfaceGravity(massOfEarth, meanRadiusKmOfEarth);  

System.out.println(gravityOfEarth); // 9.8  
System.out.println(PhysicsThings.getFallingDistance(gravityOfEarth, 5000)); // 76117.0

double massOfMars = 6.419e23;  
double meanRadiusKmOfMars = 3.3972e3;  
double gravityOfMars = PhysicsThings.getSurfaceGravity(massOfMars, meanRadiusKmOfMars);

System.out.println(gravityOfMars); // 3.71
System.out.println(PhysicsThings.getFallingDistance(gravityOfMars, 5000)); // 28816.0
