package lee.java.vo;

public class posMenu {
	// [���]
	// �޴� ����
	//- ���
	private int cowChadol = 25000; private int cntCowChadol;
	private int cowGalbi = 18000; private int cntCowGalbi;
	private int pigGalbi =  15000; private int cntPigGalbi;
	private int pigSamgyub = 10000; private int cntPigSamgyub;
	// - �Ļ�
	private int kimChijjigae = 3000; private int cntKimChijjigae;
	private int doyenJangjjigae = 35000; private int cntDoyenJangjjigae;
	private int rice = 1000; private int cntRice;
	// - �ַ�
	private int soju = 6000; private int cntSoju;
	private int beer = 6000; private int cntBeer;
	// - ����
	private int coke = 2500; private int cntCoke;
	private int cyder = 2500; private int cntCyder;
	// �ֹ� �Ѿ�
	private int totalPrice;
	
	// [������]
	public posMenu() {}
	
	// [�޼���]
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
	
	// �ֹ� �Ѿ�
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
		if(isCowChadol()) sb.append("�������� " + cntCowChadol +
				"�� ----------- " + (cowChadol*cntCowChadol) + "��");
		if(isCowGalbi()) sb.append("������ " + cntCowGalbi +
				"�� ----------- " + (cowGalbi*cntCowGalbi) + "��");
		if(isPigGalbi()) sb.append("�������� " + cntPigGalbi +
				"�� ----------- " + (pigGalbi*cntPigGalbi) + "��");
		if(isPigSamgyub()) sb.append("���� " + cntPigSamgyub +
				"�� ----------- " + (pigSamgyub*cntPigSamgyub) + "��");
		if(isKimChijjigae()) sb.append("��ġ� " + cntKimChijjigae +
				"�� ----------- " + (kimChijjigae*cntKimChijjigae) + "��");
		if(isDoyenJangjjigae()) sb.append("����� " + cntDoyenJangjjigae +
				"�� ----------- " + (doyenJangjjigae*cntDoyenJangjjigae) + "��");
		if(isRice()) sb.append("����� " + cntRice +
				"�� ----------- " + (rice*cntRice) + "��");
		if(isSoju()) sb.append("���� " + cntSoju +
				"�� ----------- " + (soju*cntSoju) + "��");
		if(isBeer()) sb.append("����" + cntBeer +
				"�� ----------- " + (beer*cntBeer) + "��");
		if(isCoke()) sb.append("�ݶ� " + cntCoke +
				"�� ----------- " + (coke*cntCoke) + "��");
		if(isCyder()) sb.append("���̴� " + cntCyder +
				"�� ----------- " + (cyder*cntCyder) + "��");
		return super.toString();
	}
	
	
}