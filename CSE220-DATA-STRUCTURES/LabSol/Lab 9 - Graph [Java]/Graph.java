

public class Graph{
    public static void main(String[] args){

        // TASK01
        int[][] mat1=getAdjMatTask01();

        System.out.println("Maximum edge: "+Task01(mat1));

        // TASK02
        System.out.println();

        int[][] mat2=getAdjMatTask02();

        System.out.println("Vertex with maximum edge weight: "+Task02(mat2));
        
        // TASK03
        System.out.println();

        int[][] mat3=getAdjMatTask03();

        Task03(mat3);

        // TASK04
        System.out.println();
        edgeShow(mat3);
        System.out.println();
        System.out.println();
        edgeShow(Task04(mat3));

    }

    public static int[][] getAdjMatTask01(){
        int[][] mat=new int[7][7];

        mat[0][1]=1;
        mat[0][2]=1;
        mat[0][3]=1;
        mat[0][4]=1;
        mat[0][5]=1;
        mat[0][6]=1;
        
        mat[1][0]=1;
        mat[1][2]=1;
        mat[1][3]=1;
        mat[1][5]=1;

        mat[2][0]=1;
        mat[2][1]=1;
        mat[2][3]=1;
        mat[2][4]=1;
        mat[2][6]=1;

        mat[3][0]=1;
        mat[3][1]=1;
        mat[3][2]=1;
        mat[3][4]=1;
        mat[3][5]=1;

        mat[4][0]=1;
        mat[4][2]=1;
        mat[4][3]=1;
        mat[4][5]=1;

        mat[5][0]=1;
        mat[5][1]=1;
        mat[5][3]=1;
        mat[5][4]=1;
        mat[5][6]=1;

        mat[6][0]=1;
        mat[6][2]=1;
        mat[6][5]=1;

        return mat;
    }

    public static int[][] getAdjMatTask02(){
        int[][] mat=new int[7][7];

        mat[0][1]=4;
        mat[0][2]=18;
        mat[0][3]=7;
        mat[0][4]=5;
        mat[0][5]=15;
        mat[0][6]=9;
        
        mat[1][0]=4;
        mat[1][2]=21;
        mat[1][3]=8;
        mat[1][5]=2;

        mat[2][0]=18;
        mat[2][1]=21;
        mat[2][3]=9;
        mat[2][4]=13;
        mat[2][6]=7;

        mat[3][0]=7;
        mat[3][1]=8;
        mat[3][2]=9;
        mat[3][4]=6;
        mat[3][5]=7;

        mat[4][0]=5;
        mat[4][2]=13;
        mat[4][3]=6;
        mat[4][5]=8;

        mat[5][0]=15;
        mat[5][1]=2;
        mat[5][3]=7;
        mat[5][4]=8;
        mat[5][6]=12;

        mat[6][0]=9;
        mat[6][2]=7;
        mat[6][5]=12;

        return mat;
    }
    public static int[][] getAdjMatTask03(){
        int[][] mat=new int[7][7];

        mat[0][1]=4;
        mat[0][2]=18;
        mat[0][4]=5;
        mat[0][6]=9;
        
        mat[1][3]=8;
        mat[1][5]=2;

        mat[2][1]=21;
        mat[2][3]=9;
        mat[2][4]=13;
        mat[2][6]=7;

        mat[3][0]=7;
        mat[3][5]=7;

        mat[4][3]=6;

        mat[5][0]=15;
        mat[5][4]=8;
        mat[5][6]=12;

        return mat;
    }

    public static int Task02(int[][] mat){
        int[] arr=new int[mat.length];
        for(int r=0;r<mat.length;++r){
            for(int c=0;c<mat.length;++c){
                arr[r]+=mat[r][c];
            }
        }
        int msv=-1,sum=0; //Maximum sum vertex = msv
        for(int i=0;i<arr.length;++i){
            if(sum<arr[i]){
                sum=arr[i];
                msv=i;
            }
        }

        System.out.println("Maximum edge weight: "+sum);
        return msv;
    }

    public static int Task01(int[][] mat){
        int[] arr=new int[mat.length];
        for(int r=0;r<mat.length;++r){
            for(int c=0;c<mat.length;++c){
                if(mat[r][c]!=0){
                    arr[r]++;
                }
            }
        }
        int mdv=-1,degree=0; //Maximum degree vertex = mdv
        for(int i=0;i<arr.length;++i){
            if(degree<arr[i]){
                degree=arr[i];
                mdv=i;
            }
        }

        System.out.println("Vertex with maximum degree: "+mdv);
        return degree;
    }

    public static void Task03(int[][] mat){
        System.out.println("Maximum vertex's degree: "+Task01(mat));
        System.out.println("Vertex with maximum weighted edge is: "+Task02(mat));
    }

    public static int[][] Task04(int[][] mat){
        for(int r=0;r<mat.length;++r){
            for(int c=0;c<mat.length;++c){
                if(mat[r][c]!=0){
                    mat[c][r]=mat[r][c];
                }
            }
        }
        return mat;
    }

    public static void edgeShow(int[][] mat){
        int i=0;
        for(int r=0;r<mat.length;++r){
            for(int c=0;c<mat.length;++c){
                if(mat[r][c]!=0){
                    System.out.println(++i+". "+r+"->"+c+": "+mat[r][c]);
                }
            }
        }
    }

}