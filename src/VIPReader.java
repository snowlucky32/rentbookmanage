
/*��2-5 ������Ա������ VIPReader.java
  ������ݷ�Ϊ��VIP����ͨ��Ա���ǻ�Ա*/

class VIPReader extends Reader
{
	String readergrade;        //������ݼ���
	double percent;             //��Ա�ۿ�
   int  bonusPoints;           //��Ա����
	 VIPReader(String name,String grade)
	{
		super(name);                   //���ø��๹�췽��������ͨ����
		readergrade=grade;       //���ö������
		bonusPoints=0;
		setPercent();
	}
	 void setReadergrade(String grade)//���ö������
	{
		readergrade=grade;
		setPercent();
	}
	String getReadergrade()      //��ȡ�������
	{
		return	readergrade;
	}
	void setPercent()                //�����ۿ���
	{
				if (readergrade.equals("VIP") )   //VIP����
			    {
			    	percent=0.8;
			    }
		    	else if (readergrade.equals("��ͨ��Ա"))  //��ͨ��Ա����
		       {
				   percent=0.9;
			   }
		      else                                                //�ǻ�Ա
		      {
				  percent=1;
			  }
	}
	double getPercent()                            //��ȡ�ۿ���
	{
			  return percent;
	}
	void setBonusPoints(int point)       //�����Ա����
	{
			bonusPoints+=point;
	}
	 double getBonusPoints()           //��ȡ��Ա����
	{
			return bonusPoints;
	}
	boolean payRent(double rent)  //֧�����
	{
		   if(balance>=rent)
			{
				balance=balance-rent;
			    return true;
			}
			else
			   return false;
	}
	public String toString()
	{
		return super.toString()+" ��ݣ�"+getReadergrade()+" ��ǰ���֣�"+bonusPoints
		  +"  �����ۿ��ʣ�"+percent;
	}
}

