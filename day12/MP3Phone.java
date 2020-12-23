class CellPhone {
	String model; // 모델명
	String pnum; // 전화번호
	int chord; //화음
	public void setPnum(String n) {
		pnum = n;
	}
	public String getPnum() {
		return pnum;
	}
	public String getModel() {
		return model;
	}
	public int getChord() {
		return chord;
	}
}
public class MP3Phone extends CellPhone {
	int size; // 저장 용량
	public MP3Phone(String model, String pnum, int chord, int size) {
		this.model = model;
		this.pnum = pnum;
		this.chord = chord;
		this.size = size;
	}
}