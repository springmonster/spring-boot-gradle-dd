package com.example.springbootgradledd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbc;

    @RequestMapping("/get")
    public List<String> insertData() {
        List<String> list = new ArrayList<>();

        jdbc.execute("select * from novel_book", new PreparedStatementCallback() {

            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(rs.getString("book_name"));
                }
                return null;
            }
        });

        try {

        }catch (Exception e){
            e.getMessage();
        }
        return list;
    }
}