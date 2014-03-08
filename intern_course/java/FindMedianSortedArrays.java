public class FindMedianSortedArrays{
    public double findMedianSortedArrays(int A[], int B[]) {
		if(A.length==0){
			if(B.length!=0)
				return B[B.length/2];
			else
				return 0.00;
		}
		if(B.length==0){
			if(A.length!=0)
				return A[A.length/2];
			else
				return 0.00;
		}
		return 0;
    }
	public static void main(String[] args){
		System.out.println("haha");
	
	}
}
