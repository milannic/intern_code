import java.util.*;

public class WordBreak2{
    public boolean wordBreak(String s, Set<String> dict) {
		if(s==null)
			return true;
		if(s=="")
			return true;
		if(dict==null)
			return false;
		if(s.length()==1)
			return dict.contains(s);
		if(dict.contains(s)==true){
			return true;
		}
		int s_len = s.length();
		int[][] dp_table = new int[s_len][s_len];
		for(int i=1;i<=s_len;i++){//outside loop substring from length 1 to length n
			for(int j=0;j+i<=s_len;j++){//inner loop to construct each element of dp_table[j][j+i]
				//System.out.println(j);
				//System.out.println(j+i);
				//System.out.println(s.substring(j,j+i));
				//System.out.println(dict.contains(s.substring(j,j+i)));
				if(dict.contains(s.substring(j,j+i))==true){
					dp_table[j][j+i-1]=1;
				}
				else{
					for(int k=j;k<j+i;k++){
						//System.out.println(j);
						//System.out.println(k);
						//System.out.println(k+1);
						//System.out.println(j+i);
						if(1==dp_table[j][k]&&1==dp_table[k+1][j+i-1]){
							//System.out.println("Found");
							dp_table[j][j+i-1]=1;
							break;
						}	
					}
				}
			}
		}		
		if(1==dp_table[0][s_len-1]){
			return true;
		}
		else
		{
			return false;
		}
    }
	public static void main(String[] args){
		Set<String> dict = new TreeSet<String>();	
		dict.add("aaaa");
		dict.add("aaa");
		List<List<Integer>> list_2d = new ArrayList<List<Integer>>();
		for(int i=0;i<10;i++){
			list_2d.add(new ArrayList<Integer>());
		}
		list_2d.get(0).add(new Integer(3));

		ArrayList dp_table = new ArrayList();
		for(int i=0;i<10;i++){
			dp_table.add(new ArrayList());
			for(int j=0;j<10;j++){
				((ArrayList)dp_table.get(i)).add(new ArrayList());
			}
		}
		((ArrayList)((ArrayList)dp_table.get(2)).get(3)).add(5);
		System.out.println(((ArrayList)((ArrayList)dp_table.get(2)).get(3)).get(0));
		System.out.println(list_2d.get(0).get(0));
		//System.out.println(new WordBreak().wordBreak("aaaaaaa",dict));
	
	}
}
