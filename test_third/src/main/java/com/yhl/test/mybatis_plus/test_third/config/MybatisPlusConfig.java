package com.yhl.test.mybatis_plus.test_third.config;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.yhl.test.mybatis_plus.test_third.injects.MySqlInjector;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨贺龙
 * @name MybatisPlusConfig
 * @create 2019-11-15 16:09
 * @description:
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页插件
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor() {
        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
        List<ISqlParser> list = new ArrayList<>();
        list.add(new BlockAttackSqlParser());
        sqlExplainInterceptor.setSqlParserList(list);
        return sqlExplainInterceptor;
    }

    @Bean
    public MySqlInjector mySqlInjector() {
        return new MySqlInjector();
    }
}
