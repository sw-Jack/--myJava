// Queue �������̽� - LinkedList
import java.util.LinkedList;
public class QueueEx {
	public static void main(String[] args) {
		String[] item = {"�ҳ�Ÿ","������","��Ծ�"};
		LinkedList<String> queue = new LinkedList<String>();
		for(String n : item) 
			queue.offer(n); // �������� ��� �߰�
		System.out.println("queue�� ũ�� : " + queue.size());
		String data = "";
		while((data = queue.poll()) != null) { // poll() : ���� ù��° ��� ��ȯ �� ����
			System.out.println(data + "����");
			System.out.println("queue�� ũ�� : " + queue.size());
		}
	}
}