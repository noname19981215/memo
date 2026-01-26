#1
FROM tomcat:10.1-jdk21

# 2. 作業ディレクトリ
WORKDIR /app

# 3. ファイルのコピー

COPY memo/src/main/java ./src
COPY memo/src/main/webapp ./webapp



# 4. コンパイル準備
RUN mkdir -p webapp/WEB-INF/classes
RUN find src -name "*.java" > sources.txt

# 5. コンパイル実行
RUN javac -encoding UTF-8 -d webapp/WEB-INF/classes \
    -cp "/usr/local/tomcat/lib/servlet-api.jar:webapp/WEB-INF/lib/*" \
    @sources.txt

# 6. アプリ配置
RUN rm -rf /usr/local/tomcat/webapps/ROOT
RUN mv webapp /usr/local/tomcat/webapps/ROOT

# 7. Render用ポート設定
ENV PORT=8080
EXPOSE 8080

# 8. 起動
CMD ["catalina.sh", "run"]