
/*��2-5 ������Ա������ VIPReader.java
  ������ݷ�Ϊ��VIP����ͨ��Ա���ǻ�Ա*/

class VIPReader extends Reader
{
	String readergrade;        //������ݼ���
	double pencent;             //��Ա�ۿ�
   int  bonusPoints;           //��Ա����
	 VIPReader(String name,String grade)
	{
		super(name);                   //���ø��๹�췽��������ͨ����
		readergrade=grade;       //���ö������
		bonusPoints=0;
		setPencent();
	}
	 void setReadergrade(String grade)//���ö������
	{
		readergrade=grade;
		setPencent();
	}
	String getReadergrade()      //��ȡ�������
	{
		return	readergrade;
	}
	void setPencent()                //�����ۿ���
	{
				if (readergrade.equals("VIP") )   //VIP����
			    {
			    	pencent=0.8;
			    }
		    	else if (readergrade.equals("��ͨ��Ա"))  //��ͨ��Ա����
		       {
				   pencent=0.9;
			   }
		      else                                                //�ǻ�Ա
		      {
				  pencent=1;
			  }
	}
	double getPencent()                            //��ȡ�ۿ���
	{
			  return pencent;
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
		  +"  �����ۿ��ʣ�"+pencent;
	}
}

