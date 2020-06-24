package q4.c1;

interface A {
  //Class A
}

interface C {

}

interface B extends A, C // 接口可以实现多继承
{
  //Interface B extending Class A
}