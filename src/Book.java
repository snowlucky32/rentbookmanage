
/* ��2-2 һ��ͼ���� Book.java  */
 class Book               //����һ����ΪBook����
{
		/* �������5����Ա��������š����������ߡ������硢����*/
		String ISBN;                //�洢���ʱ�׼���
		String bookName;      //�洢����
		String author;             //�洢����
		String publisher;        //�洢������
		double  price;             //�洢��Ķ���

	     /*���幹�췽�������������������ĳ�ʼ��*/

		 Book(String isbn,String bname,String bauthor,String bpublisher,
		             double bprice)
		{
			ISBN=isbn;                     //������isbn��ֵ�����
			bookName=bname;     //������bname��ֵ������
			author=bauthor;           //������bauthor��ֵ������
			publisher=bpublisher;  //������bpublisher��ֵ��������
			price=bprice;                //������bprice��ֵ������
		}

		/*����8����Ա���������ⲿ�����������*/
		 String getISBN()                               //��ȡ���
		{
			return ISBN;
		}

       String getBookName()                      //��ȡ����
		{
			return bookName;
		 }
        String getAuthor()                           //��ȡ����
		{
			return author;
		 }
         String getPublisher()                  //��ȡ������
		{
			return publisher;
		 }
         double  getPrice()                    //��ȡ����
		{
			return price;
		 }
		 void setPrice(double newprice) //�޸����
		 {
		 		price=newprice;
	    }
  public	String toString()  //���Ǽ̳���Object���toString()
     {
		 return "�����Ϣ��"+getISBN()+" | "+getBookName()+" | "
		       +getAuthor()+" | "+getPublisher()+" | "+getPrice();
	 }
  }




