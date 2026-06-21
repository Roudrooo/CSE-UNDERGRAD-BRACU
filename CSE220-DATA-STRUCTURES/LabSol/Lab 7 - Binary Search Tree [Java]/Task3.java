// Complete the sumOfLeaves method
public class Task3 {

    //===================================TASK#3======================
    // This method takes only 2 parameters
    // 1st one is root
    // 2nd one is the sum initiliazed as 0
    // You'll need to return the sum of the leaf nodes
    public static Integer sumOfLeaves( BSTNode root, Integer sum ){
        if(root!=null){
            if(root.left==null&&root.right==null){
                return sum+root.elem;
            }
            Integer initial=sumOfLeaves(root.left,sum);
            Integer total=sumOfLeaves(root.right,initial);
            return total;
        }
        return sum;
    }
    //===============================================================

}
