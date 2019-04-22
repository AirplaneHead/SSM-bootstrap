package com.system.generator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.toolkit.StringUtils;

/**
 * <p>
 * 代码生成器演示
 * </p>
 * 
 * Created by Administrator on 2017/3/13 0013.
 */
public class MysqlGenerator {

	/**
	 * <p>
	 * MySQL 生成演示
	 * </p>
	 */
	public static void main(String[] args) {
		/* 获取 JDBC 配置文件 */
		Properties props = getProperties();
		AutoGenerator mpg = new AutoGenerator();

		String outputDir = "D:/git_coding/generator/code";
		final String viewOutputDir = outputDir + "/view/";
		
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir(outputDir);
		gc.setFileOverride(true);
		gc.setActiveRecord(true);// 开启 activeRecord 模式
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(false);// XML columList
		gc.setAuthor("yx");

		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		gc.setMapperName("%sMapper");
		gc.setXmlName("%sMapper");
		gc.setServiceName("I%sService");
		gc.setServiceImplName("%sServiceImpl");
		gc.setControllerName("%sController");
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setTypeConvert(new MySqlTypeConvert());
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername(props.getProperty("mysql.user"));
		dsc.setPassword(props.getProperty("mysql.password"));
		dsc.setUrl(props.getProperty("mysql.url"));
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.remove_prefix_and_camel);// 表名生成策略
		// 字段名生成策略
		strategy.setFieldNaming(NamingStrategy.underline_to_camel);
		mpg.setStrategy(strategy);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setModuleName(null);  //所属模块
		pc.setParent("com.system"); // 自定义包路径
		pc.setController("controller"); // 这里是控制器包名，默认 web
		pc.setEntity("model");
		pc.setXml("sqlMapperXml");
		mpg.setPackageInfo(pc);

		// 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {}
		};
		 //生成的模版路径，不存在时需要先新建
//		File viewDir = new File(viewOutputDir);
//		if (!viewDir.exists()) {
//			viewDir.mkdirs();
//		}
//		List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
//		focList.add(new FileOutConfig("/template/add.jsp.vm") {
//			@Override
//			public String outputFile(TableInfo tableInfo) {
//				return getGeneratorViewPath(viewOutputDir, tableInfo, "Add.jsp");
//			}
//		});
//		focList.add(new FileOutConfig("/template/edit.jsp.vm") {
//			@Override
//			public String outputFile(TableInfo tableInfo) {
//				return getGeneratorViewPath(viewOutputDir, tableInfo, "Edit.jsp");
//			}
//		});
//		focList.add(new FileOutConfig("/template/list.jsp.vm") {
//			@Override
//			public String outputFile(TableInfo tableInfo) {
//				return getGeneratorViewPath(viewOutputDir, tableInfo, "List.jsp");
//			}
//		});
//		cfg.setFileOutConfigList(focList);
//		mpg.setCfg(cfg);

		// 执行生成
		mpg.execute();
	}

	/**
	 * 获取配置文件
	 *
	 * @return 配置Props
	 */
	private static Properties getProperties() {
		// 读取配置文件
		Resource resource = new ClassPathResource("/config/jdbc.properties");
		Properties props = new Properties();
		try {
			props = PropertiesLoaderUtils.loadProperties(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props;
	}
	
	/**
	 * 页面生成的文件名
	 */
	private static String getGeneratorViewPath(String viewOutputDir, TableInfo tableInfo, String suffixPath) {
		String name = StringUtils.firstToLowerCase(tableInfo.getEntityName());
		String path = viewOutputDir + "/" + name + "/" + name + suffixPath;
		File viewDir = new File(path).getParentFile();
		if (!viewDir.exists()) {
			viewDir.mkdirs();
		}
		return path;
	}
}