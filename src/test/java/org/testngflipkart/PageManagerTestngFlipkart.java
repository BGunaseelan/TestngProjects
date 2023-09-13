package org.testngflipkart;

public class PageManagerTestngFlipkart {
	private PomFlipkartLogin pomFlipkartLogin;
	private PomFlipkartLoginOtp pomFlipkartLoginOtp;
	private PomFlipkartCreate pomFlipkartCreate;
	private PomSearchProduct pomSearchProduct;
	private PomProductPage pomProductPage;
	
	public PomFlipkartLogin getPomFlipkartLogin() {
		if(pomFlipkartLogin == null) {
			pomFlipkartLogin = new PomFlipkartLogin();
		}
		return pomFlipkartLogin;
	}
	
	public PomFlipkartLoginOtp getPomFlipkartLoginOtp() {
		if(pomFlipkartLoginOtp == null) {
			pomFlipkartLoginOtp = new PomFlipkartLoginOtp();
		}
		return pomFlipkartLoginOtp;
	}
	public PomFlipkartCreate getPomFlipkartCreate() {
		if(pomFlipkartCreate == null) {
			pomFlipkartCreate = new PomFlipkartCreate();
		}
		return pomFlipkartCreate;
	}
	public PomSearchProduct getPomSearchProduct() {
		if(pomSearchProduct == null) {
			pomSearchProduct = new PomSearchProduct();
		}
		return pomSearchProduct;
	}
	public PomProductPage getPomProductPage() {
		if(pomProductPage == null) {
			pomProductPage = new PomProductPage();
		}
		return pomProductPage;
	}

}
