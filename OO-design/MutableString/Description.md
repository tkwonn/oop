> 問題レベル：medium  
> コンテンツ挿入箇所：不変文字列の最後のエディタを問題化

## 問題文

以下に従って、mutableString（可変文字列）クラスを作成し、テストケースを出力してください。

`void` append(char c): 文字を文字列の末尾に挿入します。  
`mutableString` substring(int start): 文字列のインデックス start から最後までの部分文字列を持つ新しいmutableString オブジェクトを返します。  
`mutableString` substring(int startIndex, int endIndex): 文字列のインデックス startIndex から endIndex までの部分文字列を持つ新しいmutableStringオブジェクトを返します。  
`void` concat(char[] cArr): 文字列 cArrを現在の文字列に連結します。その結果、mutableString S = S + cArrとなります。  
`void` concat(String stringInput): 文字列 stringInputを現在の文字列に連結します。その結果、mutableString は S = S + stringInput となります。  
`void` concat(mutableString stringInput): mutableString stringInput を現在の文字列に連結します。その結果、mutableString は S = S + stringInput となります。  
`int` length(): 文字列の長さを返します。

## テストケース

MutableString str1 = new MutableString("good morning");  
System.out.println(str1.getString()); // good morning  
str1.setString("good evening");  
System.out.println(str1.getString()); // good evening  

str1.append('!');  
System.out.println(str1.getString()); // good evening!

MutableString str2 = str1.substring(5);  
System.out.println(str2.getString()); // evening!  
MutableString str3 = str1.substring(0, 5);  
System.out.println(str3.getString()); // good

char[] cArr = new char[] { 'g', 'o', 'o', 'd', ' ' };  
str1.concat(cArr);
System.out.println(str1.getString()); // good evening!good  

String str4 = "bye!";
str1.concat(str4);
System.out.println(str1.getString()); // good evening!good bye!

MutableString str5 = new MutableString("done testing");
str1.concat(str5);
System.out.println(str1.getString()); // good evening!good bye!done testing
