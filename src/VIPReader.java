
/*例2-5 新增会员读者类 VIPReader.java
  读者身份分为：VIP、普通会员、非会员*/

class VIPReader extends Reader
{
	String readergrade;        //读者身份级别
	double pencent;             //会员折扣
   int  bonusPoints;           //会员积分
	 VIPReader(String name,String grade)
	{
		super(name);                   //调用父类构造方法创建普通读者
		readergrade=grade;       //设置读者身份
		bonusPoints=0;
		setPencent();
	}
	 void setReadergrade(String grade)//设置读者身份
	{
		readergrade=grade;
		setPencent();
	}
	String getReadergrade()      //获取读者身份
	{
		return	readergrade;
	}
	void setPencent()                //设置折扣率
	{
				if (readergrade.equals("VIP") )   //VIP待遇
			    {
			    	pencent=0.8;
			    }
		    	else if (readergrade.equals("普通会员"))  //普通会员待遇
		       {
				   pencent=0.9;
			   }
		      else                                                //非会员
		      {
				  pencent=1;
			  }
	}
	double getPencent()                            //获取折扣率
	{
			  return pencent;
	}
	void setBonusPoints(int point)       //计算会员积分
	{
			bonusPoints+=point;
	}
	 double getBonusPoints()           //获取会员积分
	{
			return bonusPoints;
	}
	boolean payRent(double rent)  //支付租金
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
		return super.toString()+" 身份："+getReadergrade()+" 当前积分："+bonusPoints
		  +"  享有折扣率："+pencent;
	}
}

