package com.thinktech.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hls
 * @project springboot-scaffold
 * @date 2024/7/24 15:46:42
 */
public class CodeGenerator {

    /**
     * @Auther: hls
     * @Date: 2024/7/24 15:50
     * @Description: 代码生成
     */
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/batis?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true&rewriteBatchedStatements=true", "root", "root")
                // 全局配置
                .globalConfig((scanner, builder) -> builder.outputDir(System.getProperty("user.dir")+"/src/main/java")
                        .author(scanner.apply("请输入作者名称？")))
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名？")))
                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .addTablePrefix("t_")
                        .entityBuilder()
                        .enableLombok()
                        .enableRemoveIsPrefix()
                        .addTableFills(
                                new Column("create_time", FieldFill.INSERT)
                        )
                        .build())
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }
}
