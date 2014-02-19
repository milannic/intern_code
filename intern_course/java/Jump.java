
public class Jump{

	static boolean[] bool_array;

    public static boolean canJump(int[] A) {
		if(A==null)
			return false;
		if(A.length==1)
			return true;
		bool_array = new boolean[A.length];
		for(int i = 0; i< bool_array.length;i++){
			bool_array[i] = false;
			if(A[i]<0)
				return false;
		}
		return canJump_recurse(A,0);
        
    }
    public static boolean canJump_recurse(int[] A,int position) {
		bool result = false;
		bool_array[position] = true;
		if(position==A.length-1)
			return true;
		if(A[position]+position <= A.length-1 && bool_array[A[position]+position]!= true){
			result = canJump_recurse(A,A[position]+position);
			if(result == true)
				return true;
		}else if(A[position]-position >= 0 && bool_array[A[position]-position]!= true){
			result = canJump_recurse(A,A[position]-position);
			if(result == true)
				return true;
		}
		if(result==false){
			bool_array[position] = false;
		}
		return result;
        
    }
	public static void main(String[] args){
		int[]  input_array = new int[]{2,3,1,1,4};
		for (int i : input_array){
			System.out.println(i);
		}
	
	}
}
