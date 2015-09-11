

public class KthBinary {
	/*
	If we ignore leading zero, numbers can’t be even, so we only test odd numbers
	*/

	public static String toBinary(int n){
		//represent result as a string because it can get big
	   String s="";
	   while(n!=0){
	int d=n%2;
	s=Integer.toString(d)+s;
	n=n/2;
	   }
	return s;

	}

	public static boolean isPalindrome(String s){
	String inv="";
	int nr=s.length();
    //reverse the string
	for(int i=0;i<nr;i++){
	inv=s.charAt(i)+inv;
	}
	return inv.equals(s);
	}

	public static int kth(int k){
	int nr=0;
	int i=-1;
	while(nr!=k){
	i+=2; //next odd number
	if(isPalindrome(toBinary(i))) nr++;


	}
	return i;
	}

	public static void main(String[] args){
    //test
	int k=kth(6);
	System.out.println(k);
	}
}
