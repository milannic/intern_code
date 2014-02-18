import java.io.*;

public class UniqueChar{

	public static boolean test1(String para_string){
		if(para_string.length()>256) return false;
			boolean[] ascii_array = new boolean[256];
			int index = 0;
			for(int i =0; i<para_string.length(); i++){
				index = para_string.charAt(i);
				if(ascii_array[index]) return false;
				else ascii_array[index] = true;
			}
			return true;
	}


	public static boolean test2(String para_string){
		if(para_string.length()>26) return false;
		int bitarray = 0;
		int index = 0;
		for(int i =0; i<para_string.length(); i++){
			index = para_string.charAt(i);
			if(index < 'a' | index > 'z') return false;
			if((bitarray & (1<<index))>0) return false; 
			else  bitarray = bitarray | (1<<index);
		}
		return true;
	}

	public static void main(String[] args){
	
	System.out.println("this is a test of whether all the elements  a certain string");	
	String sentence1 = "125324";
	String sentence2 = "2232323";
	String sentence3 = "12345678";
	String sentence4 = "aBcdef";
	String sentence5 = "ddbcdef";
	System.out.println(sentence1+sentence2);	
	boolean result = false;
	result = test1(sentence1);
	if(result)
		System.out.println("sentence1 is unique");	
	result = test1(sentence3);
	if(result)
		System.out.println("sentence3 is unique");	

	result = test2(sentence4);
	if(result)
		System.out.println("sentence4 is unique");	
	result = test2(sentence5);
	if(result)
		System.out.println("sentence5 is unique");	
	}

}
