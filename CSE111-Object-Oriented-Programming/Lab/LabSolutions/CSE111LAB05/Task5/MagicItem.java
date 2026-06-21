public class MagicItem{
    public String name;
    public String[] item=new String[3];
    public int nrg=0;
    public void newCharacter(String s){
        name=s;
    }
    int idx=0,cnt=1;;
    int[] x={50,100,200};
    public void findItem(String s){
        if(cnt<=3){
            item[idx]=s;
            System.out.println(name+" found a "+item[idx]);
            if(idx<2){
                idx++;
            }
            cnt++;
        }else{
            System.out.println("All item slots occupied.");
            idx=0;
        }
    }
    public void displayInfo(){
        System.out.printf("Character Name: %s\nEnergy level: %d\n",name,nrg);
        for(int i=0;i<3;i++){
            System.out.printf("Item %d: %s\n",i+1,item[i]);
        }
    }
    int a=1;
    public void useItem(String s){
        if(s.equals(item[a-1])){
            System.out.println(name+" used a "+item[a-1]);
            item[a-1]=null;
            cnt--;
            nrg+=x[a-1];
            System.out.println("Energy Level after using item: "+nrg);
            a++;
        }else{
            System.out.println("Item not in inventory.");
        }
    }
}