package model;

import java.io.Serializable;

public class memo implements Serializable {
	
	
	private int id;//shuキー用のID
	private String userid;//ユーザーID
    private String title;
	private String memo;//メモの内容
	private String day;//日にち
	private String search;//検索欄のワード

    public memo() {}
    public memo(String userid, String title, String memo, String day) {//追加する法のコンストラクタ
        this.userid = userid;
        this.title = title;
        this.memo = memo;
        this.day = day;
    }

	
    public memo(int id, String userid, String title, String memo, String day) {//削除用のコンストラクタ
        this.id = id;
        this.userid = userid;
        this.title = title;
        this.memo = memo;
        this.day = day;
    }
    public memo(String userid,String search) {
    this.userid=userid;
    this.search=search;
    }

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getUserId() {
        return userid;
    }

    public void setUserId(String userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return memo;
    }

    public void setText(String memo) {
        this.memo = memo;
    }
    public String getDay() {
    return day;
    }

    public void setDay(String day) {
    this.day = day;
    }
    public String getSeach() {
    	return search;
    }
    public void setSearch(String search) {
    	this.search=search;
    }
}