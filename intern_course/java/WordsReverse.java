public class WordsReverse{
	public static String reverseWords(String s) {
		if(s==null){return null;}
		if(s.equals("")){return new String("");}
		//if(s.replace(" ","").equals("")){return new String("");}
		String new_string = "";
		int length = s.length();
		int previous = length;
		int word_count = 0;
		for(int i=length-1;i>=0;i--){
			if(s.charAt(i)==' '){
				//continuous space symbol
				//first symbol is a space
				//System.out.println(i);
				//System.out.println(previous);
				if(previous!=i+1){
					if(word_count==0){
						new_string = new_string+s.substring(i+1,previous);
						word_count = word_count+1;
					}else{
						//System.out.println(new_string);
						new_string = new_string+ " " + s.substring(i+1,previous);
					}
				}
				previous = i;
			}
		}
		if(0!=previous){
			if(word_count!=0){
				new_string = new_string +" "+s.substring(0,previous);
			}else{
				new_string = s.substring(0,previous);
			}
		}
		return new_string;
	}
	public static void main(String[] argv){
		//String i = "new to base none";
		//System.out.println(reverseWords(i));
		String j = " a";
		System.out.println(reverseWords(j));
		System.out.println(reverseWords(j).length());
		String i = "";
		System.out.println(reverseWords(i));
		System.out.println(reverseWords(i).length());
	}
}
