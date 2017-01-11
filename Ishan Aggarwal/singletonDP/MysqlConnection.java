package com.sapient.singleton;

public enum MysqlConnection {
	INSTANCE;
	public static MysqlConnection getInstance() {
		return INSTANCE;
	}
}