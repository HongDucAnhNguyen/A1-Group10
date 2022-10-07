package sait.sos.application;

import sait.sos.manager.Manager;

/**
 * Application driver.
 */
public class AppDriver {
	
	/**
	 * Entry point to application.
	 * @param args Command line arguments provided when the jar file is run
	 */
    public static void main(String[] args) {
    	new Manager(args);
    }
}