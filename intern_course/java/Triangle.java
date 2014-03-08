import java.util.*;
public class Triangle{
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int size = triangle.size();
		if(size==1){
			return triangle.get(0).get(0).intValue();
		}else if(size==2){
			if(triangle.get(1).get(0)>triangle.get(1).get(1)){
				return triangle.get(0).get(0).intValue()+triangle.get(1).get(1);
			}else
				return triangle.get(0).get(0).intValue()+triangle.get(1).get(0);
		}
		int[] table1 = new int[size];
		int[] table2 = new int[size];
		for(int i = size-1;i>=0;i--){
			//we use table1
			if(i%2==0){
				//System.out.println("even");
				for(int j = 0;j<i+1;j++){
					//the bottom of the table
					//System.out.println(j);
					if(i==size-1){
						table1[j] = triangle.get(i).get(j);
					}
					else{
						table1[j] = (table2[j]<=table2[j+1]?(triangle.get(i).get(j)+table2[j]):(triangle.get(i).get(j)+table2[j+1]));
					}
				}
			}
			// we use table2
			if(i%2==1){
				//System.out.println("odd");
				//System.out.println(i);
				for(int j = 0;j<i+1;j++){
					//the bottom of the table
					//System.out.println(j);
					if(i==size-1){
						table2[j] = triangle.get(i).get(j);
						//System.out.println(table2[j]);
					}
					else{
						table2[j] = (table1[j]<=table1[j+1]?(triangle.get(i).get(j)+table1[j]):(triangle.get(i).get(j)+table1[j+1]));
					}
				}
			}
		}
		return table1[0];
        
    }
	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		triangle.add(new ArrayList<Integer>());
		triangle.get(0).add(2);
		/*
		triangle.add(new ArrayList<Integer>());
		triangle.get(1).add(3);
		triangle.get(1).add(4);
		triangle.add(new ArrayList<Integer>());
		triangle.get(2).add(6);
		triangle.get(2).add(5);
		triangle.get(2).add(7);
		triangle.add(new ArrayList<Integer>());
		triangle.get(3).add(4);
		triangle.get(3).add(1);
		triangle.get(3).add(8);
		triangle.get(3).add(3);
		*/
		System.out.println(minimumTotal(triangle));
	
	}
}
