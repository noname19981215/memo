# memo

目次<br>
・１プロジェクト概要<br>
・２使用技術<br>
・３主な機能<br>
・４使用方法<br>
・５ディレクトリ構成<br>
<br><br>

・１　プロジェクト概要<br>
<br>
本アプリは学習の過程で行ったJAVA、SQL、サーブレット、JSPなどの成果を確認するために制作されたメモアプリです。<br>
簡易的なメモアプリではありますが、動作する形に落とし込むことができました。<br>

・２　使用技術<br>
-H2　（開発用ＤＢ）<br>
-openjdk 21.0.2<br>
-HTML<br>
-Eclipse 4.30.0<br>
-Jakarta Standard Tag Library API » 3.0.0<br>
-Docker
-Render


・３　主な機能<br>
-ログイン、新規登録機能<br>
-メモの一覧表示、メモの追加、削除、編集<br>
-メモの内容の検索機能<br>

・４　使用方法<br>
１、「新規登録」からユーザー登録（登録済みの方は「ログイン」からログイン）
<img width="1920" height="1080" alt="スクリーンショット (2)" src="https://github.com/user-attachments/assets/62a516db-fdae-4305-9eba-ddb1960b22e0" />
２、トップページでメモの一覧を確認<img width="1920" height="1080" alt="スクリーンショット (6)" src="https://github.com/user-attachments/assets/17c2248c-65f0-4c87-b299-8e6fc6cf723a" />

３、「新規作成」からメモの作成<img width="1920" height="1080" alt="スクリーンショット (11)" src="https://github.com/user-attachments/assets/d90f1700-8895-40a6-9fbe-f3120f0c8ea1" />

４、「検索」からメモの検索<img width="1920" height="1080" alt="スクリーンショット (9)" src="https://github.com/user-attachments/assets/94deb821-6352-444e-84cc-cc5d5b24f92b" />
<img width="1920" height="1080" alt="スクリーンショット (10)" src="https://github.com/user-attachments/assets/5e87fb33-a97c-4dd8-ba2d-48a5664bc18f" />

５、「削除」、「編集」からメモの削除、編集を行うことができる
<img width="1920" height="1080" alt="スクリーンショット (8)" src="https://github.com/user-attachments/assets/cb361e32-b8f3-4fad-84e2-8873ea74db6e" />
<img width="1920" height="1080" alt="スクリーンショット (7)" src="https://github.com/user-attachments/assets/a4e31fad-7279-4c1d-8b00-0b5aaf96253a" />

・５　ディレクトリ構成<br>
```
memo/
├── Dockerfile
├── README.md
├── memo/
│   ├── Dockerfile
│   ├── build/
│   │   └── classes/
│   │       ├── dao/
│   │       │   ├── AccountsDAO.class
│   │       │   └── MemosDAO.class
│   │       ├── model/
│   │       │   ├── Account.class
│   │       │   ├── Login.class
│   │       │   ├── LoginLogic.class
│   │       │   ├── Memo.class
│   │       │   ├── MemoLogic.class
│   │       │   └── Registration.class
│   │       ├── servlet/
│   │       │   ├── LoginServlet.class
│   │       │   ├── MemoAddServlet.class
│   │       │   ├── MemoDelServlet.class
│   │       │   ├── MemoEdiServlet.class
│   │       │   ├── MemoMainServlet.class
│   │       │   ├── MemoRegistrationServlet.class
│   │       │   ├── MemoSearchServlet.class
│   │       │   ├── MemoSearchUpServlet.class
│   │       │   ├── MemoUpServlet.class
│   │       │   ├── MemoUpdateServlet.class
│   │       │   ├── RegistrationServlet.class
│   │       │   ├── UserServlet.class
│   │       │   └── WelcomeServlet.class
│   │       └── test/
│   │           ├── AccounntsDAOTest.class
│   │           ├── LoginLogicTest.class
│   │           └── MemosDAOTest.class
│   └── src/
│       └── main/
│           ├── java/
│           │   ├── dao/
│           │   │   ├── AccountsDAO.java
│           │   │   └── MemosDAO.java
│           │   ├── model/
│           │   │   ├── Account.java
│           │   │   ├── Login.java
│           │   │   ├── LoginLogic.java
│           │   │   ├── Memo.java
│           │   │   ├── MemoLogic.java
│           │   │   └── Registration.java
│           │   ├── servlet/
│           │   │   ├── LoginServlet.java
│           │   │   ├── MemoAddServlet.java
│           │   │   ├── MemoDelServlet.java
│           │   │   ├── MemoEdiServlet.java
│           │   │   ├── MemoMainServlet.java
│           │   │   ├── MemoRegistrationServlet.java
│           │   │   ├── MemoSearchServlet.java
│           │   │   ├── MemoSearchUpServlet.java
│           │   │   ├── MemoUpServlet.java
│           │   │   ├── MemoUpdateServlet.java
│           │   │   ├── RegistrationServlet.java
│           │   │   ├── UserServlet.java
│           │   │   └── WelcomeServlet.java
│           │   └── test/
│           │       ├── AccounntsDAOTest.java
│           │       ├── LoginLogicTest.java
│           │       └── MemosDAOTest.java
│           └── webapp/
│               ├── META-INF/
│               │   └── MANIFEST.MF
│               └── WEB-INF/
│                   ├── jsp/
│                   │   ├── MemoEdit.jsp
│                   │   ├── MemoRegistration.jsp
│                   │   ├── login.jsp
│                   │   ├── memoList.jsp
│                   │   ├── memoSearch.jsp
│                   │   ├── menuAll.jsp
│                   │   ├── user_register.jsp
│                   │   └── welcome.jsp
│                   ├── lib/
│                   │   ├── h2-2.4.240.jar
│                   │   ├── jakarta.servlet.jsp.jstl-3.0.1.jar
│                   │   └── jakarta.servlet.jsp.jstl-api-3.0.0.jar
│                   └── web.xml
├── データ設計.xlsx
├── 回顧.txt
├── 画面設計書.xlsx
└── 要件定義.txt
```
    
