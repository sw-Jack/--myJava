// ���׸� �ǽ�
class GenericEx<T> {
	T[] v;
	public void set(T[] n) {
		v = n;
	}

	public void print() {
		for(T s : v)
			System.out.println(s);
	}
}