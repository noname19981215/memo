package model;

import dao.memosDAO;

public class memoLogic {
		public void execute(memo Memo) {
			memosDAO dao=new memosDAO();
			dao.create(Memo);
		}
}
