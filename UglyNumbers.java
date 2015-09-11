
public class UglyNumbers {
/*
 * Ugly numbers are defined as the positive integers whose prime factors are limited to 2, 3, or 5.  
 * By convention, 1 is also part of the sequence.  
 * Here are the first 10 Ugly numbers:  1, 2, 3, 4, 5, 6, 8, 9, 10, and 12. 
 * Write a method to print the K’th Ugly number.
  */
 
	public static void print(int k){
		   

		    int last2 = 0;
		    int last3 = 0;
		    int last5 = 0;

		    long[] res = new long[k]; //store previous results
		    //generate ugly numbers by multiplying already found ones by 2,3 or 5
		    res[0] = 1; //first ugly number
		    for (int i = 1; i < k; i++) {
		        long prev = res[i - 1];

		        while (res[last2] * 2 <= prev) {
		            last2++;
		        }
		        while (res[last3] * 3 <= prev) {
		            last3++;
		        }
		        while (res[last5] * 5 <= prev) {
		            last5++;
		        }

		        long next2 = res[last2] * 2;
		        long next3= res[last3] * 3;
		        long next5 = res[last5] * 5;

		        res[i] = Math.min(next2, Math.min(next3, next5));  //store smallest between all 3
		    }

		    System.out.println(res[k - 1]);
	}
	public static void main(String[] args) {
	//test
		print(7);
	}
}
