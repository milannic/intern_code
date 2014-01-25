#include	<stdlib.h>
#include	<stdio.h>

int swap(char* original,int index1,int index2){
	char temp = '0';
	temp = original[index1];
	original[index1] = original[index2];
	original[index2] = temp;
	return 1;

}

int reverse(char* original){
	int length = 0;
	int index = 0;
	for (index=0;original[index]!='\0';index++);	
	length = index-1;
	for(index=0;index<length;){
		swap(original,index,length);
		length--;
		index++;
	}
	return 1;
}


int main ( int argc, char *argv[] )
{	
	char string[] = "abcdefg";	
	printf("before the reverse : %s\n",string);
	reverse(string);
	printf("after the reverse : %s\n",string);
	return EXIT_SUCCESS;
}				/* ----------  end of function main  ---------- */
