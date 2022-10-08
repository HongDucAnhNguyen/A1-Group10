package sait.sos.application;

import sait.sos.manager.Manager;

/**
 * CPRG311 Assignment 1 - Group 10
 * @version 10-07-2022
 * @author Ryan Delorme
 * @author Hong (Jay) Nguyen
 * @author Refaat El-hajj
 * @author Simon Dumalski
 * @version 10-07-2022
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