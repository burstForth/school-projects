package com.cn.hnny.util;

import java.util.regex.Pattern;

public class RemoveHTMLUtil {

	public static String Html2Text(String htmlStr){

    	//鍚玥tml鏍囩鐨勫瓧绗︿覆	     
    	String textStr ="";	     
    	java.util.regex.Pattern p_script;
    	java.util.regex.Matcher m_script;
    	java.util.regex.Pattern p_style;
    	java.util.regex.Matcher m_style;
    	java.util.regex.Pattern p_html;
    	java.util.regex.Matcher m_html;
    	try{	          
    		String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; 
    		//瀹氫箟script鐨勬鍒欒〃杈惧紡{鎴�<script[^>]*?>[\\s\\S]*?<\\/script> }
    		String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
    		//瀹氫箟style鐨勬鍒欒〃杈惧紡{鎴�<style[^>]*?>[\\s\\S]*?<\\/style> }
    		String regEx_html = "<[^>]+>"; //瀹氫箟HTML鏍囩鐨勬鍒欒〃杈惧紡 
    		p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
    		m_script = p_script.matcher(htmlStr);
    		htmlStr = m_script.replaceAll("");
    		//杩囨护script鏍囩
    		p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
    		m_style = p_style.matcher(htmlStr);
    		htmlStr = m_style.replaceAll("");
    		//杩囨护style鏍囩
    		p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
    		m_html = p_html.matcher(htmlStr);
    		htmlStr = m_html.replaceAll("");
    		//杩囨护html鏍囩
    		htmlStr = htmlStr.replace("  ", "");
    		htmlStr = htmlStr.replace("\n", "");
    		htmlStr = htmlStr.replace("\t", "");
    		textStr = htmlStr.trim();
    		textStr = htmlStr;
    		}catch(Exception e){ 
    			
    		}	     
    	   return textStr;
    	   //杩斿洖鏂囨湰瀛楃涓�	 
    	}
}
