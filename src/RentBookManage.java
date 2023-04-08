
/* ��2-6 ͼ��������Ϣ������ RentBookManage.java��*/
import java.util.*;                 //���ذ���Ҫ�õ����е�LinkedList��ArrayList��
 class RentBookManage       //����һ����ΪRentBookManage����
{
	  /*1. �����Ҫ�ĳ�Ա����*/
	    static final int deadTime=10;    //��̬�ೣ�����������ޣ������в����޸ģ�Ҳ��ȥ��final��Ϊ���޸ĵ��������
	    double normalRent=0.1;   //ʵ���������������ķ���
	   	double delayRent=1.0;    //ʵ���������������ķ���
	   	int rentDays;                              //��������
	   	double rent;                              //���ķ���
	   	RentBook rentedbook;             //������֮��
        VIPReader renter;                     //����Ķ���

		LinkedList<RentBook> booklist;   //���ڴ洢�౾�����ķ�������
		ArrayList<VIPReader> readerlist; //���ڴ洢������߶���ķ���˳���
		ArrayList<String> rentlist;            //���ڴ洢���ļ�¼�ķ���˳���
		int j;       		//ѭ������

		/*2. ���幹�췽��*/
       	RentBookManage()      //���幹�췽������ʼ��ͼ�鼰������Ϣ�洢��
		{
			booklist=new LinkedList<RentBook>();    //��ʼ��ͼ������
			readerlist=new ArrayList<VIPReader>();  //��ʼ������˳���
			rentlist=new ArrayList<String>();             //��ʼ�����ļ�¼˳���
		}

    /*3.  ���弸���������Եĳ�Ա���� */
    static double getDeadTime()          //�෽������ȡ��������
   	{
   		return	deadTime;
	}
	 void setNormalRent(double newNR) //ʵ���������޸��������ķ���
	{
		normalRent=newNR;
	}
	double getNormalRent()          //ʵ����������ȡ�������ķ���
	{
		return	normalRent;
	}
	void setDelayRent(double newDR) //ʵ���������޸ĳ������ķ���
	{
		delayRent=newDR;
	}
	 double getDelayRent()          //ʵ����������ȡ�������ķ���
	{
		return	delayRent;
	}

  	   /*4. ����ʵ��ͼ����Ϣ�����ܵĳ�Ա����*/
		void addBook(String isbn,String bname,String bauthor,String bpublisher,double bprice,String no) //ͼ�����
		{
				 booklist.add(new RentBook(isbn,bname,bauthor,bpublisher,bprice,no));  //��������ڱ�β
		}
		void addBook(int i,String isbn,String bname,String bauthor,String bpublisher,double bprice,String no) //����ͼ����ⷽ��
		{
				booklist.add(i,new RentBook(isbn,bname,bauthor,bpublisher,bprice,no)); //��ָ��λ�ò�������
		}
         void searchBook(String bookName)  //ͼ���ѯ����������ѯ
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
			     System.out.println("û���ҵ�ָ�����顣");
		 }
	   void editBook(String bookName,double bprice)     //ͼ���޸ģ��������޸Ķ���
		{
            for( j=0;j<booklist.size();j++)
			{
				if(booklist.get(j).getBookName().equals(bookName))
			    {
				    booklist.get(j).setPrice(bprice);            //�޸Ķ���
			    	System.out.println(booklist.get(j));      //��ȡ�޸ĺ���Ϣ
			   }
		   }
	   }
	void deleteBook(String bookName)              //ͼ��ɾ����������ɾ��
	{
              for( j=0;j<booklist.size();j++)
			 {
			 		if(booklist.get(j).getBookName().equals(bookName))
			        {
				             booklist.remove(j);                  //ɾ������
			  	           System.out.println("�ɹ�ɾ�����顣");
					}
			}
	   }
     void displayBook()                          //���ͼ���嵥
     {
		 for(RentBook  b : booklist)                    //����ǿforѭ�������г�
		   {
		 			System.out.println(b);
			}
	 }

	  /*5. ���������Ϣ��Ӻ�����ĳ�Ա����*/
	  void addReader(String name,String grade)   //������ͬ��ݵĶ���
	  {
		  readerlist.add(new VIPReader(name,grade));  //���¶��߲��ڱ�β
	  }
	   void displayReader()                         //��������嵥
	  {
	  		 for(VIPReader  r : readerlist)                //����ǿforѭ�������г�
	  		   {
	  		 			System.out.println(r);
	  			}
	 }
       /*6. ��������ҵ����صĳ�Ա����*/
    double setRent()                              //���������ܷ���
   	{
   		if(rentDays<=deadTime)
   			rent=rentDays*normalRent*renter.getPencent() ;      //�ڹ涨�����ڰ��������ķ��ʼ������
   		else
   			rent=((rentDays-deadTime)*delayRent+deadTime*normalRent)*renter.getPencent(); //�������
   		return rent;
   	}
   	boolean renting( )             //ʵ��������֧�����
   	{
   		setRent();                        //���ü������ķ���
   		if( renter.payRent(rent)) //�ж��˻�����Ƿ�֧�����
   		{
   			System.out.println(renter.getReaderName()+"֧�����:"+rent+"�ɹ���");
   		    return true;
   		 }
   		 else
   		{
   			System.out.println(renter.getReaderName()+"���˺����="+renter.getBalance()
   				 +"����֧�����"+rent);
   			return false;
   	    }
   	 }
      void rentBook(RentBook bk,VIPReader rd,int days) //ͼ�����ķ���
       {
      		 rentedbook =bk;
      		 renter =rd;
      		 rentDays=days;
      		if( renting( ))                   //���ü����ⷽ���𣬵���֧�����ʱ����Ӹ����ļ�¼
      		 rentlist.add(renter.getReaderName()+" ���ĵ�ͼ���ǣ� "+rentedbook.getBookName()+" | "+
      		   rentedbook.getBookNo()+"���˺����="+renter.getBalance() );
      	}
        void displayRentInfo()         //���������Ϣ
      	{
   		 for(String  br : rentlist)                 //����ǿforѭ�������г�
   		{
   				 System.out.println(br);
   		}
	 }

	 /*7. ���ܲ��ԣ��ȴ���ͼ�鼰���߶��󲢵��ø�������ܣ��ٽ���ͼ������  */
	 public static void main(String args[])
	 {
	 		System.out.println("RentBookManage����������£�");
	 		RentBookManage bm= new RentBookManage();

	 		/* ����ͼ����ӹ��� */
	 		bm.addBook("978-7-04-051593-0","Java������������ƽ̳�","ʩ�B  ���׻�","�ߵȽ���������",48.5,"IT-101-01");
	 	 	bm.addBook("978-7-305-13680-3","Java����ʵ����γ����ָ��","ʩ�B ��","�Ͼ���ѧ������",28,"IT-204-01");
	 		bm.addBook("978-7-113-07777-1","VBѧϰ�뿼��ָ��","ʩ�B ��","�й�����������",35,"IT-301-01");
	        bm.addBook("978-7-103-01234-2","���ݽṹ","������ ","�廪��ѧ������",41.2,"IT-401-01");
	        bm.addBook(1,"978-7-04-051593-0","Java������������ƽ̳�","ʩ�B  ���׻�","�ߵȽ���������",48.5,"IT-101-02");//��������ڵ�1�����
	 	    bm.displayBook();              //�г�����������ͼ����Ϣ

	         /* ����ͼ�����Ĳ�ѯ���޸ġ�ɾ������*/
	         System.out.println("\nsearchBook(��Java������������ƽ̡̳� )");
	 		 bm.searchBook("Java������������ƽ̳�");
            System.out.println("\nsearchBook(��Java������ơ� )");
	 		 bm.searchBook("Java�������");

	         System.out.println("\neditBook(��Java������������ƽ̡̳�,18.5)��");
	         bm.editBook("Java������������ƽ̳�",18.5);

	         System.out.println("\ndeleteBook(��VBѧϰ�뿼��ָ���� )��");
	         bm.deleteBook("VBѧϰ�뿼��ָ��");
             bm.displayBook();   //�г������޸ĺ�ɾ������֮�������ͼ����Ϣ

             	/* ���Զ�����Ӻͳ�ֵ���� */
             	 System.out.println("\naddReader(����,VIP /����,��ͨ��Ա)��setBalance(50/100): ");
             	bm.addReader("����","VIP");
             	bm.addReader("����","��ͨ��Ա");
             	bm.readerlist.get(0).setBalance(50);  //��1�Ŷ��߳�ֵ50
             	bm.readerlist.get(1).setBalance(100);  //��2�Ŷ��߳�ֵ100
             	bm.displayReader();       //�г����ж�����Ϣ

                /* ����ͼ�����Ĺ��� */
                System.out.println("\n����ͼ�����Ĺ��ܣ�");
                bm.rentBook(bm.booklist.get(0),bm.readerlist.get(0),5);  //1�Ŷ���������1#�飬ʱ��5��
                bm.rentBook(bm.booklist.get(2),bm.readerlist.get(0),100);//1�Ŷ���������3#�飬ʱ��100��,δ�ɹ�
                bm.rentBook(bm.booklist.get(3),bm.readerlist.get(1),5);//2�Ŷ���������4#�飬ʱ��5��
                bm.displayRentInfo();        //�г��������ļ�¼
                System.out.println("\n setDelayRent(0.4)���޸ĳ����������²���1�Ŷ�������3#�飬ʱ��100�죺");
                bm.setDelayRent(0.4);      //����������Ϊ0.4/��
                bm.rentBook(bm.booklist.get(2),bm.readerlist.get(0),100);//1�Ŷ���������3#�飬ʱ��100��,δ�ɹ�
                bm.displayRentInfo();        //�г��������ļ�¼
	  }
  }




