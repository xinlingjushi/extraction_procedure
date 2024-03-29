package com.com.comm;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author jinyihao
 */
public class ConstantEnum {
	
	private ConstantEnum(){
		
	}
	
	/**
	 * 文件标记
	 * GIS输电展现 GISSDZX("LineAsset"),GIS输电杆塔 GISSDGT("1");
	 * @author Windows10
	 *
	 */
	public static enum FILE_TAB{
		DEFAULT("DEFAULT"),GISSDZX("LineAsset"),GISSDGT("Polesite");
		private String val;
		private FILE_TAB(String val){
			this.val=val;
		}
		public String val(){
			return this.val;
		}
		public String toStr(){
			return String.valueOf(this.val);
		}
	}
	
	

	/**
	 * @Tiele  自定义异常枚举
	 * @Desciption DATABASE("1") 数据库异常
	 * @author Windows10
	 * @Time   2019.4.16
	 */
	public enum SqlExceptionCodeEnum{
		UQ_1("SDFASFASF_"),UQ_2("1");
		private String val;
		private SqlExceptionCodeEnum(String val){
			this.val=val;
		}
		public String val(){
			return this.val;
		}
		public String toStr(){
			return String.valueOf(this.val);
		}
	}
	
	
	public enum CustomExceptionEnum{
		DATABASE(SqlExceptionCodeEnum.UQ_1.val,"err1"),
		DATABASE1("2","err1");
		private String code;
		private String msg;
		private CustomExceptionEnum(String code,String msg){
			this.code=code;
			this.msg=msg;
		}
		public String getMsg(){
			return this.msg;
		}
		public String getMsg(String code){
			if(DATABASE.code.equals(code)){
				return DATABASE.msg;
			}else if(DATABASE1.code.equals(code)){
				return DATABASE.msg;
			}
			return "";
		}
    }
	public static  List<String>  getEnumValue(Class<?> clz,String method) throws Exception {
        // 1.得到枚举类对象
       
        // 2.得到所有枚举常量
        Object[] objects = clz.getEnumConstants();
        Method getCode = clz.getMethod(method);
        List<String> list = new ArrayList<String>(objects.length);
        for (Object obj : objects){
        // 3.调用对应方法，得到枚举常量中字段的值
        	Object val = getCode.invoke(obj);
        	if(null!=val &&StringUtils.isNotBlank(String.valueOf(val))){
        		list.add(String.valueOf(val));
        	}
        }
        return list;
    }
}
