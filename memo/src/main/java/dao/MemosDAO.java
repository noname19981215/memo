	package dao;
	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Memo;
public class MemosDAO {
	

		
		//データベース接続に使用する情報
		private final String JDBC_URL="jdbc:h2:tcp://localhost/~/memo";
		private final String DB_USER="sa";
		private final String DB_PASS="";
		
			public boolean create(Memo memo) {
				//JDBCドライバを読み込む
				try {
					Class.forName("org.h2.Driver");
				}catch(ClassNotFoundException e) {
					throw new IllegalStateException(
							"JDBCドライバが読み込めませんでした");
				}
				//データベース接続
				try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
					
				//INSERT文の準備（IDは自動連番なので指定しなくてよい）
					String sql= "INSERT INTO MEMOS(USER_ID, TITLE, MEMO, DATE) VALUES(?, ?, ?, ?)";
					PreparedStatement pStmt=conn.prepareStatement(sql);
					
					//INSERT文中の「？」に使用する値を設定してSQL文を完成
					pStmt.setString(1, memo.getUserId());
					pStmt.setString(2, memo.getTitle());
					pStmt.setString(3, memo.getText());
					pStmt.setString(4, memo.getDay());
					
					//INSERT文を実行（resultには追加された行数が代入される）
					int result=pStmt.executeUpdate();
					if(result !=1) {
						return false;
					}
				}
				catch(SQLException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
			public List<Memo> selectmemo(String userId){
				
				List<Memo> memoList=new ArrayList<>();
				//JDBCドライバを読み込む
				try {
					Class.forName("org.h2.Driver");
				}catch (ClassNotFoundException e) {
					throw new IllegalStateException(
							"JDBCドライバを読み込めませんでした");
				}

				//データベース接続
				try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
					
					//SELECT文の準備
					String sql="SELECT ID, USER_ID, TITLE, MEMO, DATE FROM MEMOS WHERE USER_ID=?";
					PreparedStatement pStmt=conn.prepareStatement(sql);
					
					pStmt.setString(1,userId);
					//SELECT文を実行
					ResultSet rs= pStmt.executeQuery();
					
					//SELECT文の結果をArrayListに格納
					while(rs.next()) {
						int id = rs.getInt("ID");
						String userid = rs.getString("USER_ID");
						String title = rs.getString("TITLE");
						String text = rs.getString("MEMO");
						String day = rs.getString("DATE");

						Memo memo=new Memo(id,userid,title,text,day);
						//System.out.print(memo);
						memoList.add(memo);

					}
				}catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
				return memoList;
				}
			public boolean delete(int memoId, String userId) {

			    try {
			        Class.forName("org.h2.Driver");
			    } catch (ClassNotFoundException e) {
			        throw new IllegalStateException("JDBCドライバが読み込めませんでした");
			    }

			    try (Connection conn =
			         DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			        String sql =
			          "DELETE FROM MEMOS WHERE ID = ? AND USER_ID = ?";

			        PreparedStatement pStmt = conn.prepareStatement(sql);
			        pStmt.setInt(1, memoId);
			        pStmt.setString(2, userId);

			        int result = pStmt.executeUpdate();
			        return result == 1;

			    } catch (SQLException e) {
			        e.printStackTrace();
			        return false;
			    }
			}
			
			
			
			
			
			public Memo findById(int id, String userId) {

			    try {
			        Class.forName("org.h2.Driver");
			    } catch (ClassNotFoundException e) {
			        throw new IllegalStateException("JDBCドライバが読み込めませんでした");
			    }

			    try (Connection conn =
			         DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			        String sql =
			          "SELECT ID, USER_ID, TITLE, MEMO, DATE " +
			          "FROM MEMOS WHERE ID = ? AND USER_ID = ?";

			        PreparedStatement pStmt = conn.prepareStatement(sql);
			        pStmt.setInt(1, id);
			        pStmt.setString(2, userId);

			        ResultSet rs = pStmt.executeQuery();

			        if (rs.next()) {
			            return new Memo(
			                rs.getInt("ID"),
			                rs.getString("USER_ID"),
			                rs.getString("TITLE"),
			                rs.getString("MEMO"),
			                rs.getString("DATE")
			            );
			        }

			    } catch (SQLException e) {
			        e.printStackTrace();
			    }

			    return null;
			}
			
			
			
			
			
			public boolean update(Memo memo) {

			    try {
			        Class.forName("org.h2.Driver");
			    } catch (ClassNotFoundException e) {
			        throw new IllegalStateException("JDBCドライバが読み込めませんでした");
			    }

			    try (Connection conn =
			         DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			        String sql =
			          "UPDATE MEMOS SET TITLE = ?, MEMO = ?, DATE = ? " +
			          "WHERE ID = ? AND USER_ID = ?";

			        PreparedStatement pStmt = conn.prepareStatement(sql);
			        pStmt.setString(1, memo.getTitle());
			        pStmt.setString(2, memo.getText());
			        pStmt.setString(3, memo.getDay());
			        pStmt.setInt(4, memo.getId());
			        pStmt.setString(5, memo.getUserId());

			        int result = pStmt.executeUpdate();
			        return result == 1;

			    } catch (SQLException e) {
			        e.printStackTrace();
			        return false;
			    }
			}
			
			
			
			
			
			public List<Memo> searchmemo(String userid,String search) {
				List<Memo> memoList=new ArrayList<>();

			    try {
			        Class.forName("org.h2.Driver");
			    } catch (ClassNotFoundException e) {
			        throw new IllegalStateException("JDBCドライバが読み込めませんでした");
			    }

			    try (Connection conn =
			         DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			        String sql ="SELECT ID, USER_ID, TITLE, MEMO, DATE FROM MEMOS WHERE USER_ID=? AND MEMO LIKE ?";

			        PreparedStatement pStmt = conn.prepareStatement(sql);
			 
			        pStmt.setString(1, userid);
			        //System.out.print(search);
			        pStmt.setString(2,"%"+search +"%");
			        //System.out.print(pStmt);
			        ResultSet rs= pStmt.executeQuery();
			        //System.out.print(rs);
					
					//SELECT文の結果をArrayListに格納
					while(rs.next()) {
						int id=rs.getInt("ID");
						String userId = rs.getString("USER_ID");
						String title = rs.getString("TITLE");
						String text = rs.getString("MEMO");
						String day = rs.getString("DATE");

						Memo memo=new Memo(id,userId,title,text,day);
		
						memoList.add(memo);
						//System.out.print(memoList);

					}
				}catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
				return memoList;
		}
	}
