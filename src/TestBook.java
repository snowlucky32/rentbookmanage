/* ��дһ�������� TestBook.java, ����ͼ���������Ƿ���ȷ */
 class TestBook
{
	public static void main(String args[])  //����main��������Ϊ�������������
	{
		/*���ù��췽��������һ���������*/
		Book newbook= new Book("978-7-04-051593-0","Java������������ƽ̳�","ʩ�B  ���׻�","�ߵȽ���������",48.5);
		System.out.println("�������Ϣ���£�\n"+newbook);

         /*���ó�Ա�������޸�����*/
		newbook.setPrice(39.9);
		System.out.println("\n�޸ĺ����Ϣ��"+newbook+"\n");
	}
}

