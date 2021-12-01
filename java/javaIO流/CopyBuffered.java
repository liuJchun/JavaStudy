package liujianchun;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBuffered {

		public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		CopyBudderedOutSteam(new File("E:\\Main.java"), new File("E:\\b.txt"));
	}
	/**
	 * �����ļ��Ŀ��������û����ֽ�����
	 * @throws IOException 
	 */
	public static void CopyBudderedOutSteam(File srcFile,File destFile) throws IOException {
		if(!srcFile.exists()) {
			throw new  IllegalArgumentException("�ļ���"+srcFile+"������");
		}
		if(!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile+":�����ļ�");
		}
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(destFile));
		int c;
		while((c=bis.read())!=-1) {
			bos.write(c);
			bos.flush();	//ˢ�»�����������д�����ļ���ȥ��
		}
		bis.close();
		bos.close();
	}
}
