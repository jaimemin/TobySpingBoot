package com.tistory.jaimemin.helloboot;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
public class HelloRepositoryJdbc implements HelloRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Hello findHello(String name) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM hello WHERE name = '" + name + "'",
                    (rs, rowNum) -> new Hello(
                            rs.getString("name"), rs.getInt("count")
                    ));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void increaseCount(String name) {
        Hello hello = findHello(name);

        if (hello == null) {
            jdbcTemplate.update("INSERT INTO hello VALUES(?, ?)"
                    , name
                    , 1);
        } else {
            jdbcTemplate.update("UPDATE hello SET count = ? WHERE name = ?"
                    , hello.getCount() + 1
                    , name);
        }
    }
}
