package com.dlutdreamers.drivingtest.log;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.mindpipe.android.logging.log4j.LogConfigurator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Environment;
import android.provider.MediaStore.Files;

public class MyLogger extends Activity  {

	static {
		LogConfigurator logConfigurator = new LogConfigurator();
		String logDirPath =null;
		String state=Environment.getExternalStorageState();
		if(state.equals(Environment.MEDIA_MOUNTED))
		{
			logDirPath= Environment.getExternalStorageDirectory()
					+ File.separator + "MyApp" + File.separator + "logs"
				+ File.separator;
		}
		
		else 
		{
			logDirPath= Environment.getDataDirectory()
					+ File.separator + "MyApp" + File.separator + "logs"
				+ File.separator;
		}
		
		
		File logDir = new File(logDirPath);
			try {
				if (!logDir.exists()) {
				logDir.mkdirs();
				}
				File logFile = new File(logDir + "log.txt");
				if (!logFile.exists()) {
					boolean isCreateSuccess = logFile.createNewFile();
					System.out.println(isCreateSuccess);
				}

				} catch (IOException e) {
				e.printStackTrace();
			}
		logConfigurator.setFileName(logDir + "log.txt");

		logConfigurator.setRootLevel(Level.DEBUG);

		logConfigurator.setLevel("org.apache", Level.ERROR);

		logConfigurator.setFilePattern("%d %-5p [%c{2}]-[%L] %m%n");

		logConfigurator.setMaxFileSize(1024 * 1024 * 5);

		logConfigurator.setImmediateFlush(true);

		logConfigurator.configure();

	}

	public static Logger getLogger(Class cls) {
		Logger log = Logger.getLogger(cls);
		return log;
	}

}
