import java.io.*;


// just for ascii string
public class Permutation{
	public static boolean permutation(String para1,String para2){
		int[] char_count = new int[256];
		int index = 0;
		if(para1.length() != para2.length()) return false;
		for(;index<para1.length();index++)char_count[para1.charAt(index)]++;
		for(index=0;index<para2.length();index++){
			if(char_count[para2.charAt(index)]<=0) return false;
			else char_count[para2.charAt(index)]--;
		}
		return true;
	}


	public static void main(String[] args){
		String para1 = "abcdefg";
		String para2 = "bcdexga";
		if(permutation(para1,para2))	
			System.out.println("these two are the same");
	
	}
}
