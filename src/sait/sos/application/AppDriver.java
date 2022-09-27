package sait.sos.application;

import java.io.FileNotFoundException;

import sait.sos.manager.SortManager;

/**
 * Application driver.
 */
public class AppDriver {
	
	/**
	 * Entry point to application.
	 * @param args
	 */
    public static void main(String[] args) {
    	try {
			new SortManager();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
}