package test;

import java.util.List;

import dao.memosDAO;
import model.memo;

public class memosDAOTest {
	public static void main(String[] args) {
		testFindByLoginOK();

		//testFindByLoginNG();
	}
	public static void testFindByLoginOK() {
		memosDAO dao = new memosDAO();
		List<memo> result=dao.selectmemo("1");
		
		System.out.println(result);
		
		if(result != null&&result.get(0).getUserId().equals("1")){
			System.out.println("testFindByLoginOK:成功しました");
		}else {
			System.out.println("testFindByLoginOK:失敗しました");
		}
	}
	public static void testFindByLoginNG() {
		memosDAO dao=new memosDAO();
		List<memo> result=dao.selectmemo("3");
		
		System.out.println(result);
		
		if(result==null) {
			System.out.println("testFindByLoginNG:成功しました");
		}else {
			System.out.println("testFinfByLoginNG:失敗しました");
		}
	}

}