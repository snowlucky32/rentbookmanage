
/*��2-4 �������ͼ���� RentBook.java
  ����ͼ�����ţ��Ա㴦��һ��౾���*/

class RentBook extends Book
{
	String bookNo;  //ͼ�������
    boolean state;   //ͼ���Ƿ�ɽ�״̬��true=�ɽ裬 false=���ɽ�
	RentBook(String isbn,String name,String author,String publisher,double price,String no)
	{
		super(isbn,name,author,publisher,price);//�ȵ��ø��๹�췽��������ͨͼ�����
		bookNo=no;        //����ͼ������
		state=true;          //�����ͼ��״̬Ϊ�ɽ�
	}
	 void setBookNo(String no) //�޸�ͼ������
	{
		bookNo=no;
	}
	String getBookNo()     //��ȡ����
	{
		return	bookNo;
	}
	 void setState(boolean nstate) //����ͼ��״̬
	{
		  state=nstate;
	}
	 boolean getState() //��ȡͼ��״̬
	{
		  return state;
	}
	public String toString()  // ��д����Object���toString()����
	{
		return super.toString()+" ���ţ�"+getBookNo()+" �Ƿ�ɽ裺"+getState();
	}
}

