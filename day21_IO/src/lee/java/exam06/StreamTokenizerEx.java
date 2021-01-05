package lee.java.exam06;
import java.io.*;

import javax.swing.plaf.synth.SynthTreeUI;

// StreamTokenizer 활용 예제
public class StreamTokenizerEx {
	public static void main(String[] args) {
		BufferedReader br = null;
		StreamTokenizer st = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter("[input file's path]");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw, true);
			pw.println(1000);
			pw.println("안녕하세요");
			pw.println("hellow@nate.com");
			pw.println("I am a instructor");
			pw.println("~!@#");
			br = new BufferedReader(new FileReader("[input file's path]"));
			st = new StreamTokenizer(br);
			while(st.nextToken() != StreamTokenizer.TT_EOF) {
				switch(st.ttype) {
				case StreamTokenizer.TT_WORD :
					System.out.println("Word => " + st.sval); break;
				case StreamTokenizer.TT_NUMBER :
					System.out.println("Number => " + (int)st.nval); break;
				default :
					System.out.println("No word, No number => " + 
							(char)st.ttype); break;
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(pw != null) pw.close();
				if(bw != null) bw.close();
				if(fw != null) fw.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
