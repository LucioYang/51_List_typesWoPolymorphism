public class Element {
	public int intValue;
	public double doubleValue;
	public String stringValue;
	public int type;
	
	public String toString() {
		String ans = new String();
		if (type == 0)
			ans += intValue;
		else if (type == 1)
			ans += doubleValue;
		else
			ans += stringValue;
		return ans;
	}
}
