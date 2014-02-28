public class Sort{
	public static void insertSort(int[] array){
		int temp;
		int cur;
		if(array==null){return;}
		if(array.length==1||array.length==0){return;}
		for(int i=1;i<array.length;i++){
			cur=i-1;
			temp=array[i];
			while(cur>=0){
				if(temp<array[cur]){
					cur--;
				}
				else
				{
					break;
				}
			}
			for(int j=i-1;j>cur;j--){
				array[j+1] = array[j];
			}
			array[cur+1] = temp;
		}
		return;
	}
	public static void mergeSort(int[] array){
		if(array==null){return;}
		if(array.length==1){return;}
		//System.out.println(array.length);
		mergesort(array,0,array.length-1);
		return;
	}
	public static void mergesort(int[] array,int start,int end){
		int temp;
		if(start==end)return;
		if(start+1==end){
			if(array[start]>array[end]){
				temp = array[start];
				array[start] = array[end];
				array[end] = temp;
			}
			return;
		}else{
			//System.out.println(start);
			//System.out.println((start+end)/2);
			//System.out.println((start+end)/2+1);
			//System.out.println(end);
			mergesort(array,start,(start+end)/2);
			mergesort(array,(start+end)/2+1,end);
			int[] temp_array = new int[end-start+1];
			int cur_1=start;
			int cur_2=(start+end)/2+1;
			int cur=0;
			/*
			for(int j=start;j<=(start+end)/2;j++){
				System.out.println(array[j]);
			}
			for(int j=(start+end)/2+1;j<=end;j++){
				System.out.println(array[j]);
			}
			*/
			while(cur_1<=(start+end)/2&&cur_2<=end){
				if(array[cur_1]<=array[cur_2]){
					temp_array[cur] = array[cur_1];
					cur_1++;
				}else{
					temp_array[cur] = array[cur_2];
					cur_2++;
				}
				cur++;
			}
			if(cur_1<=(start+end)/2){
				for(int i=cur_1;i<=(start+end)/2;i++){
					temp_array[cur]=array[i];
					cur++;
				}
			}else{
				/*
				System.out.println("cur is :");
				System.out.println(cur);
				*/
				for(int i=cur_2;i<=end;i++){
					temp_array[cur]=array[i];
					cur++;
				}
			}
			/*
			for(int i=0;i<(end-start+1);i++){
				System.out.println(temp_array[i]);
			}
			*/
			for(int i=0;i<(end-start+1);i++){
				array[start+i] = temp_array[i];
			}
			return;
		}
	}
	public static void quickSort(int[] array){
		if(array==null){return;}
		if(array.length==1){return;}
		//System.out.println(array.length);
		quicksort(array,0,array.length-1);
		return;
	}
	public static void quicksort(int[] array,int start,int end){
		int pivot;
		if(start==end){return;}
		if(start+1==end){
			if(array[start]>array[end]){
				int temp=array[start];
				array[start] = array[end];
				array[end] = temp;
			}
			return;
		}
		else{
			pivot = partition(array,start,end);
			if(pivot!=start){
				quicksort(array,start,pivot);
			}
			if(pivot!=end){
				quicksort(array,pivot+1,end);
			}
		}
		
	}
	public static int partition(int[] array,int start,int end){
		int pivot = array[start];
		int cur=start+1;
		int temp=0;
		for(int i=start+1;i<=end;i++){
			if(array[i]<=pivot){
				temp=array[cur];
				array[cur] = array[i];
				array[i] = temp;
				cur++;
			}
		}
		array[start] = array[cur-1];
		array[cur-1] = pivot;
		return cur-1;
	}
	public static void main(String[] args){
		int[] a = {1,4,2,18,5,3,20,9,3,7};
		for(int ele:a){
			System.out.println(ele);
		}
		insertSort(a);
		System.out.println("after insertion sort");
		for(int ele:a){
			System.out.println(ele);
		}
		System.out.println("===========================");
		int[] b = {1,4,2,5,6};
		mergeSort(b);
		System.out.println("after merge sort");
		for(int ele:b){
			System.out.println(ele);
		}
		System.out.println("===========================");
		int[] c = {1,72,2};
		quickSort(c);
		System.out.println("after quicksort sort");
		for(int ele:c){
			System.out.println(ele);
		}
		System.out.println("===========================");
	}
}
