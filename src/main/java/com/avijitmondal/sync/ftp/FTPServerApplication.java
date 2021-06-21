
package com.avijitmondal.sync.ftp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FTPServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FTPServerApplication.class, args);
	}

	public void run(String... args) throws Exception {
		new SyncFTPServer().runFtpServer();
	}

}
