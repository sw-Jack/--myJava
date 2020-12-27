import java.io.*;
import java.util.*;
public class MemProgram {
	public static void main(String[] args) {
		MemManager memManager = new MemManager();
		try {
			memManager.Run();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}