package com.scrolltest.api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static ConfigManager manger;
	private static final Properties prop = new Properties();

	private ConfigManager() throws IOException {
		InputStream inputstream = new FileInputStream("./resource/config.properties");
		prop.load(inputstream);
	}

	public static ConfigManager getinstance() {
		if (manger == null) {
			synchronized (ConfigManager.class) {
				try {
					manger = new ConfigManager();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return manger;
	}
	public String getString(String key) {
		return System.getProperty(key, prop.getProperty(key));
	}
}
