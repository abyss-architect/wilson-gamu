public class Tuple<T, U> {
	private T first;
	private U second;
	
	public Tuple(T first, U second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return this.first;
	}

	public void SetFirst(T first) {
		this.first = first;
	}

	public U getSecond() {
		return this.second;
	}

	public void SetSecond(U second) {
		this.second = second;
	}
}