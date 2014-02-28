public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas==null|cost==null|gas.length!=cost.length){
			return -1;
		}
		int start_point = 0;
		int sum=0;
		int prefix=0;
		int[] point_table = new int[cost.length];
		for(int i=0;i<cost.length;i++){
			point_table[i] = gas[i]-cost[i];
		}
		for(int i=0;i<cost.length;i++){
			sum+=point_table[i];
			if(prefix>sum)
			{
				prefix = sum;
				start_point = i+1;
			}
		}
		if(sum>=0){
			return start_point%cost.length;
		}else{
			return -1;
		}
    }
	public static void main(String[] args) {
		System.out.println("haha");
	}
}
