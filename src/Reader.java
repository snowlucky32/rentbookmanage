

/* ��2-3 һ�������� Reader.java  */
 class Reader    //����һ����ΪReader����
{
   /* 1.�������5��ʵ�����������߱�š����������롢�˻���������ʾ��1�������*/
	 int    readerID;                   //���߱��
	 String readerName;           //��������
	 String readerPwd;            //��������
	 double  balance;              //�����˻����
     String note="\n��������������ʾ:";  //������ʾ
     static  int  nextReaderID;  //��static���ε�������������������߱��
    static                          //��̬��ʼ����
 	{
 	   nextReaderID = 10001;   //������ʼ���Ϊ10001
 	}

 /* 2.�����������췽�����������ж���ĳ�ʼ�� */
     Reader()                                     //���췽��1���޲Σ���Ĭ��ֵ�������
    {
        readerID=nextReaderID++;    //���߱��������
        readerName="";                      //Ĭ�϶���Ϊ����
        readerPwd="666666";            //Ĭ������Ϊ6666
        balance=0;                              //Ĭ���˻����Ϊ0
    }

   Reader(String name)               //���췽��2����1��������������
	{
		this();                                  //�����޲ι��췽��
		readerName=name;         //������name��ֵ��ʵ������
  	}

   /* 3.  ���弸��ʵ��������ȡ���޸��ض�����   */
	void setReaderName(String newname) //���ö�������
	{
		readerName=newname;
	}
	 String getReaderName()            //ȡ�ö�������
	{
		return readerName;
	}
	 void setReaderPwd(String newpwd) //��������
	{
		if(newpwd.length()<6)
		{
			note="����: ���볤�Ȳ�ҪС��6λ��̫�̲���ȫŶ!";
		}
		else
	   {
			readerPwd=newpwd;
			note="\n�޸�����ɹ�!";
		}
	}
     String getReaderPwd()        //ȡ������
	{
		return readerPwd;
	}
   void setBalance(double moreMoney) //�˻���ֵ
	{
		if(moreMoney<0)
		{
			note="��ֵ����Ϊ����!";
		}
		else
		{
			balance=balance+moreMoney;
			note="\n��ֵ�ɹ�!";
		}
	}
   double getBalance()          //��ȡ�˻����
	{
			return balance;
	}

   /* 4. ��дtoString������������й���Ϣ */
   public String toString()
    {
      return "���߱��: "+readerID+"  ����: "+readerName+" ���룺"
            +readerPwd+" �˻���"+balance;
     }
}

