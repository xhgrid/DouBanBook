/**
 * <p>Title: CookieUtil.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: </p>
 * @author 马金健
 * @date May 21, 2015
 * @version 
 */
package com.douban.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.douban.model.entity.po.AdminSession;
import com.douban.model.entity.po.Session;

/**
 * @author 马金健
 *
 */
public class CookieUtil {

	private static final String USER_COOKIE = "user.cookie";
	private static final String ADMIN_COOKIE = "admin.cookie";
	
	
	/**
	 * <p>Project: DouBanBook</p>
	 * <p>Package: com.douban.common.util</p>
	 * <p>Title: </p>
	 * <p>Description: </p>
	 * <p>@Param </p>
	 * <p>@return </p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date May 21, 2015 6:43:11 PM
	 * @version 
	 */
	public CookieUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * <p>Project: DouBanBook</p>
	 * <p>Package: com.douban.common.util</p>
	 * <p>Title: addCookie</p>
	 * <p>Description: </p>
	 * <p>@param </p>
	 * <p>@return Cookie</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date May 21, 2015 6:47:51 PM
	 * @version 
	 */
	public static Cookie addCookie(long userid, long sessionid){
		String str = EncodeBase64.encodeBase64(userid+","+sessionid);
		Cookie cookie = new Cookie(USER_COOKIE, str);
		return cookie;
	}
	
	/**
	 * <p>Project: DouBanBook</p>
	 * <p>Package: com.douban.common.util</p>
	 * <p>Title: addAdminCookie</p>
	 * <p>Description: </p>
	 * <p>@param </p>
	 * <p>@return Cookie</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date May 26, 2015 8:55:04 PM
	 * @version 
	 */
	public static Cookie addAdminCookie(long adminid, long sessionid){
		String str = EncodeBase64.encodeBase64(adminid+","+sessionid);
		Cookie cookie = new Cookie(ADMIN_COOKIE, str);
		return cookie;
	}
	
	/**
	 * <p>Project: DouBanBook</p>
	 * <p>Package: com.douban.common.util</p>
	 * <p>Title: getCookie</p>
	 * <p>Description: </p>
	 * <p>@param </p>
	 * <p>@return boolean</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date May 21, 2015 6:48:36 PM
	 * @version 
	 */
	public static Session getCookie(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		System.out.println("cookies:"+cookies);
		if(cookies != null){
			for (Cookie cookie : cookies) {
				System.out.println("cookie:"+cookie.getName());
				if(CookieUtil.USER_COOKIE.equals(cookie.getName())){
					String value = cookie.getValue();
					if(StringUtils.isNotBlank(value)){
						value = EncodeBase64.decodeBase64(value);
						String[] split = value.split(",");
						long userid = Long.parseLong(split[0]);
						long sessionid = Long.parseLong(split[1]);
						Session session = new Session();
						session.setSessionid(sessionid);
						session.setUserid(userid);
						return session;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * <p>Project: DouBanBook</p>
	 * <p>Package: com.douban.common.util</p>
	 * <p>Title: getAdminCookie</p>
	 * <p>Description: </p>
	 * <p>@param </p>
	 * <p>@return AdminSession</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date May 26, 2015 9:12:24 PM
	 * @version 
	 */
	public static AdminSession getAdminCookie(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		System.out.println("cookies:"+cookies);
		if(cookies != null){
			for (Cookie cookie : cookies) {
				System.out.println("cookie:"+cookie.getName());
				if(CookieUtil.ADMIN_COOKIE.equals(cookie.getName())){
					String value = cookie.getValue();
					if(StringUtils.isNotBlank(value)){
						value = EncodeBase64.decodeBase64(value);
						String[] split = value.split(",");
						long adminid = Long.parseLong(split[0]);
						long sessionid = Long.parseLong(split[1]);
						AdminSession session = new AdminSession();
						session.setSessionid(sessionid);
						session.setAdminid(adminid);
						return session;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * <p>Project: DouBanBook</p>
	 * <p>Package: com.douban.common.util</p>
	 * <p>Title: deleteAdminCookie</p>
	 * <p>Description: </p>
	 * <p>@param </p>
	 * <p>@return Cookie</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date May 26, 2015 9:12:20 PM
	 * @version 
	 */
	public static Cookie deleteAdminCookie(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		System.out.println(cookies);
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(CookieUtil.ADMIN_COOKIE.equals(cookie.getName())){
					cookie.setValue("");
					cookie.setMaxAge(0);
					return cookie;
				}
			}
		}
		return null;
	}
	
	/**
	 * <p>Project: DouBanBook</p>
	 * <p>Package: com.douban.common.util</p>
	 * <p>Title: deleteCookie</p>
	 * <p>Description: </p>
	 * <p>@param </p>
	 * <p>@return Cookie</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date May 21, 2015 7:01:11 PM
	 * @version 
	 */
	public static Cookie deleteCookie(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		System.out.println(cookies);
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(CookieUtil.USER_COOKIE.equals(cookie.getName())){
					cookie.setValue("");
					cookie.setMaxAge(0);
					return cookie;
				}
			}
		}
		return null;
	}

}
