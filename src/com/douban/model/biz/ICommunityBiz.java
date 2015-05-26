/**
 * <p>Title: ICommunityBiz.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: </p>
 * @author 马金健
 * @date May 26, 2015
 * @version 
 */
package com.douban.model.biz;

import java.util.List;

import com.douban.model.entity.po.Community;

/**
 * @author 马金健
 *
 */
public interface ICommunityBiz {
	
	/**
	 * <p>Project: DouBanBook</p>
	 * <p>Package: com.douban.model.biz</p>
	 * <p>Title: findAll</p>
	 * <p>Description: </p>
	 * <p>@param </p>
	 * <p>@return List<Community></p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date May 26, 2015 5:00:45 PM
	 * @version 
	 */
	public List<Community> findAll();
	
	/**
	 * <p>Project: DouBanBook</p>
	 * <p>Package: com.douban.model.biz</p>
	 * <p>Title: add</p>
	 * <p>Description: </p>
	 * <p>@param </p>
	 * <p>@return boolean</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date May 26, 2015 5:00:41 PM
	 * @version 
	 */
	public boolean add(final Community community);
	
	/**
	 * <p>Project: DouBanBook</p>
	 * <p>Package: com.douban.model.biz</p>
	 * <p>Title: findById</p>
	 * <p>Description: </p>
	 * <p>@param </p>
	 * <p>@return Community</p>
	 * @author 马金健
	 * @since JDK 1.7.55 
	 * @date May 26, 2015 5:01:12 PM
	 * @version 
	 */
	public Community findById(final long communityid);
}