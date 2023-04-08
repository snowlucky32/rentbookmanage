

/* 例2-3 一个读者类 Reader.java  */
 class Reader    //定义一个名为Reader的类
{
   /* 1.定义类的5个实例变量：读者编号、姓名、密码、账户余额、操作提示，1个类变量*/
	 int    readerID;                   //读者编号
	 String readerName;           //读者姓名
	 String readerPwd;            //读者密码
	 double  balance;              //读者账户余额
     String note="\n读者类操作结果提示:";  //操作提示
     static  int  nextReaderID;  //用static修饰的类变量，用来产生读者编号
    static                          //静态初始化器
 	{
 	   nextReaderID = 10001;   //读者起始编号为10001
 	}

 /* 2.定义两个构造方法，用来进行对象的初始化 */
     Reader()                                     //构造方法1，无参，用默认值构造对象
    {
        readerID=nextReaderID++;    //读者编号自增加
        readerName="";                      //默认读者为匿名
        readerPwd="666666";            //默认密码为6666
        balance=0;                              //默认账户余额为0
    }

   Reader(String name)               //构造方法2，带1个参数读者姓名
	{
		this();                                  //调用无参构造方法
		readerName=name;         //将参数name赋值给实例变量
  	}

   /* 3.  定义几个实例方法获取或修改特定属性   */
	void setReaderName(String newname) //设置读者姓名
	{
		readerName=newname;
	}
	 String getReaderName()            //取得读者姓名
	{
		return readerName;
	}
	 void setReaderPwd(String newpwd) //设置密码
	{
		if(newpwd.length()<6)
		{
			note="提醒: 密码长度不要小于6位，太短不安全哦!";
		}
		else
	   {
			readerPwd=newpwd;
			note="\n修改密码成功!";
		}
	}
     String getReaderPwd()        //取得密码
	{
		return readerPwd;
	}
   void setBalance(double moreMoney) //账户充值
	{
		if(moreMoney<0)
		{
			note="充值不能为负数!";
		}
		else
		{
			balance=balance+moreMoney;
			note="\n充值成功!";
		}
	}
   double getBalance()          //获取账户余额
	{
			return balance;
	}

   /* 4. 重写toString（）方法输出有关信息 */
   public String toString()
    {
      return "读者编号: "+readerID+"  姓名: "+readerName+" 密码："
            +readerPwd+" 账户余额："+balance;
     }
}

