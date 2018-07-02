package com.common.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class Validate {

	public static String getIPAddress(HttpServletRequest request) {
	    String ip = null;

	    //X-Forwarded-For：Squid 服务代理
	    String ipAddresses = request.getHeader("X-Forwarded-For");

	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //Proxy-Client-IP：apache 服务代理
	        ipAddresses = request.getHeader("Proxy-Client-IP");
	    }

	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //WL-Proxy-Client-IP：weblogic 服务代理
	        ipAddresses = request.getHeader("WL-Proxy-Client-IP");
	    }

	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //HTTP_CLIENT_IP：有些代理服务器
	        ipAddresses = request.getHeader("HTTP_CLIENT_IP");
	    }

	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //X-Real-IP：nginx服务代理
	        ipAddresses = request.getHeader("X-Real-IP");
	    }

	    //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
	    if (ipAddresses != null && ipAddresses.length() != 0) {
	        ip = ipAddresses.split(",")[0];
	    }

	    //还是不能获取到，最后再通过request.getRemoteAddr();获取
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        ip = request.getRemoteAddr();
	    }
	    return ip;
	}
	static public boolean checkemail(String email){
		String pattern  ="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		boolean isMatch = Pattern.matches(pattern, email);
		return isMatch;
	}
	static public boolean isnull(String string){
		if (string==""||string==null||"".equals(string)) {
			return true;
		}
		return false;
	}
	static public boolean max(String string,int max){
		if(string.length()>max){
			return true;
		}
		return false;
	}
	static public boolean min(String string,int min){
		if(string.length()<min){
			return true;
		}
		return false;
	}
	public static boolean checkqq(String qq){
    	String pattern= "^[1-9][0-9]{4,11}$";
		boolean isMatch = Pattern.matches(pattern, qq);
		return isMatch;
	}
	
	public static boolean checkeqs(String password ,String repassword){
		if(password.equals(repassword))return true;
		return false;
	}
	static public String getStringTime(){
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStamp=time.format(new java.util.Date());
		return dateStamp;
	}
	 public static String md5Password(String password) {

	        try {
	            // 得到一个信息摘要器
	            MessageDigest digest = MessageDigest.getInstance("md5");
	            byte[] result = digest.digest(password.getBytes());
	            StringBuffer buffer = new StringBuffer();
	            // 把每一个byte 做一个与运算 0xff;
	            for (byte b : result) {
	                // 与运算
	                int number = b & 0xff;// 加盐
	                String str = Integer.toHexString(number);
	                if (str.length() == 1) {
	                    buffer.append("0");
	                }
	                buffer.append(str);
	            }

	            // 标准的md5加密后的结果
	            return buffer.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            return "";
	        }

	    }
}
