import java.util.*;
import java.io.*;



class Point {
  int x;
  int y;
  Point() { x = 0; y = 0; }
  Point(int a, int b) { x = a; y = b; }
}

// we assume that there is no overlapping points in the array
public class Line_common{
     public static int maxPoints(Point[] points) {

		int index1 = 0;
		int index2 = 0;
		int vertical = 1;
		int maximum =1;
		int new_maximum = 1;
		int length = points.length;
		int samepoint = 0;
		double line;
		Integer count;
	    Hashtable<Double, Integer> counter = new Hashtable<Double, Integer>();
		if(null == points)
			return 0;
		if(points.length == 0)
			return 0;
		for(index1=0;index1<length;index1++){
			for(index2=0;index2<length;index2++){
				if(index1 != index2){
					if(points[index1].x == points[index2].x && points[index1].y == points[index2].y){
						samepoint++;
					}else if(points[index1].x == points[index2].x && points[index1].y != points[index2].y){
						vertical++;
						if(vertical>new_maximum)
							new_maximum = vertical;
					}
					else{
						line = (double)(points[index1].y - points[index2].y)/(double)(points[index1].x - points[index2].x);  
						count = counter.get(new Double(line));
						if(null != count){
							//System.out.println(count);
							counter.put(new Double(line), new Integer(++count));
							//System.out.format("(%d,%d),(%d,%d),%.10f \n",points[index1].x,points[index1].y,points[index2].x,points[index2].y,line);
							//System.out.println(count);
						}
						else{
							count = new Integer(2);
							counter.put(new Double(line), new Integer(2));
						}
						if(count>new_maximum)
							new_maximum = count;
					}
				}
			}
			counter.clear();
			vertical=1;
			if(new_maximum+samepoint>maximum)
				maximum = new_maximum+samepoint;
			samepoint = 0;
			new_maximum = 1;
		}
		return maximum;
    }

    public static void main(String[] argv) {
		Integer count = null;
		Point test_point = new Point(3,5);
		//System.out.println(test_point.x);
		//System.out.println(test_point.y);
		Point points[] = new Point[9];
		points[0] = new Point(0,0);
		points[1] = new Point(1,0);
		points[2] = new Point(0,-70);
		points[3] = new Point(84,250);
		points[4] = new Point(1,-1);
		points[5] = new Point(21,10);
		points[6] = new Point(42,90);
		points[7] = new Point(0,-70);
		points[8] = new Point(-42,-230);
		/*
	    Hashtable<Double, Integer> counter = new Hashtable<Double, Integer>();
		counter.put(new Double(3/7), 5);
		count = counter.get(new Double(3/7));
		if(count != null)
			counter.put(new Double(3/7), new Integer(++count));

		System.out.println(counter.get(new Double(3/7)));

		count = counter.get(new Double(3/7));
		if(count != null)
			counter.put(new Double(3/7), new Integer(++count));
		
		System.out.println(counter.get(new Double(3/7)));
		*/
		System.out.println(Line_common.maxPoints(points));
    }
}
