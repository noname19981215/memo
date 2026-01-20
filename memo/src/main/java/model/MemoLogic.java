package model;

import dao.MemosDAO;

public class MemoLogic {
		public void execute(Memo Memo) {
			MemosDAO dao=new MemosDAO();
			dao.create(Memo);
		}
}
