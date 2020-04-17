package com.kind1ess.newsspider.repository.impl;

import com.kind1ess.newsspider.entity.News;
import com.kind1ess.newsspider.repository.CustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CustomRepositoryImpl implements CustomRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public News findByUrl(String url) {

        String sql = "select * from tb_news where url=?";

        RowMapper<News> rowMapper = new BeanPropertyRowMapper<>(News.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,url);
    }
}
