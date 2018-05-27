package com.arun.objectpool;

import java.sql.Connection;

public class TestConnectionPool {

	public static void main(String args[]) throws Exception {
		// Create the ConnectionPool:
		JDBCConnectionPool pool = new JDBCConnectionPool("org.hsqldb.jdbcDriver", "jdbc:hsqldb:mem:dataSource", "sa",
				"");

		// Get a connection:
		Connection con = pool.getObject();

		System.out.println(con.isClosed());

		// Return the connection:
		pool.releaseObject(con);

		System.out.println(con.isClosed());

	}
}
