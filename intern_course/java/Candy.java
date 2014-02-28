public class Candy{
    public int candy(int[] ratings) {
		if(ratings==null)return 0;
		if(ratings.length==1) return 1;
		int[] candy = new int[ratings.length];
		int sum=0;
		candy[0] = 1;
		for(int i=1;i<ratings.length;i++){
			if(ratings[i-1]<ratings[i]){candy[i]=candy[i-1]+1;}
			if(ratings[i-1]>=ratings[i]){candy[i]=1;}
		}
		for(int i=0;i<ratings.length;i++){
			System.out.println(candy[i]);
		}
		System.out.println("====================");
		sum+=candy[ratings.length-1];
		for(int i=ratings.length-1;i>=1;i--){
			if(ratings[i-1]>ratings[i]&&candy[i-1]==1){
				candy[i-1] = candy[i]+1;
			}else if(ratings[i-1]>ratings[i]&&candy[i-1]!=1){
				candy[i-1] = (candy[i]+1)>candy[i-1]?(candy[i]+1):candy[i-1];
			}
			sum+=candy[i-1];
		}
		for(int i=0;i<ratings.length;i++){
			System.out.println(candy[i]);
		}
		return sum;
    }
	public static void main(String[] args){
		int[] ratings = new int[]{4,2,3,4,1};
		new Candy().candy(ratings);
		return;
	}
}
