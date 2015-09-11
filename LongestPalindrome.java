
public class LongestPalindrome {
public static void longest(String s){
	int n=s.length();
	int start=0;
	int maxLength=1;
	boolean[][]  pals=new boolean[n][n];  //array tostore if there is a palindrome between indexes i and j
	for(int i=0;i<n;i++)
    //all 1 letter substrings are palindromes
		pals[i][i]=true;
	for(int i=0;i<n-1;i++){
		//test 2 letters substrings
		if(s.charAt(i)==(s.charAt(i+1))){
			pals[i][i+1]=true;
			start=i;
			maxLength=2;
		}
	}
	for(int len=3;len<=n;len++){
		for(int i=0;i<n-len+1;i++){
			//start from left and check 3 letter substrings, then 4 letters etc
			int j=i+len-1; //letter to check (move len positions to the right from the index)
			if(s.charAt(i)==s.charAt(j)&&pals[i+1][j-1]==true)
			{
				pals[i][j]=true;  //substring(i,j) is a palindrme
				start=i;
				maxLength=len;  //update length
			}
		}
	}
	System.out.println(start);
	System.out.println(maxLength);
	
	
}
public static void main(String[] args) {
	longest("12111122221212121");
}
}
