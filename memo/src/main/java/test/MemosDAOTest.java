	package test;

	import java.util.List;

import dao.MemosDAO;
import model.Memo;
public class MemosDAOTest {
	


		public static void main(String[] args) {
			testFindByLoginOK();

			//testFindByLoginNG();
		}
		public static void testFindByLoginOK() {
			MemosDAO dao = new MemosDAO();
			List<Memo> result=dao.selectmemo("1");
			
			System.out.println(result);
			
			if(result != null&&result.get(0).getUserId().equals("1")){
				System.out.println("testFindByLoginOK:成功しました");
			}else {
				System.out.println("testFindByLoginOK:失敗しました");
			}
		}
		public static void testFindByLoginNG() {
			MemosDAO dao=new MemosDAO();
			List<Memo> result=dao.selectmemo("3");
			
			System.out.println(result);
			
			if(result==null) {
				System.out.println("testFindByLoginNG:成功しました");
			}else {
				System.out.println("testFinfByLoginNG:失敗しました");
			}
		}

	}
