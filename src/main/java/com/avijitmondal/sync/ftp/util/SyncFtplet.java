package com.avijitmondal.sync.ftp.util;

import java.io.IOException;

import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.ftplet.Ftplet;
import org.apache.ftpserver.ftplet.FtpletContext;
import org.apache.ftpserver.ftplet.FtpletResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncFtplet implements Ftplet {

	private static final Logger LOGGER = LoggerFactory.getLogger(SyncFtplet.class);

	public void init(FtpletContext ftpletContext) throws FtpException {
		LOGGER.debug("init");
		// System.out.println("Thread #" + Thread.currentThread().getId());
	}

	public void destroy() {
		LOGGER.debug("destroy");
		// System.out.println("Thread #" + Thread.currentThread().getId());
	}

	public FtpletResult beforeCommand(FtpSession session, FtpRequest request) throws FtpException, IOException {
		LOGGER.debug("beforeCommand ");
		// + session.getUserArgument() + " : " +
		// session.toString() + " | " + request.getArgument() + " : " +
		// request.getCommand() + " : " + request.getRequestLine());
		// System.out.println("Thread #" + Thread.currentThread().getId());

		// do something
		return FtpletResult.DEFAULT;
	}

	public FtpletResult afterCommand(FtpSession session, FtpRequest request, FtpReply reply)
			throws FtpException, IOException {
		// System.out.println("afterCommand " + session.getUserArgument() + " : " +
		// session.toString() + " | " + request.getArgument() + " : " +
		// request.getCommand() + " : " + request.getRequestLine() + " | " +
		// reply.getMessage() + " : " + reply.toString());
		// System.out.println("Thread #" + Thread.currentThread().getId());

		// do something
		return FtpletResult.DEFAULT;
	}

	public FtpletResult onConnect(FtpSession session) throws FtpException, IOException {
		LOGGER.debug("onConnect "); // + session.getUserArgument() + " : " +
		// session.toString());
		// System.out.println("Thread #" + Thread.currentThread().getId());

		// do something
		return FtpletResult.DEFAULT;
	}

	public FtpletResult onDisconnect(FtpSession session) throws FtpException, IOException {
		LOGGER.debug("onDisconnect "); // + session.getUserArgument() + " : " +
		// session.toString());
		// System.out.println("Thread #" + Thread.currentThread().getId());

		// do something
		return FtpletResult.DEFAULT;
	}

}