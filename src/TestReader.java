

/* ��дһ�������� TestReader.java, ���Զ����������Ƿ���ȷ */
class TestReader
{
	public static void main(String args[])
	{
		System.out.println("������Ĳ���������£�");

		Reader reader1= new Reader();   //���޲ι��췽����������1
	   System.out.println(reader1);        //����½�����1��Ϣ��û������
      reader1. setReaderName("����"); //�޸�Ĭ�Ϲ���Ķ�������
		System.out.println(reader1);          //�ٴ�����½�����1��Ϣ
        Reader reader2= new Reader("����");  //���вι��췽����������2
		System.out.println(reader2);          //����½�����2��Ϣ

		System.out.println(reader2.note);         //�������2�Ĳ�����ʾ����note
        reader2.setReaderPwd("abc");              //����ʵ�������޸Ķ���2������
        System.out.print("\nsetReaderPwd(��abc��)���� "+ reader2.note); //��ʾ���Ȳ���
        System.out.println(reader2);             //����ԭʼ����

        reader2.setReaderPwd("abc123"); //�ٴε���ʵ�������޸Ķ���2������
        System.out.print(reader2.note);     //��ʾ�޸�����ɹ�
        System.out.println(reader2);          //Ϊ�޸ĺ��������

        reader2.setBalance(-50);              //����ʵ������Ϊ����2��ֵ
        System.out.print("\nsetBalance(-50)���� "+reader2.note);  //��ʾ��������
        System.out.println(reader2);          //����ԭ�������

        reader2.setBalance(28);                   //�ٴε���ʵ������Ϊ����2��ֵ
		System.out.print(reader2.note);      //��ʾ��ֵ�ɹ�
        System.out.println(reader2+"\n");  //��ֵ��������
	}
}

