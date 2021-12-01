package javaIO;

import java.io.Serializable;

public class Student implements Serializable{
	private String stunu;
	private String stuname;
	//transient �ؼ��� ��Ԫ�ز������jvmĬ�ϵ����л� Ҳ�����Լ����������л�
	private  transient int stuage;
	public Student() {
		
	}
	
	public Student(String stunu, String stuname, int stuage) {
		super();
		this.stunu = stunu;
		this.stuname = stuname;
		this.stuage = stuage;
	}

	public String getStunu() {
		return stunu;
	}
	public void setStunu(String stunu) {
		this.stunu = stunu;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public int getStuage() {
		return stuage;
	}
	public void setStuage(int stuage) {
		this.stuage = stuage;
	}
	@Override
	public String toString() {
		return "Student [stunu=" + stunu + ", stuname=" + stuname + ", stuage=" + stuage + "]";
	}
	/**
	 * ��дԴ���루ArrayList��
	 * @param s
	 * @throws java.io.IOException
	 */
	private void writeObject(java.io.ObjectOutputStream s) 
		throws java.io.IOException{
		s.defaultWriteObject();		//��jvmĬ�ϵ�Ԫ�ؽ������л�����
		s.writeInt(stuage);			//�Լ���� stuage �����л�
	}
	private void readObject(java.io.ObjectInputStream s)
		throws java.io.IOException,ClassNotFoundException{
		s.defaultReadObject();		//��jvmĬ�ϵķ����л�Ԫ�ؽ��з����л�����
		this.stuage=s.readInt();	//�Լ����stuage�ķ����л�����
		
	}
	
}
