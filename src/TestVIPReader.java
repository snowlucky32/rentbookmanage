

/* ��дһ�������� TestReader.java, ���Զ����������Ƿ���ȷ */
class TestVIPReader
{
	public static void main(String args[])
	{
		System.out.println("VIP������Ĳ���������£�");

        VIPReader reader2= new VIPReader("��ҩʦ","��ͨ��Ա");  //��2���������췽����������
		System.out.println(reader2);            //����½�������Ϣ

        reader2.setReaderPwd("working");      //����ʵ�������޸Ķ��ߵ�����
        reader2.setReadergrade("VIP");           //����ʵ�������޸Ķ��ߵ����
        System.out.print(reader2.note);          //��ʾ�޸�����ɹ�
        System.out.println(reader2);               //����޸ĺ����Ϣ
	}
}

