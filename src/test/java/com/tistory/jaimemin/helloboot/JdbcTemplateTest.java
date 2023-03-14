package com.tistory.jaimemin.helloboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.*;

@JdbcTest
public class JdbcTemplateTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void insertAndQuery() {
        jdbcTemplate.update("INSERT INTO hello values(?, ?)", "Toby", 3);
        jdbcTemplate.update("INSERT INTO hello values(?, ?)", "Spring", 1);

        Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM hello", Long.class);
        assertThat(count).isEqualTo(2);
    }

    @Test
    void insertAndQuery2() {
        jdbcTemplate.update("INSERT INTO hello values(?, ?)", "Toby", 3);
        jdbcTemplate.update("INSERT INTO hello values(?, ?)", "Spring", 1);

        Long count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM hello", Long.class);
        assertThat(count).isEqualTo(2);
    }
}
