public class Graph{
    public static void main(String[] args){

        // TASK01_MAT
        System.out.println("TASK01_MAT  TASK01_MAT  TASK01_MAT\n");
        int[][] mat1=getAdjMatTask01();

        System.out.println("Maximum edge: "+Task01_MAT(mat1));

        // TASK02_MAT
        System.out.println("\n\nTASK02_MAT  TASK02_MAT  TASK02_MAT\n");

        int[][] mat2=getAdjMatTask02();

        System.out.println("Vertex with maximum edge weight: "+Task02_MAT(mat2));
        
        // TASK03_MAT
        System.out.println("\n\nTASK03_MAT  TASK03_MAT  TASK03_MAT\n");

        int[][] mat3=getAdjMatTask03();

        Task03_MAT(mat3);

        // TASK04_MAT
        System.out.println("\n\nTASK04_MAT  TASK04_MAT  TASK04_MAT\n");
        edgeShow(mat3);
        System.out.println();
        System.out.println();
        int[][] mat4=Task04_MAT(mat3);
        System.out.println("\nCHECKING IF CONVERSION IS SUCCESSFUL OR NOT.\n");
        edgeShow(mat4);

        // TASK01_LIST
        System.out.println("\n\nTASK01_LIST  TASK01_LIST  TASK01_LIST\n");
        
        Edge[] list1=getAdjLLTask01();

        System.out.println("Maximum edge: "+Task01_LIST(list1));
        
        // TASK02_LIST
        System.out.println("\n\nTASK02_LIST  TASK02_LIST  TASK02_LIST\n");
        
        Edge[] list2=getAdjLLTask02();

        System.out.println("Vertex with maximum edge weight: "+Task02_LIST(list2));

        // TASK03_LIST
        System.out.println("\n\nTASK03_MAT  TASK03_MAT  TASK03_MAT\n");

        Edge[] list3=getAdjLLTask03();

        Task03_LIST(list3);

        // TASK04_LIST
        System.out.println("\n\nTASK04_LIST  TASK04_LIST  TASK04_LIST\n");
        edgeShow(list3);
        System.out.println();
        System.out.println();
        Edge[] list4=Task04_LIST(list3);
        System.out.println("\nCHECKING IF CONVERSION IS SUCCESSFUL OR NOT.\n");
        edgeShow(list4);
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

    public static Edge[] getAdjLLTask01(){
        Edge[] list=new Edge[7];

        list[0]=new Edge(0,1);
        list[0].next=new Edge(0,2);
        list[0].next.next=new Edge(0,3);
        list[0].next.next.next=new Edge(0,4);
        list[0].next.next.next.next=new Edge(0,5);
        list[0].next.next.next.next.next=new Edge(0,6);

        list[1]=new Edge(1,0);
        list[1].next=new Edge(1,2);
        list[1].next.next=new Edge(1,3);
        list[1].next.next.next=new Edge(1,5);

        list[2]=new Edge(2,0);
        list[2].next=new Edge(2,1);
        list[2].next.next=new Edge(2,3);
        list[2].next.next.next=new Edge(2,4);
        list[2].next.next.next.next=new Edge(2,6);

        list[3]=new Edge(3,0);
        list[3].next=new Edge(3,1);
        list[3].next.next=new Edge(3,2);
        list[3].next.next.next=new Edge(3,4);
        list[3].next.next.next.next=new Edge(3,5);

        list[4]=new Edge(4,0);
        list[4].next=new Edge(4,2);
        list[4].next.next=new Edge(4,3);
        list[4].next.next.next=new Edge(4,5);

        list[5]=new Edge(5,0);
        list[5].next=new Edge(5,1);
        list[5].next.next=new Edge(5,3);
        list[5].next.next.next=new Edge(5,4);
        list[5].next.next.next.next=new Edge(5,6);

        list[6]=new Edge(6,0);
        list[6].next=new Edge(6,2);
        list[6].next.next=new Edge(6,5);

        return list;
    }

    public static Edge[] getAdjLLTask02(){
        Edge[] list=new Edge[7];

        list[0]=new Edge(0,1,4);
        list[0].next=new Edge(0,2,18);
        list[0].next.next=new Edge(0,3,7);
        list[0].next.next.next=new Edge(0,4,5);
        list[0].next.next.next.next=new Edge(0,5,15);
        list[0].next.next.next.next.next=new Edge(0,6,9);

        list[1]=new Edge(1,0,4);
        list[1].next=new Edge(1,2,21);
        list[1].next.next=new Edge(1,3,8);
        list[1].next.next.next=new Edge(1,5,2);

        list[2]=new Edge(2,0,18);
        list[2].next=new Edge(2,1,21);
        list[2].next.next=new Edge(2,3,9);
        list[2].next.next.next=new Edge(2,4,13);
        list[2].next.next.next.next=new Edge(2,6,7);

        list[3]=new Edge(3,0,7);
        list[3].next=new Edge(3,1,8);
        list[3].next.next=new Edge(3,2,9);
        list[3].next.next.next=new Edge(3,4,6);
        list[3].next.next.next.next=new Edge(3,5,7);

        list[4]=new Edge(4,0,5);
        list[4].next=new Edge(4,2,13);
        list[4].next.next=new Edge(4,3,6);
        list[4].next.next.next=new Edge(4,5,8);

        list[5]=new Edge(5,0,15);
        list[5].next=new Edge(5,1,2);
        list[5].next.next=new Edge(5,3,7);
        list[5].next.next.next=new Edge(5,4,8);
        list[5].next.next.next.next=new Edge(5,6,12);

        list[6]=new Edge(6,0,9);
        list[6].next=new Edge(6,2,7);
        list[6].next.next=new Edge(6,5,12);

        return list;
    }

    public static Edge[] getAdjLLTask03(){
        Edge[] list=new Edge[7];

        list[0]=new Edge(0,1,4);
        list[0].next=new Edge(0,2,18);
        list[0].next.next=new Edge(0,4,5);
        list[0].next.next.next=new Edge(0,6,9);

        list[1]=new Edge(1,3,8);
        list[1].next=new Edge(1,5,2);

        list[2]=new Edge(2,1,21);
        list[2].next=new Edge(2,3,9);
        list[2].next.next=new Edge(2,4,13);
        list[2].next.next.next=new Edge(2,6,7);

        list[3]=new Edge(3,0,7);
        list[3].next=new Edge(3,5,7);

        list[4]=new Edge(4,3,6);

        list[5]=new Edge(5,0,15);
        list[5].next=new Edge(5,4,8);
        list[5].next.next=new Edge(5,6,12);

        return list;
    }

    public static int Task01_MAT(int[][] mat){
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
    
    public static int Task02_MAT(int[][] mat){
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

    public static void Task03_MAT(int[][] mat){
        System.out.println("Maximum vertex's degree: "+Task01_MAT(mat));
        System.out.println("Vertex with maximum weighted edge is: "+Task02_MAT(mat));
    }

    public static int[][] Task04_MAT(int[][] mat){
        for(int r=0;r<mat.length;++r){
            for(int c=0;c<mat.length;++c){
                if(mat[r][c]!=0){
                    mat[c][r]=mat[r][c];
                }
            }
        }
        System.out.println("CONVERTED.");
        return mat;
    }

    public static int Task01_LIST(Edge[] list){
        int[] arr=new int[list.length];
        for(int i=0;i<list.length;++i){
            Edge temp=list[i];
            while(temp!=null){
                if(temp.weight!=0){
                    arr[i]++;
                }
                temp=temp.next;
            }
        }
        int mdv=-1,degree=0; 
        for(int i=0;i<arr.length;++i){
            if(degree<arr[i]){
                degree=arr[i];
                mdv=i;
            }
        }
        System.out.println("Vertex with maximum degree: "+mdv);
        return degree;
    }

    public static int Task02_LIST(Edge[] list){
        int[] arr=new int[list.length];
        for(int i=0;i<list.length;++i){
            Edge temp=list[i];
            while(temp!=null){
                if(temp.weight!=0){
                    arr[i]+=temp.weight;
                }
                temp=temp.next;
            }
        }
        int msv=-1,sum=0; 
        for(int i=0;i<arr.length;++i){
            if(sum<arr[i]){
                sum=arr[i];
                msv=i;
            }
        }
        System.out.println("Maximum edge weight: "+sum);
        return msv;
    }

    public static void Task03_LIST(Edge[] list){
        System.out.println("Maximum vertex's degree: "+Task01_LIST(list));
        System.out.println("Vertex with maximum weighted edge is: "+Task02_LIST(list));
    }

    public static Edge[] Task04_LIST(Edge[] list){
        for(int r=0;r<list.length;++r){
            Edge temp=list[r];
            while(temp!=null){
                boolean flag=false;
                Edge temp2=list[temp.des];
                while(temp2!=null){
                    if(r==temp2.des){
                        flag=true;
                        break;
                    }
                    temp2=temp2.next;
                }
                temp2=list[temp.des];
                if(!flag){
                    if(list[temp.des]!=null){
                        while(temp2.next!=null) temp2=temp2.next;
                        temp2.next=new Edge(temp.des,r,temp.weight);
                    }else{
                        list[temp.des]=new Edge(temp.des,r,temp.weight);
                    }
                }
                temp=temp.next;
            }
        }
        return list;
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

    public static void edgeShow(Edge[] list){
        int i=0;
        for(int r=0;r<list.length;++r){
            Edge temp=list[r];
            while(temp!=null){
                if(temp.weight!=0){
                    System.out.println(++i+". "+r+"->"+temp.des+": "+temp.weight);
                }
                temp=temp.next;
            }
        }
    }

}