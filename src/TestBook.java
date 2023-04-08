/* 编写一个测试类 TestBook.java, 测试图书类运行是否正确 */
 class TestBook
{
	public static void main(String args[])  //定义main方法，作为程序运行主入口
	{
		/*调用构造方法来创建一本新书对象*/
		Book newbook= new Book("978-7-04-051593-0","Java面向对象程序设计教程","施珺  纪兆辉","高等教育出版社",48.5);
		System.out.println("该书的信息如下：\n"+newbook);

         /*调用成员方法来修改属性*/
		newbook.setPrice(39.9);
		System.out.println("\n修改后的信息："+newbook+"\n");
	}
}

