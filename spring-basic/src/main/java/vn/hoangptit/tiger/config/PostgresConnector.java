package vn.hoangptit.tiger.config;

public class PostgresConnector extends DBConnector {
    @Override
    public void connect() {
        System.out.println("Đã kết nối tới Mysql với url " + this.getUrl());
    }
}
