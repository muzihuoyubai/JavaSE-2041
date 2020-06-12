### 分数
设计一个表示分数的类Fraction。这个类有两个int类型的成员分别表示分子和分母。

这个类要提供以下的功能：
double toDouble();
将分数转换为double
Fraction plus(Fraction r);
将自己的分数和r的分数相加，产生一个新的Fraction的对象。
Fraction multiply(Fraction r);
将自己的分数和r的分数相乘，产生一个新的Fraction的对象。
void print();
将自己以“分子/分母”的形式输出到标准输出，并带有回车换行。如果分数是1/1，应该输出1。当分子大于分母时，不需要提出整数部分，即31/30是一个正确的输出。
注意，在创建和做完运算后应该化简分数为最简形式。如2/4应该被化简为1/2。
