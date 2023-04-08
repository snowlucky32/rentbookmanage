

/* 编写一个测试类 TestReader.java, 测试读者类运行是否正确 */
class TestVIPReader
{
	public static void main(String args[])
	{
		System.out.println("VIP读者类的操作情况如下：");

        VIPReader reader2= new VIPReader("黄药师","普通会员");  //带2个参数构造方法创建读者
		System.out.println(reader2);            //输出新建读者信息

        reader2.setReaderPwd("working");      //调用实例方法修改读者的密码
        reader2.setReadergrade("VIP");           //调用实例方法修改读者的身份
        System.out.print(reader2.note);          //提示修改密码成功
        System.out.println(reader2);               //输出修改后的信息
	}
}

