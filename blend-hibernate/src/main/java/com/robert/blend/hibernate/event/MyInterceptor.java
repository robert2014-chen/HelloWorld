package com.robert.blend.hibernate.event;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

/**
 * <p>
 * Hibernate的事件框架由两个部分组成： <br/>
 * <ul>
 * <li>拦截器机制：对于特定动作拦截，回调应用中的特定动作</li>
 * <li>事件系统：重写hibernate的事件监听器</li>
 * </ul>
 * </p>
 * <p>
 * 使用事件拦截器的开发步骤：<br/>
 * <ol>
 * <li>定义实现Interceptor接口的拦截器类</li>
 * <li>通过Session启用拦截，或者通过Configuration启用全局拦截器</li>
 * </ol>
 * </p>
 * 
 * @author CHEN
 *
 */
public class MyInterceptor extends EmptyInterceptor {

	private int updates;
	
	private int creates;
	
	/**
	 * 当删除实体时，此方法会被调用
	 */
	@Override
	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
	}
}