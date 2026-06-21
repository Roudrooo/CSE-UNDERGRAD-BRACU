// Complete the subtractSummation method
public class Task5 {

    //===================================TASK#5===================================
    // This method takes only 1 parameter which is root of the given tree
    // This method returns an Integer
    // At times you may need to typeCast root.elem to Integer
    // You can use extra helper private static methods with extra extra params as per need
    public static Integer subtractSummation( BTNode root ){
        //TO DO
        return subTreeSum(root.left)-subTreeSum(root.right); //remove this line
    }
    public static Integer subTreeSum(BTNode root){
        if(root!=null) return (Integer)root.elem+subTreeSum(root.left)+subTreeSum(root.right);
        return 0;
    }
    //============================================================================

}