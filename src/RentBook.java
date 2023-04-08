
/*例2-4 新增租出图书类 RentBook.java
  增加图书入库号，以便处理一书多本情况*/

class RentBook extends Book
{
	String bookNo;  //图书入库编号
    boolean state;   //图书是否可借状态，true=可借， false=不可借
	RentBook(String isbn,String name,String author,String publisher,double price,String no)
	{
		super(isbn,name,author,publisher,price);//先调用父类构造方法创建普通图书对象
		bookNo=no;        //设置图书入库号
		state=true;          //新入库图书状态为可借
	}
	 void setBookNo(String no) //修改图书入库号
	{
		bookNo=no;
	}
	String getBookNo()     //获取入库号
	{
		return	bookNo;
	}
	 void setState(boolean nstate) //设置图书状态
	{
		  state=nstate;
	}
	 boolean getState() //获取图书状态
	{
		  return state;
	}
	public String toString()  // 重写来自Object类的toString()方法
	{
		return super.toString()+" 入库号："+getBookNo()+" 是否可借："+getState();
	}
}

