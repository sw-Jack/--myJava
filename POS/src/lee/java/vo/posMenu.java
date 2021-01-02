package lee.java.vo;

public class posMenu {
	// [멤버]
	// 메뉴 가격
	//- 고기
	private int cowChadol = 25000; private int cntCowChadol;
	private int cowGalbi = 18000; private int cntCowGalbi;
	private int pigGalbi =  15000; private int cntPigGalbi;
	private int pigSamgyub = 10000; private int cntPigSamgyub;
	// - 식사
	private int kimChijjigae = 3000; private int cntKimChijjigae;
	private int doyenJangjjigae = 35000; private int cntDoyenJangjjigae;
	private int rice = 1000; private int cntRice;
	// - 주류
	private int soju = 6000; private int cntSoju;
	private int beer = 6000; private int cntBeer;
	// - 음료
	private int coke = 2500; private int cntCoke;
	private int cyder = 2500; private int cntCyder;
	// 주문 총액
	private int totalPrice;
	
	// [생성자]
	public posMenu() {}
	
	// [메서드]
	public int getCntCowChadol() {
		return cntCowChadol;
	}

	public void setCntCowChadol(int cntCowChadol) {
		this.cntCowChadol += cntCowChadol;
	}

	public int getCntCowGalbi() {
		return cntCowGalbi;
	}

	public void setCntCowGalbi(int cntCowGalbi) {
		this.cntCowGalbi += cntCowGalbi;
	}

	public int getCntPigGalbi() {
		return cntPigGalbi;
	}

	public void setCntPigGalbi(int cntPigGalbi) {
		this.cntPigGalbi += cntPigGalbi;
	}

	public int getCntPigSamgyub() {
		return cntPigSamgyub;
	}

	public void setCntPigSamgyub(int cntPigSamgyub) {
		this.cntPigSamgyub += cntPigSamgyub;
	}

	public int getCntKimChijjigae() {
		return cntKimChijjigae;
	}

	public void setCntKimChijjigae(int cntKimChijjigae) {
		this.cntKimChijjigae += cntKimChijjigae;
	}

	public int getCntDoyenJangjjigae() {
		return cntDoyenJangjjigae;
	}

	public void setCntDoyenJangjjigae(int cntDoyenJangjjigae) {
		this.cntDoyenJangjjigae += cntDoyenJangjjigae;
	}

	public int getCntRice() {
		return cntRice;
	}

	public void setCntRice(int cntRice) {
		this.cntRice += cntRice;
	}

	public int getCntSoju() {
		return cntSoju;
	}

	public void setCntSoju(int cntSoju) {
		this.cntSoju += cntSoju;
	}

	public int getCntBeer() {
		return cntBeer;
	}

	public void setCntBeer(int cntBeer) {
		this.cntBeer += cntBeer;
	}

	public int getCntCoke() {
		return cntCoke;
	}

	public void setCntCoke(int cntCoke) {
		this.cntCoke += cntCoke;
	}
	
	public int getCntCder() {
		return cntCyder;
	}

	public void setCntCder(int cntCder) {
		this.cntCyder += cntCder;
	}	
	
	// 주문 총액
	public int totPrice() {
		totalPrice = cowChadol*cntCowChadol + cowGalbi*cntCowGalbi +  pigGalbi*cntPigGalbi
				+ pigSamgyub*cntPigSamgyub + kimChijjigae*cntKimChijjigae 
				+ doyenJangjjigae*cntDoyenJangjjigae + rice*cntRice + soju*cntSoju
				+ beer*cntBeer + coke*cntCoke + cyder*cntCyder;
		return totalPrice;
	}
	
	public boolean isCowChadol() {
		if(cntCowChadol > 0) return true;
		return false;
	}
	public boolean isCowGalbi() {
		if(cntCowGalbi > 0) return true;
		return false;
	}
	public boolean isPigGalbi() {
		if(cntPigGalbi > 0) return true;
		return false;
	}
	public boolean isPigSamgyub() {
		if(cntPigSamgyub > 0) return true;
		return false;
	}
	public boolean isKimChijjigae() {
		if(cntKimChijjigae > 0) return true;
		return false;
	}
	public boolean isDoyenJangjjigae(){
		if(cntDoyenJangjjigae > 0) return true;
		return false;
	}
	public boolean isRice() {
		if(cntRice > 0) return true;
		return false;
	}
	public boolean isSoju() {
		if(cntSoju > 0) return true;
		return false;
	}
	public boolean isBeer() {
		if(cntBeer > 0) return true;
		return false;
	}
	public boolean isCoke() {
		if(cntCoke > 0) return true;
		return false;
	}
	public boolean isCyder() {
		if(cntCyder > 0) return true;
		return false;
	}
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("- ");
		if(isCowChadol()) sb.append("차돌박이 " + cntCowChadol +
				"개 ----------- " + (cowChadol*cntCowChadol) + "원");
		if(isCowGalbi()) sb.append("생갈비 " + cntCowGalbi +
				"개 ----------- " + (cowGalbi*cntCowGalbi) + "원");
		if(isPigGalbi()) sb.append("돼지갈비 " + cntPigGalbi +
				"개 ----------- " + (pigGalbi*cntPigGalbi) + "원");
		if(isPigSamgyub()) sb.append("삼겹살 " + cntPigSamgyub +
				"개 ----------- " + (pigSamgyub*cntPigSamgyub) + "원");
		if(isKimChijjigae()) sb.append("김치찌개 " + cntKimChijjigae +
				"개 ----------- " + (kimChijjigae*cntKimChijjigae) + "원");
		if(isDoyenJangjjigae()) sb.append("된장찌개 " + cntDoyenJangjjigae +
				"개 ----------- " + (doyenJangjjigae*cntDoyenJangjjigae) + "원");
		if(isRice()) sb.append("공기밥 " + cntRice +
				"개 ----------- " + (rice*cntRice) + "원");
		if(isSoju()) sb.append("소주 " + cntSoju +
				"개 ----------- " + (soju*cntSoju) + "원");
		if(isBeer()) sb.append("맥주" + cntBeer +
				"개 ----------- " + (beer*cntBeer) + "원");
		if(isCoke()) sb.append("콜라 " + cntCoke +
				"개 ----------- " + (coke*cntCoke) + "원");
		if(isCyder()) sb.append("사이다 " + cntCyder +
				"개 ----------- " + (cyder*cntCyder) + "원");
		return super.toString();
	}
	
	
}