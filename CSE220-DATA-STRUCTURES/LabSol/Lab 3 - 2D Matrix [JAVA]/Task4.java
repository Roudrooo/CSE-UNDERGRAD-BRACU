// Task 04: Matrix Compression
class Task4{

    //Complete this method so that it gives the Expected Output
    public static Integer[][] compressMatrix( Integer[][] matrix ){

        //For this task you'll need to create new 2D array
        
        //TO DO
        int row=matrix.length,column=matrix[0].length,compressedRow=row/2,compressedColumn=column/2;
        Integer[][] resultArr=new Integer[compressedRow][compressedColumn];
        for(int r=0;r<compressedRow;++r){
            int sum=0;
            for(int c=0;c<compressedColumn;++c){
                sum+=matrix[2*r][2*c]+matrix[2*r+1][2*c]+matrix[2*r][2*c+1]+matrix[2*r+1][2*c+1];
                resultArr[r][c]=sum;
            }
        }
        //remove the line below and return the newly created Compressed 2D matrix
        return resultArr;
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] matrix = {
            { 1 , 2 , 3 , 4 },
            { 5 , 6 , 7 , 8 },
            { 1 , 3 , 5 , 2 },
            {-2 , 0 , 6 ,-3 }
        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);
        
        System.out.println("\nExpected Output:");
        System.out.print("| 14 | 22 |\n| 2  | 10 |\n");
        
        System.out.print("\nYour Output:\n");
        Integer[][] returnedArray = compressMatrix( matrix );
        Arr.print2D( returnedArray );
    }
}