package org.testngadactin;

public class PageManagerAdactin {
	private PomAdactinLogin pomAdactinLogin;
	private PomAdactinPageOne pomAdactinPageOne;
	private PomAdactinPageTwo pomAdactinPageTwo;
	private PomAdactinPageThree pomAdactinPageThree;
	private PomAdactinPageFour pomAdactinPageFour;
	
	public PomAdactinLogin getPomAdactinLogin() {
		if(pomAdactinLogin == null) {
			pomAdactinLogin = new PomAdactinLogin();
		}
		return pomAdactinLogin;
	}
	public PomAdactinPageOne getPomAdactinPageOne() {
		if(pomAdactinPageOne == null) {
			pomAdactinPageOne = new PomAdactinPageOne();
		}
		return pomAdactinPageOne;
	}
	public PomAdactinPageTwo getPomAdactinPageTwo() {
		if(pomAdactinPageTwo == null) {
			pomAdactinPageTwo = new PomAdactinPageTwo();
		}
		return pomAdactinPageTwo;
	}
	public PomAdactinPageThree getPomAdactinPageThree() {
		if(pomAdactinPageThree == null) {
			pomAdactinPageThree = new PomAdactinPageThree();
		}
		return pomAdactinPageThree;
	}
	public PomAdactinPageFour getPomAdactinPageFour() {
		if(pomAdactinPageFour == null) {
			pomAdactinPageFour = new PomAdactinPageFour();
		}
		return pomAdactinPageFour;
	}

}
