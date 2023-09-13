package org.testngamazon;

public class PageManagerAmazon {
	private PomAmazonCreate pomAmazonCreate;
	private PomAmazonLogin pomAmazonLogin;
	private PomAmazonPageOne pomAmazonPageOne;
	private PomAmazonPageTwo pomAmazonPageTwo;
	
	public PomAmazonCreate getPomAmazonCreate() {
		if(pomAmazonCreate == null) {
			pomAmazonCreate = new PomAmazonCreate();
		}
		return pomAmazonCreate;
	}
	public PomAmazonLogin getPomAmazonLogin() {
		if(pomAmazonLogin == null) {
			pomAmazonLogin = new PomAmazonLogin();
		}
		return pomAmazonLogin;
	}
	public PomAmazonPageOne getPomAmazonPageOne() {
		if(pomAmazonPageOne == null) {
			pomAmazonPageOne = new PomAmazonPageOne();
		}
		return pomAmazonPageOne;
	}
	public PomAmazonPageTwo getPomAmazonPageTwo() {
		if(pomAmazonPageTwo == null) {
			pomAmazonPageTwo = new PomAmazonPageTwo();
		}
		return pomAmazonPageTwo;
	}
}
