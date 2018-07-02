package com.common.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class Validate {

	public static String getIPAddress(HttpServletRequest request) {
	    String ip = null;

	    //X-Forwarded-For��Squid �������
	    String ipAddresses = request.getHeader("X-Forwarded-For");

	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //Proxy-Client-IP��apache �������
	        ipAddresses = request.getHeader("Proxy-Client-IP");
	    }

	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //WL-Proxy-Client-IP��weblogic �������
	        ipAddresses = request.getHeader("WL-Proxy-Client-IP");
	    }

	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //HTTP_CLIENT_IP����Щ���������
	        ipAddresses = request.getHeader("HTTP_CLIENT_IP");
	    }

	    if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
	        //X-Real-IP��nginx�������
	        ipAddresses = request.getHeader("X-Real-IP");
	    }

	    //��Щ����ͨ����������ô��ȡ����ip�ͻ��ж����һ�㶼��ͨ�����ţ�,���ָ�������ҵ�һ��ipΪ�ͻ��˵���ʵIP
	    if (ipAddresses != null && ipAddresses.length() != 0) {
	        ip = ipAddresses.split(",")[0];
	    }

	    //���ǲ��ܻ�ȡ���������ͨ��request.getRemoteAddr();��ȡ
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
	            // �õ�һ����ϢժҪ��
	            MessageDigest digest = MessageDigest.getInstance("md5");
	            byte[] result = digest.digest(password.getBytes());
	            StringBuffer buffer = new StringBuffer();
	            // ��ÿһ��byte ��һ�������� 0xff;
	            for (byte b : result) {
	                // ������
	                int number = b & 0xff;// ����
	                String str = Integer.toHexString(number);
	                if (str.length() == 1) {
	                    buffer.append("0");
	                }
	                buffer.append(str);
	            }

	            // ��׼��md5���ܺ�Ľ��
	            return buffer.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            return "";
	        }

	    }
}
