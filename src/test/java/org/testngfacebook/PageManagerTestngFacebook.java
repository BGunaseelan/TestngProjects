package org.testngfacebook;

public class PageManagerTestngFacebook {
	private PomFacebookLogin pomFacebookLogin;
	private PomFacebookErrors pomFacebookErrors;
	
	public PomFacebookLogin getPomFacebookLogin() {
		if(pomFacebookLogin == null) {
			pomFacebookLogin = new PomFacebookLogin();
		}
		return pomFacebookLogin;
	}
	public PomFacebookErrors getPomFacebookErrors() {
		if(pomFacebookErrors == null) {
			pomFacebookErrors = new PomFacebookErrors();
		}
		return pomFacebookErrors;
	}

}
