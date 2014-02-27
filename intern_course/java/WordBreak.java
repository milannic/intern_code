import java.util.*;

public class WordBreak{
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
		System.out.println(new WordBreak().wordBreak("aaaaaaa",dict));
	
	}
}
