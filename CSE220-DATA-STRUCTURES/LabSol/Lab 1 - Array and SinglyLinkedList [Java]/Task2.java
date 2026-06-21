//Task 02: Container with Most Water
class Task2{

    //Complete this method so that it gives the Expected Output
public static void mostWater( Integer[] height ){

    //TO DO
    int i=0,n=height.length-1,area,maxArea=0;

    while(i<n){
        if(height[i]<height[n]){
            area=height[i]*(n-i);
            i++;
        }else{
            area=height[n]*(n-i);
            n--;
        }
        if(area>maxArea){
            maxArea=area;
        }
    }
    System.out.println(maxArea);
}

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println("Given Array: ");
        Arr.print(array);
        System.out.println("\nExpected Output:");
        System.out.print("49");
	System.out.print("\nYour Output:\n");
        mostWater( array );

    }
}
