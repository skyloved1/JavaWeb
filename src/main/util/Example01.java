package main.util;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Example01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ExecutionException, InterruptedException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&a0llowPublicKeyRetrieval=true", "root", "123456");
        Statement s = conn.createStatement();
        var res = s.executeQuery("select * from users");
        while (res.next()) {
            for (int i = 0; i < res.getMetaData().getColumnCount(); i++) {
                System.out.print(res.getString(i + 1) + "\t\t");
            }
            System.out.println();
        }
        //prepareStatement
        String preSql= "insert into users set name=?,password=?,email=?,birthday=?";
        var ps = conn.prepareStatement(preSql);
        for(int i = 0; i < 10; i++) {
            ps.setString(1, "user" + i);
            ps.setString(2, "pass" + i);
            ps.setString(3, "user" + i + "@example.com");
            ps.setDate(4, new Date(System.currentTimeMillis()));
            ps.addBatch();
        }
        ps.executeBatch();
        //delete
        String delSql = "delete from users where name=?";
        var delPs = conn.prepareStatement(delSql);
        for (int i = 0; i < 10; i++) {
            delPs.setString(1, "user" + i);
            delPs.addBatch();
        }
        delPs.executeBatch();


        if (res != null) {
            res.close();
        }
        if (s != null) {
            s.close();
        }
        if (conn != null) {
            conn.close();
        }

    }
}
