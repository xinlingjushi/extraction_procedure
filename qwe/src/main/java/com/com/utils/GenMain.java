package com.com.utils;  
  
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;  
/**
 *  
 * @time 20200413
 * @author jinyihao
 * @Description: 自动生成工具       注意：mbgConfiguration.xml里的location是本地oracle驱动的物理路径
 *
 */
public class GenMain {  
	
	@SuppressWarnings("unused")
	private static void zdscgj(String genCfg) throws UnsupportedEncodingException{
		 List<String> warnings = new ArrayList<String>();  
	        boolean overwrite = true;  
	        String   genpath= GenMain.class.getResource(genCfg).getFile();//会有转义空格
	        String path = URLDecoder.decode(genpath,"utf-8");//关键啊 ！把上面的转义空格去掉
	        File configFile = new File(path);  
	        ConfigurationParser cp = new ConfigurationParser(warnings);  
	        Configuration config = null;  
	        try {  
	            config = cp.parseConfiguration(configFile);  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } catch (XMLParserException e) {  
	            e.printStackTrace();  
	        }  
	        DefaultShellCallback callback = new DefaultShellCallback(overwrite);  
	        MyBatisGenerator myBatisGenerator = null;  
	        try {  
	            myBatisGenerator = new MyBatisGenerator(config, callback, warnings);  
	        } catch (InvalidConfigurationException e) {  
	            e.printStackTrace();  
	        }  
	        try {  
	            myBatisGenerator.generate(null);  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } catch (InterruptedException e) {  
	            e.printStackTrace();  
	        }  
	}
	
	//打包注掉
    public static void main(String[] args) throws UnsupportedEncodingException {  
    	zdscgj("/config/generator/mbgConfiguration1.xml");
    }  
}  