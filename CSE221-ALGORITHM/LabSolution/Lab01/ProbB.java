import java.util.Scanner;

public class ProbB{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int T=input.nextInt();
        input.nextLine();
        for(int i=0;i<T;++i){
            String S=input.nextLine();
            int j=S.length()-1;
            String y="",x="";
            while(j>-1&&S.charAt(j)!=' '){
                y=S.charAt(j--)+y;
            }
            int oprnIdx=--j;
            j-=2;
            while(j>-1&&S.charAt(j)!=' '){
                x=S.charAt(j--)+x;
            }
            Integer X=Integer.parseInt(x),Y=Integer.parseInt(y);
            switch(S.charAt(oprnIdx)){
                case '+': 
                    System.out.printf("%f\n",(double)X+Y);
                    break;
                case '-': 
                    System.out.printf("%f\n",(double)X-Y);
                    break;
                case '*': 
                    System.out.printf("%f\n",(double)X*Y);
                    break;
                case '/': 
                    System.out.printf("%f\n",(double)X/Y);
                    break;
            }
        }
        input.close();
    }
}