package lee.java.exam12;

public class MultiClientThread extends Thread {
	private MultiClient multiClient;
	
	public MultiClientThread(MultiClient multiClient) {
		this.multiClient = multiClient;
	}
	
	public void run() {

		String recMessage = null;
		String[] strRecMessage = null;
		boolean isStop = false;
		
		while(!isStop) {
			try {
				recMessage = (String)multiClient.getOis().readObject();
				strRecMessage = recMessage.split("#");
			} catch(Exception e) {
				e.printStackTrace();
				isStop = true;
			}
			System.out.println(strRecMessage[0] + " : " +
												strRecMessage[1]);
			if(strRecMessage[1].equals("exit")) {
				if(strRecMessage[0].equals(multiClient.getId())) {
					multiClient.exit();
				} else {
					multiClient.getJTextArea().append("- " + strRecMessage[0] + 
					"¥‘¿Ã ≈¿Â«œºÃΩ¿¥œ¥Ÿ." + System.getProperty("line.separator"));
					multiClient.getJTextArea().setCaretPosition(
					multiClient.getJTextArea().getDocument().getLength());
				}
			} else {
				multiClient.getJTextArea().append("[" + strRecMessage[0] +
							"] : " + strRecMessage[1] + 
							System.getProperty("line.separator"));
				multiClient.getJTextArea().setCaretPosition(
				multiClient.getJTextArea().getDocument().getLength());
			}
		}
	}
}
