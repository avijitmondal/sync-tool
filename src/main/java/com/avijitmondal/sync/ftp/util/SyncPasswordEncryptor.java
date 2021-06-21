package com.avijitmondal.sync.ftp.util;

import org.apache.ftpserver.usermanager.PasswordEncryptor;

public class SyncPasswordEncryptor implements PasswordEncryptor {

	public String encrypt(String password) {
		return password;
	}

	public boolean matches(String passwordToCheck, String storedPassword) {
		return passwordToCheck.equals(storedPassword);
	}

}
