// Task 05: Game Arena
class Task5{

    //Complete this method so that it gives the Expected Output
    public static void playGame( Integer[][] arena ){

        //For this task you don't need to create any new 2D array
        //just print the result inside the function
        
        //TO DO
        int row=arena.length,column=arena[0].length,points=0;
        for(int r=0;r<row;++r){
            for(int c=0;c<column;++c){
                if(arena[r][c]%50==0&&arena[r][c]!=0){
                    if(r>0&&arena[r-1][c]==2) points+=2;
                    if(r<row-1&&arena[r+1][c]==2) points+=2;
                    if(c>0&&arena[r][c-1]==2) points+=2;
                    if(c<column-1&&arena[r][c+1]==2) points+=2;
                }
            }
        }
        if(points>9) System.out.printf("Points Gained: %d. Your team has survived the game.\n",points);
        else System.out.printf("Points Gained: %d. Your team is out.\n",points);
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] arena = {
            {0,2,2,0},
            {50,1,2,0},
            {2,2,2,0},
            {1,100,2,0}
        };
        System.out.println("Given Arena: ");
        Arr.print2D(arena);
        
        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 6. Your team is out.\n");
        
        System.out.print("\nYour Output:\n");
        playGame( arena );

        System.out.print("\n======================\n");

        Integer[][] arena1 = {
            {0,2,2,0,2},
            {1,50,2,1,100},
            {2,2,2,0,2},
            {0,200,2,0,0}
        };
        System.out.println("\nGiven Arena: ");
        Arr.print2D(arena1);
        
        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 14. Your team has survived the game.\n");
        
        System.out.print("\nYour Output:\n");
        playGame( arena1 );
    }
}