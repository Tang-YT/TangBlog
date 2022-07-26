package com.tyt;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

/**
 * @ClassName Generator
 * @Author 划水艺术家
 * @Date 2022/7/22 10:37
 * @Version 1.0
 **/
public class Generator {
    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.dir")); // D:\Idea_Projects\springBoot_study

        // 获取代码生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mybatis_plus_db?serverTimezone=UTC");
        dataSourceConfig.setPassword("tangyitao273169.");
        dataSourceConfig.setUsername("root");
        autoGenerator.setDataSource(dataSourceConfig);

        // 设置全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/springBoot_mybatisPlus/src/main/java"); // 设置输出位置
        globalConfig.setOpen(false); // 设置生成完毕后是否打开生成代码的目录
        globalConfig.setAuthor("划水艺术家"); // 设置作者
        globalConfig.setFileOverride(true); // 设置是否覆盖原始生成的文件
        globalConfig.setMapperName("%sDao"); // 设置数据层接口名， %s 为占位符，指代模块名称
        globalConfig.setIdType(IdType.ASSIGN_ID); // 设置 Id 生成策略
        autoGenerator.setGlobalConfig(globalConfig);


        // 设置包名相关配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.tyt"); // 设置生成的包名，与代码所在位置不冲突，二者叠加组成完整路径
        packageConfig.setEntity("domain"); // 设置 实体类包名
        packageConfig.setMapper("dao"); // 设置数据层包名
        autoGenerator.setPackageInfo(packageConfig);

        // 策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
//        strategyConfig.setInclude(""); // 设置当前参与生成的表名，参数为可变参数
        strategyConfig.setTablePrefix("tbl_"); // 设置数据库表的前缀名称，模块名 = 数据库表名 - 前缀名 例如 User = tbl_user - tbl
        strategyConfig.setRestControllerStyle(true); // 设置是否启用Rest风格
//        strategyConfig.setVersionFieldName("version"); // 设置乐观锁字段名
//        strategyConfig.setLogicDeleteFieldName("deleted"); // 设置逻辑删除字段名
        strategyConfig.setEntityLombokModel(true); // 是否启用 lombok
        autoGenerator.setStrategy(strategyConfig);


        autoGenerator.execute();
    }
}
