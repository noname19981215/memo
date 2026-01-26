FROM tomcat:10.1-jdk21

# 2. 作業場所の設定
WORKDIR /app

# 3. ファイルのコピー
COPY src ./src
COPY webapp ./webapp

# 4. コンパイル
RUN mkdir -p webapp/WEB-INF/classes
RUN find src -name "*.java" > sources.txt

# -encoding UTF
RUN javac -encoding UTF-8 -d webapp/WEB-INF/classes \
    -cp /usr/local/tomcat/lib/servlet-api.jar \
    @sources.txt

# 5. 配置
RUN rm -rf /usr/local/tomcat/webapps/ROOT
RUN mv webapp /usr/local/tomcat/webapps/ROOT

# 6. ポート設定
ENV PORT=8080
EXPOSE 8080

# 7. 起動コマンド
CMD ["catalina.sh", "run"]