

/* 编写一个测试类 TestReader.java, 测试读者类运行是否正确 */
class TestReader
{
	public static void main(String args[])
	{
		System.out.println("读者类的操作情况如下：");

		Reader reader1= new Reader();   //用无参构造方法创建读者1
	   System.out.println(reader1);        //输出新建读者1信息，没有姓名
      reader1. setReaderName("郭靖"); //修改默认构造的读者姓名
		System.out.println(reader1);          //再次输出新建读者1信息
        Reader reader2= new Reader("黄蓉");  //用有参构造方法创建读者2
		System.out.println(reader2);          //输出新建读者2信息

		System.out.println(reader2.note);         //输出读者2的操作提示属性note
        reader2.setReaderPwd("abc");              //调用实例方法修改读者2的密码
        System.out.print("\nsetReaderPwd(“abc”)—— "+ reader2.note); //提示长度不够
        System.out.println(reader2);             //还是原始密码

        reader2.setReaderPwd("abc123"); //再次调用实例方法修改读者2的密码
        System.out.print(reader2.note);     //提示修改密码成功
        System.out.println(reader2);          //为修改后的新密码

        reader2.setBalance(-50);              //调用实例方法为读者2充值
        System.out.print("\nsetBalance(-50)—— "+reader2.note);  //提示负数出错
        System.out.println(reader2);          //还是原来的余额

        reader2.setBalance(28);                   //再次调用实例方法为读者2充值
		System.out.print(reader2.note);      //提示充值成功
        System.out.println(reader2+"\n");  //充值后的新余额
	}
}

