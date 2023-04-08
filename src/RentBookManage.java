
/* 例2-6 图书租阅信息管理类 RentBookManage.java，*/
import java.util.*;                 //加载包，要用到其中的LinkedList和ArrayList类
 class RentBookManage       //定义一个名为RentBookManage的类
{
	  /*1. 定义必要的成员变量*/
	    static final int deadTime=10;    //静态类常量，租阅期限，运行中不可修改（也可去掉final改为可修改的类变量）
	    double normalRent=0.1;   //实例变量，正常租阅费率
	   	double delayRent=1.0;    //实例变量，超期租阅费率
	   	int rentDays;                              //租阅天数
	   	double rent;                              //租阅费用
	   	RentBook rentedbook;             //被租阅之书
        VIPReader renter;                     //租书的读者

		LinkedList<RentBook> booklist;   //用于存储多本书对象的泛型链表
		ArrayList<VIPReader> readerlist; //用于存储多个读者对象的泛型顺序表
		ArrayList<String> rentlist;            //用于存储租阅记录的泛型顺序表
		int j;       		//循环变量

		/*2. 定义构造方法*/
       	RentBookManage()      //定义构造方法，初始化图书及读者信息存储表
		{
			booklist=new LinkedList<RentBook>();    //初始化图书链表
			readerlist=new ArrayList<VIPReader>();  //初始化读者顺序表
			rentlist=new ArrayList<String>();             //初始化租阅记录顺序表
		}

    /*3.  定义几个访问属性的成员方法 */
    static double getDeadTime()          //类方法，获取租阅期限
   	{
   		return	deadTime;
	}
	 void setNormalRent(double newNR) //实例方法，修改正常租阅费率
	{
		normalRent=newNR;
	}
	double getNormalRent()          //实例方法，获取正常租阅费率
	{
		return	normalRent;
	}
	void setDelayRent(double newDR) //实例方法，修改超期租阅费率
	{
		delayRent=newDR;
	}
	 double getDelayRent()          //实例方法，获取超期租阅费率
	{
		return	delayRent;
	}

  	   /*4. 定义实现图书信息管理功能的成员方法*/
		void addBook(String isbn,String bname,String bauthor,String bpublisher,double bprice,String no) //图书入库
		{
				 booklist.add(new RentBook(isbn,bname,bauthor,bpublisher,bprice,no));  //将新书插在表尾
		}
		void addBook(int i,String isbn,String bname,String bauthor,String bpublisher,double bprice,String no) //重载图书入库方法
		{
				booklist.add(i,new RentBook(isbn,bname,bauthor,bpublisher,bprice,no)); //在指定位置插入新书
		}
         void searchBook(String bookName)  //图书查询：按书名查询
		{
			boolean flag=false;
			 for( j=0;j<booklist.size();j++)
			{
				if(booklist.get(j).getBookName().equals(bookName))
			     {
					 System.out.println(booklist.get(j));
					 flag=true;
			       }
			}
			if(flag==false)
			     System.out.println("没有找到指定的书。");
		 }
	   void editBook(String bookName,double bprice)     //图书修改：按书名修改定价
		{
            for( j=0;j<booklist.size();j++)
			{
				if(booklist.get(j).getBookName().equals(bookName))
			    {
				    booklist.get(j).setPrice(bprice);            //修改定价
			    	System.out.println(booklist.get(j));      //提取修改后信息
			   }
		   }
	   }
	void deleteBook(String bookName)              //图书删除：按书名删除
	{
              for( j=0;j<booklist.size();j++)
			 {
			 		if(booklist.get(j).getBookName().equals(bookName))
			        {
				             booklist.remove(j);                  //删除该书
			  	           System.out.println("成功删除该书。");
					}
			}
	   }
     void displayBook()                          //输出图书清单
     {
		 for(RentBook  b : booklist)                    //用增强for循环逐条列出
		   {
		 			System.out.println(b);
			}
	 }

	  /*5. 定义读者信息添加和输出的成员方法*/
	  void addReader(String name,String grade)   //创建不同身份的读者
	  {
		  readerlist.add(new VIPReader(name,grade));  //将新读者插在表尾
	  }
	   void displayReader()                         //输出读者清单
	  {
	  		 for(VIPReader  r : readerlist)                //用增强for循环逐条列出
	  		   {
	  		 			System.out.println(r);
	  			}
	 }
       /*6. 定义租阅业务相关的成员方法*/
    double setRent()                              //计算租阅总费用
   	{
   		if(rentDays<=deadTime)
   			rent=rentDays*normalRent*renter.getPencent() ;      //在规定期限内按正常租阅费率计算租金
   		else
   			rent=((rentDays-deadTime)*delayRent+deadTime*normalRent)*renter.getPencent(); //超期租金
   		return rent;
   	}
   	boolean renting( )             //实例方法：支付租金
   	{
   		setRent();                        //调用计算租金的方法
   		if( renter.payRent(rent)) //判断账户余额是否够支付租金
   		{
   			System.out.println(renter.getReaderName()+"支付租金:"+rent+"成功！");
   		    return true;
   		 }
   		 else
   		{
   			System.out.println(renter.getReaderName()+"的账号余额="+renter.getBalance()
   				 +"不够支付租金"+rent);
   			return false;
   	    }
   	 }
      void rentBook(RentBook bk,VIPReader rd,int days) //图书租阅方法
       {
      		 rentedbook =bk;
      		 renter =rd;
      		 rentDays=days;
      		if( renting( ))                   //调用计算租方法金，当余额够支付租金时则添加该租阅记录
      		 rentlist.add(renter.getReaderName()+" 借阅的图书是： "+rentedbook.getBookName()+" | "+
      		   rentedbook.getBookNo()+"，账号余额="+renter.getBalance() );
      	}
        void displayRentInfo()         //输出租阅信息
      	{
   		 for(String  br : rentlist)                 //用增强for循环逐条列出
   		{
   				 System.out.println(br);
   		}
	 }

	 /*7. 功能测试：先创建图书及读者对象并调用各项管理功能，再进行图书租阅  */
	 public static void main(String args[])
	 {
	 		System.out.println("RentBookManage运行情况如下：");
	 		RentBookManage bm= new RentBookManage();

	 		/* 测试图书添加功能 */
	 		bm.addBook("978-7-04-051593-0","Java面向对象程序设计教程","施珺  纪兆辉","高等教育出版社",48.5,"IT-101-01");
	 	 	bm.addBook("978-7-305-13680-3","Java语言实验与课程设计指导","施珺 等","南京大学出版社",28,"IT-204-01");
	 		bm.addBook("978-7-113-07777-1","VB学习与考试指导","施珺 等","中国铁道出版社",35,"IT-301-01");
	        bm.addBook("978-7-103-01234-2","数据结构","耿国华 ","清华大学出版社",41.2,"IT-401-01");
	        bm.addBook(1,"978-7-04-051593-0","Java面向对象程序设计教程","施珺  纪兆辉","高等教育出版社",48.5,"IT-101-02");//将此书插在第1本书后
	 	    bm.displayBook();              //列出新增的所有图书信息

	         /* 测试图书管理的查询、修改、删除功能*/
	         System.out.println("\nsearchBook(“Java面向对象程序设计教程” )");
	 		 bm.searchBook("Java面向对象程序设计教程");
            System.out.println("\nsearchBook(“Java程序设计” )");
	 		 bm.searchBook("Java程序设计");

	         System.out.println("\neditBook(“Java面向对象程序设计教程”,18.5)：");
	         bm.editBook("Java面向对象程序设计教程",18.5);

	         System.out.println("\ndeleteBook(“VB学习与考试指导” )：");
	         bm.deleteBook("VB学习与考试指导");
             bm.displayBook();   //列出经过修改和删除操作之后的所有图书信息

             	/* 测试读者添加和充值功能 */
             	 System.out.println("\naddReader(黄蓉,VIP /郭靖,普通会员)、setBalance(50/100): ");
             	bm.addReader("黄蓉","VIP");
             	bm.addReader("郭靖","普通会员");
             	bm.readerlist.get(0).setBalance(50);  //给1号读者充值50
             	bm.readerlist.get(1).setBalance(100);  //给2号读者充值100
             	bm.displayReader();       //列出所有读者信息

                /* 测试图书租阅功能 */
                System.out.println("\n测试图书租阅功能：");
                bm.rentBook(bm.booklist.get(0),bm.readerlist.get(0),5);  //1号读者租阅了1#书，时间5天
                bm.rentBook(bm.booklist.get(2),bm.readerlist.get(0),100);//1号读者租阅了3#书，时间100天,未成功
                bm.rentBook(bm.booklist.get(3),bm.readerlist.get(1),5);//2号读者租阅了4#书，时间5天
                bm.displayRentInfo();        //列出所有租阅记录
                System.out.println("\n setDelayRent(0.4)，修改超期租金后重新测试1号读者租阅3#书，时间100天：");
                bm.setDelayRent(0.4);      //将超期租金改为0.4/天
                bm.rentBook(bm.booklist.get(2),bm.readerlist.get(0),100);//1号读者租阅了3#书，时间100天,未成功
                bm.displayRentInfo();        //列出所有租阅记录
	  }
  }




