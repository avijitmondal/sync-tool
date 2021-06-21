package com.avijitmondal.sync.ftp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avijitmondal.sync.ftp.data.Constants;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.Ftplet;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.avijitmondal.sync.ftp.util.SyncFtplet;
import com.avijitmondal.sync.ftp.util.SyncPasswordEncryptor;

public class SyncFTPServer {

	private static final Logger LOGGER = LoggerFactory.getLogger(SyncFTPServer.class);

	public void runFtpServer() {
		LOGGER.debug("main");
		FtpServerFactory serverFactory = new FtpServerFactory();
		ListenerFactory factory = new ListenerFactory();
		factory.setPort(Constants.PORT);
		serverFactory.addListener("default", factory.createListener());
		PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
//		userManagerFactory.setFile(new File("users.properties"));

		userManagerFactory.setPasswordEncryptor(new SyncPasswordEncryptor());

		BaseUser user = new BaseUser();
		user.setName("test");
		user.setPassword("test");
		user.setHomeDirectory("C:\\workspace\\ftp");
		List<Authority> authorities = new ArrayList<Authority>();
		authorities.add(new WritePermission());
		user.setAuthorities(authorities);
		UserManager um = userManagerFactory.createUserManager();
		try {
			um.save(user);
		} catch (FtpException e1) {
			e1.printStackTrace();
		}
		serverFactory.setUserManager(um);
		Map<String, Ftplet> m = new HashMap<String, Ftplet>();
		m.put("miaFtplet", new SyncFtplet());

		serverFactory.setFtplets(m);
		Map<String, Ftplet> ftplets = serverFactory.getFtplets();
		LOGGER.debug("Size: " + ftplets.size());
		LOGGER.debug("Thread #" + Thread.currentThread().getId());
		LOGGER.debug(ftplets.toString());
		FtpServer server = serverFactory.createServer();
		try {
			server.start();
		} catch (FtpException ex) {
			ex.printStackTrace();
		}
	}
}
