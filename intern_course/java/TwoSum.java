import java.util.*;
public class TwoSum{
    public static int[] twoSum(int[] numbers, int target) {
		int[] solution = new int[2];
		Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
		int length = numbers.length;
		for(int i=0;i<length;i++){
			if(table.containsKey(target-numbers[i])){
				solution[0] = table.get(target-numbers[i]);
				solution[1] = i+1;
				break;
			}else{
				table.put(numbers[i],i+1);
			}
		}
		return solution;
    }
	public static void main(String[] argv){
		int[] numbers = new int[]{1,2,4,99};
		System.out.println(twoSum(numbers,6)[0]);
		System.out.println(twoSum(numbers,6)[1]);
	}
}
