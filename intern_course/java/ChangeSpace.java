import java.io.*;

public class ChangeSpace{
	public static void changeSpace(String original){
		String newstring = original;
		original = newstring.substring(0,1)+'h';
		System.out.println("in the function, the original string is:");
		System.out.println(original);
	
	}

	public static void main(String[] args){

		int index,space_count,new_length;
		char[] new_char_array;
		space_count = 0;
		String para = "aaa aa a";
		System.out.println("before the change, the original string is:");
		System.out.println(para);
		for(index=0;index<para.length();index++){
			if(para.charAt(index) == ' ')
				space_count++;
		}
		index--;
		new_length = para.length()+space_count*2;
		new_char_array = new char[new_length--];
		for(;new_length>=0;){
			if(para.charAt(index)!=' '){
				new_char_array[new_length--] = para.charAt(index);
			}
			else{
				new_char_array[new_length--] = '0';
				new_char_array[new_length--] = '2';
				new_char_array[new_length--] = '%';
			}
			index--;
		}
		para = String.valueOf(new_char_array);
		System.out.println("after the change, the original string is:");
		System.out.println(para);
	}
}
