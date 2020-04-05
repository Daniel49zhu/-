package main

import "fmt"

func main() {
	var a = [...]byte{31: 2} // 长度32，最后一个是2 其余是0
	fmt.Println(a)           //[0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 2]
	zero(&a)
	fmt.Println(a) //[0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]
}

func zero(ptr *[32]byte) {
	for i := range ptr {
		ptr[i] = 0
	}
	//go语言中*寻址运算符和[]中括号运算符的优先级是不同的！
	//[]中括号是初等运算符
	//*寻址运算符是单目运算符
	//初等运算符的优先级是大于单目运算符的，因此先参与计算的是p[0];
	//p[0]其实就是数组的第一个元素，就是数字1
	//数字1必然是int类型，而不是一个地址，因此针对数字1使用*寻址运算符自然也就发生了错误。
	//解决问题的办法很简单，就是添加一个小括号就可以了。
	//即：
	//(*p)[0]
	//不过因为*在go语言中，建立了 p:=&arr 这种类似地址关系后，*允许不写
}
