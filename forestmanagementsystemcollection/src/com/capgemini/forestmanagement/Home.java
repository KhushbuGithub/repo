package com.capgemini.forestmanagement;


import com.capgemini.forestmanagement.exception.ForestrymanagementException;

public class Home {

	
	public static void home() {
		
	
		try {

			HomePage.homepage();

		} catch (Exception e) {

			try {

				throw new ForestrymanagementException("Please Enter Valid Input!!!");

			} catch (ForestrymanagementException e1) {

				try {
					HomePage.homepage();
				} catch (Exception e2) {
					try {
						throw new ForestrymanagementException("Please Enter Valid Input!!!");

					} catch (ForestrymanagementException e3) {
						try {
							HomePage.homepage();
						} catch (Exception e4) {
							try {
								throw new ForestrymanagementException("Please Enter Valid Input!!!");

							} catch (ForestrymanagementException e5) {
								HomePage.homepage();
								
								// e3.printStackTrace();
							}
							
							// e3.printStackTrace();
						}
					}
					
					// e1.printStackTrace();
				}
			}

		}

	}
}
