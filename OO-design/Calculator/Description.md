> 問題のレベル：Easy  
> コンテンツの挿入箇所：カプセル化(2)の最後  
> 目的：メンバ変数をprivateに設定し、アクセサメソッドとミューテータメソッドを用いて内部データを隠蔽しながら、データの取得と更新を行う方法について学ぶ

## 問題文

以下にしたがって、四則演算を行うCalculatorクラスを作成し、テストケースを出力してください。

`int` firstOperand : 1つ目のオペランド  
`int` secondOperand : 2つ目のオペランド  
`int` getFirstOperand: 1つ目のオペランドを取得します  
`int` getSecondOperand: 2つ目のオペランドを取得します  
`void` setFirstOperand(int firstOperand) :  1つ目のオペランドを更新します  
`void` setSecondOperand(int secondOperand) : 2つ目のオペランドを更新します  
`int` add() : firstOperandとsecondOperandの和を返します  
`int` subtract() : firstOperandとsecondOperandの差を返します  
`int` multiply() : firstOperandとsecondOperandの積を返します  
`int` divide() : firstOperandとsecondOperandの商を返します  

## テストケース

Calculator calculator = new Calculator(3, 2);  
System.out.println(calculator.add()); // 5  
System.out.println(calculator.subtract()); // 1

calculator.setFirstOperand(6);  
calculator.setSecondOperand(3);  
System.out.println(calculator.multiply()); // 18  
System.out.println(calculator.divide()); // 2
