
//i've used backtracking, simple but not very efficient
//then I tried dynamic programming. I left both here
public class MakeChange{
	int s,n;
	int[] used; //store how many times a coin has been used
	int[] d;
	int nr; //number of solutions
	public MakeChange(int s,int n,int[] d){
		this.s=s; this.n=n;
		this.d=d; 
		used=new int[n];
		for(int i=0;i<n;i++)
			used[i]=0;
		nr=0;
	}
	public int sum(int k){ //calculate sum at step k
		int s=0;
		for(int i=0;i<=k;i++)
		s+=used[i]*d[i];
		return s;
	}
	public boolean cont(int k)  //continuation condition
	{
		int s1=sum(k);
		if(s1>s) return false;
		if(k==n-1&&s1!=s) return false;
	 
	 return true;
	}

	int back(int k){
		int i;
		if(k==n) //found a solution
		{nr++; 
		}
		else
			for(i=0;i<=s/d[k];i++){
				used[k]=i;
				if(cont(k)) back(k+1);
			}
		return nr;
	}
	
	//dynamic programming version
	public int count(){
		int[] nrs = new int[s+1];
		nrs[0] = 1;
	for (int i = 0; i <n; i++) {
		//try every coin to all sums already found
	    for (int j = d[i]; j <= s; j++) {
	    	//increase number of ways for a sum
	    	nrs[j]+=nrs[j-d[i]];
	       
	    }
	}
	return nrs[s];
	}
	public static void main(String[] args) {
		int s=10;
		int n=3;
		int[] d={2,3,5};
		MakeChange test=new MakeChange(s,n,d);
		System.out.println(test.back(0));
		System.out.println(test.count());
	}
	
}
