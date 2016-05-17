package com.robert.blend.thinking.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCHelper {

	private volatile static JDBCHelper jdbcHelper = null;

	private Connection conn = null;

	private JDBCHelper() {
	}

	public static JDBCHelper newInstance() {
		if (null == jdbcHelper)
			synchronized (JDBCHelper.class) {
				if (null == jdbcHelper)
					jdbcHelper = new JDBCHelper();
			}
		return jdbcHelper;
	}

	public Connection getConnection() {
		try {

			if (null == conn) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://10.203.138.231/test", "root", "root");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConnection() {
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public <T> T getEntityById(String sql, Class clazz) {
		T entity = null;
		PreparedStatement preSta = null;
		ResultSet rs = null;
		try {
			preSta = getConnection().prepareStatement(sql);
			rs = preSta.executeQuery();
			while (rs.next()) {
				entity = (T) clazz.newInstance();
				for (Field f : clazz.getDeclaredFields()) {
					Method method = clazz.getMethod("set"
							+ f.getName().substring(0, 1).toUpperCase()
							+ f.getName().substring(1), f.getType());
					method.invoke(entity, rs.getObject(f.getName()));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preSta != null) {
				try {
					preSta.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return entity;
	}

	public void update(String sql) {
		PreparedStatement preSta = null;
		try {
			preSta = getConnection().prepareStatement(sql);
			preSta.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != preSta) {
				try {
					preSta.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
