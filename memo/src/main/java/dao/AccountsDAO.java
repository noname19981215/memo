package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;


	public class AccountsDAO {
	    private final String JDBC_URL = "jdbc:h2:~/memo";
	    private final String DB_USER = "sa";
	    private final String DB_PASS = "";

	    // コンストラクタ
	    public AccountsDAO() {
	        try {
	            Class.forName("org.h2.Driver");
	        } catch (ClassNotFoundException e) {
	            throw new IllegalStateException("JDBCドライバを読み取れませんでした");
	        }

	        String sql = "CREATE TABLE IF NOT EXISTS ACCOUNTS (" +
	                     "USER_ID VARCHAR(10) PRIMARY KEY, " +
	                     "PASS VARCHAR(10) NOT NULL, " +
	                     "MAIL VARCHAR(100) NOT NULL, " +
	                     "NAME VARCHAR(40) NOT NULL, " +
	                     "AGE INT NOT NULL" +
	                     ")";

	        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	public Account findByLogin(Login login) {
		Account account=null;
		//JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み取れませんでした");
			
		}
		//データベースへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			
			//SELECT文を準備
			String sql="SELECT USER_ID,PASS,MAIL,NAME,AGE FROM ACCOUNTS WHERE USER_ID=?AND PASS=?";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			
			pStmt.setString(1,login.getUserId());
			pStmt.setString(2,login.getPass());
			//SELECT文を実行し、結果表を取得
			ResultSet rs=pStmt.executeQuery();
			
			if(rs.next()) {
				//ユーザーが存在したらデータを取得
				//そのユーザーを表すAccountインスタンスを生成
				
				String userId=rs.getString("USER_ID");
				String pass=rs.getString("PASS");
				String mail=rs.getString("MAIL");
				String name=rs.getString("NAME");
				int age=rs.getInt("AGE");
				account =new Account(userId,pass,mail,name,age);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
				
			}
			return account;
		}
	public boolean insert(Account account) {
		try {
			Class.forName("org.h2.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み取れませんでした");
			
		}
		

	    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
	    	String sql = "INSERT INTO ACCOUNTS(USER_ID, PASS, MAIL, NAME, AGE) VALUES (?, ?, ?, ?, ?)";
	         PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setString(1, account.getUserId());
	        ps.setString(2, account.getPass());
	        ps.setString(3, account.getMail());
	        ps.setString(4, account.getName());
	        ps.setInt(5, account.getAge());

	        int result = ps.executeUpdate();
	        return result == 1;

	    } catch (SQLException e) {
	    	
	        e.printStackTrace();
	        return false;
	    }
	}

	}


