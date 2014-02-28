public class SingleNumber {
	//every element appear twice except for one
    public int singleNumber(int[] A) {
		if(A==null)
			return 0;
		if(A.length==1)
			return A[0];
		int answer=0;
		for(int i=0;i<A.length;i++){
			answer=answer^A[i];
		}
		return answer;
    }
	//every element appear three times except for one
    public int singleNumber2(int[] A) {
		if(A==null){return 0;}
		if(A.length==1){return A[0];}
		int result=0;
		int[] bit_count = new int[32];
		for(int j=0;j<32;j++){
			for(int i=0;i<A.length;i++){
				if((A[i]&(1<<j))!=0){
					bit_count[j]+=1;
				}
			}
			result = result|((bit_count[j]%3)<<j);
		}
		return result;
    }
	//there are two arrays with two elements are different while others are identical.
    public int[] two_numbers(int[] A,int [] B) {
		if(A==null){
			return B;
		}
		if(B==null){
			return A;
		}
		int all_xor=0;
		int sum_xy=0;
		int[] more;
		int[] less;
		int[] result = new int[2];
		if(A.length>=B.length){
			more=A;
			less=B;
		}else{
			more=B;
			less=A;
		}
		for(int i=0;i<more.length;i++){
			all_xor ^= more[i];
			sum_xy += more[i];
		}
		for(int j=0;j<less.length;j++){
			all_xor ^= less[j];
			sum_xy += less[j];
		}
		int bit =0;
		while((all_xor>>bit)!=0){
			bit=bit+1;
		}
		if(bit==0){
			result[0] = sum_xy/2;
			result[1] = sum_xy/2;
		}
		else{
			bit=bit-1;
			all_xor=0;
			for(int i=0;i<more.length;i++){
				if((more[i]|(1<<bit))!=0){
					all_xor ^= more[i];
				}
			}
			for(int j=0;j<less.length;j++){
				if((less[j]|(1<<bit))!=0){
					all_xor ^= less[j];
				}
			}
			result[0] = all_xor;
			result[1] = sum_xy-all_xor;
		}
		return result;
    }
	public static void main(String[] args){
		System.out.print(1);
		System.out.print(1<<1);
		System.out.print(1<<0);
	
	}
}
