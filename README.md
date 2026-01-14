# memo

目次
・１プロジェクト概要
・２使用技術
・３主な機能
・４使用方法
・５ディレクトリ構成


・１　プロジェクト概要

本アプリは学習の過程で行ったJAVA、SQL、サーブレット、JSPなどの成果を確認するために制作されたメモアプリです。
簡易的なメモアプリではありますが、動作する形に落とし込むことができました。

・２　使用技術
-H2　（開発用ＤＢ）
-openjdk 21.0.2
-HTML
-Eclipse 4.30.0

・３　主な機能
-ログイン、新規登録機能
-メモの一覧表示、メモの追加、削除、編集
-メモの内容の検索機能

・４　使用方法
１、「新規登録」からユーザー登録（登録済みの方は「ログイン」からログイン）
２、トップページでメモの一覧を確認
３、新規作成からメモの作成
４、検索からメモの検索
５、削除、編集からメモの削除、編集を行うことができる

・５　ディレクトリ構成

memo
│  .classpath
│  .project
│
├─.settings
│      .jsdtscope
│      org.eclipse.core.resources.prefs
│      org.eclipse.jdt.core.prefs
│      org.eclipse.wst.common.component
│      org.eclipse.wst.common.project.facet.core.xml
│      org.eclipse.wst.jsdt.ui.superType.container
│      org.eclipse.wst.jsdt.ui.superType.name
│
├─build
│  └─classes
│      ├─dao
│      │      AccountsDAO.class
│      │      memosDAO.class
│      │
│      ├─memo
│      ├─model
│      │      Account.class
│      │      Login.class
│      │      LoginLogic.class
│      │      memo.class
│      │      memoLogic.class
│      │      registration.class
│      │
│      ├─servlet
│      │      LoginServlet.class
│      │      MemoAddServlet.class
│      │      MemoDelServlet.class
│      │      MemoEdiServlet.class
│      │      MemoMainServlet.class
│      │      MemoRegistrationServlet.class
│      │      MemoSearchServlet.class
│      │      MemoSearchUpServlet.class
│      │      MemoUpdateServlet.class
│      │      MemoUpServlet.class
│      │      RegistrationServlet.class
│      │      UserServlet.class
│      │      WelcomeServlet.class
│      │
│      └─test
│              AccounntsDAOTest.class
│              LoginLogicTest.class
│              memosDAOTest.class
│
└─src
    └─main
        ├─java
        │  ├─dao
        │  │      AccountsDAO.java
        │  │      memosDAO.java
        │  │
        │  ├─memo
        │  ├─model
        │  │      Account.java
        │  │      Login.java
        │  │      LoginLogic.java
        │  │      memo.java
        │  │      memoLogic.java
        │  │      registration.java
        │  │
        │  ├─servlet
        │  │      LoginServlet.java
        │  │      MemoAddServlet.java
        │  │      MemoDelServlet.java
        │  │      MemoEdiServlet.java
        │  │      MemoMainServlet.java
        │  │      MemoRegistrationServlet.java
        │  │      MemoSearchServlet.java
        │  │      MemoSearchUpServlet.java
        │  │      MemoUpdateServlet.java
        │  │      MemoUpServlet.java
        │  │      RegistrationServlet.java
        │  │      UserServlet.java
        │  │      WelcomeServlet.java
        │  │
        │  └─test
        │          AccounntsDAOTest.java
        │          LoginLogicTest.java
        │          memosDAOTest.java
        │
        └─webapp
            ├─META-INF
            │      MANIFEST.MF
            │
            └─WEB-INF
                │  web.xml
                │
                ├─jsp
                │      login.jsp
                │      MemoEdit.jsp
                │      memoList.jsp
                │      MemoRegistration.jsp
                │      memoSearch.jsp
                │      menuAll.jsp
                │      user_register.jsp
                │      welcome.jsp
                │
                └─lib
                        h2-2.4.240.jar
                        jakarta.servlet.jsp.jstl-3.0.1.jar
    
