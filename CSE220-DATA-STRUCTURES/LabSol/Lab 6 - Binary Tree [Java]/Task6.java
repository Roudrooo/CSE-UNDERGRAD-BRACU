// Complete the levelSum method
public class Task6 {

    //===================================TASK#6===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per need
    public static Integer levelSum( BTNode root ){
        //TO DO
        return signSum(root,0); //remove this line
    }
    public static Integer signSum(BTNode root, int lvl){
        if(root!=null){
            Integer sign;
            if(lvl%2==0) sign=-1;
            else sign=1;
            return sign*(Integer)root.elem+signSum(root.left,lvl+1)+signSum(root.right,lvl+1);
        }
        return 0;
    }
    //============================================================================

}