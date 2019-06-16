package programming2018.String;

public class Reverse {

	
	public static void main() {
		
	}
	
	public String reverseString(String s) {
		
		int n = s.length();

		//Approach 1
		
		String oldString = s;
		
		s= "";
		
		
		for (int i=n-1; i<s.length(); i-- ) {

		s = s + oldString.charAt(i);
		
		}
		
		//return s;
	
		//Approach 2
		
		char[] a = s.toCharArray(); 

		for (int i = 0, j = a.length-1; i < j; i++) {
			
			char temp = a[i]; 
			
			a[i] = a[j];
			a[j] = temp;
			
		}
		
	 return new String(a);
		
	}
}
