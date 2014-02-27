
public class Jump{
    public boolean canJump(int[] A) {
		if(A==null)
			return false;
		if(A.length==1)
			return true;
		int cur_farest_point=0;
		int final_point = A.length-1;
		for(int i=0;i<=final_point;i++){
			if(A[i]<0)
				return false;
			// we can get to the A[i] then
			if(cur_farest_point>=i){
				if(A[i]+i>cur_farest_point){
					cur_farest_point = A[i]+i;
				}
			}else{
				return false;
			}
			if(cur_farest_point>=final_point){
				return true;
			}
		}
		return true;
    }
	public static void main(String[] args){
		int[]  input_array = new int[]{2,3,1,1,4};
		for (int i : input_array){
			System.out.println(i);
		}
		if(true==new Jump().canJump(input_array)){
			System.out.println("can get the endpoint");
		}else{
			System.out.println("can not get to the endpoint");
		}
	
	}
}
