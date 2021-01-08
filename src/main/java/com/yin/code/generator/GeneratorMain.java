package com.yin.code.generator;

import cn.hutool.core.util.StrUtil;
import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import org.h2.util.StringUtils;

import java.io.IOException;

/**
 * @author yin
 * @since 2021/1/3 22:44
 */
public class GeneratorMain {
    public static void main(String[] args) throws Exception {

        //设置模板位置
        GeneratorFacade gf = new GeneratorFacade();
        gf.getGenerator().addTemplateRootDir(GeneratorProperties.getProperty("templateRootDir"));
        gf.deleteOutRootDir();

        //配置表则，输出配置的表。如果未配置则输出所有表
        String tables = GeneratorProperties.getProperty("generatorTables");
        if (StrUtil.isNotBlank(tables)) {
            gf.generateByTable(tables.split(","));
        }else {
            gf.generateByAllTable();
        }
        //获取xml中配置输出文件位置
        Runtime.getRuntime().exec("cmd.exe /c start " + GeneratorProperties.getRequiredProperty("outRoot"));
    }
}
