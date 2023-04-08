
/* 例2-2 一个图书类 Book.java  */
 class Book               //定义一个名为Book的类
{
		/* 定义类的5个成员变量：书号、书名、作者、出版社、定价*/
		String ISBN;                //存储国际标准书号
		String bookName;      //存储书名
		String author;             //存储作者
		String publisher;        //存储出版社
		double  price;             //存储书的定价

	     /*定义构造方法，用来进行新书对象的初始化*/

		 Book(String isbn,String bname,String bauthor,String bpublisher,
		             double bprice)
		{
			ISBN=isbn;                     //将参数isbn赋值给书号
			bookName=bname;     //将参数bname赋值给书名
			author=bauthor;           //将参数bauthor赋值给作者
			publisher=bpublisher;  //将参数bpublisher赋值给出版社
			price=bprice;                //将参数bprice赋值给定价
		}

		/*定义8个成员方法，供外部访问相关属性*/
		 String getISBN()                               //获取书号
		{
			return ISBN;
		}

       String getBookName()                      //获取书名
		{
			return bookName;
		 }
        String getAuthor()                           //获取作者
		{
			return author;
		 }
         String getPublisher()                  //获取出版社
		{
			return publisher;
		 }
         double  getPrice()                    //获取定价
		{
			return price;
		 }
		 void setPrice(double newprice) //修改书价
		 {
		 		price=newprice;
	    }
  public	String toString()  //覆盖继承自Object类的toString()
     {
		 return "书的信息："+getISBN()+" | "+getBookName()+" | "
		       +getAuthor()+" | "+getPublisher()+" | "+getPrice();
	 }
  }




