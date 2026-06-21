// Complete the sumOfLeaves method
public class Task2 {

    //===================================TASK#2===================================
    // This method takes only 2 parameters
    // 1st one is root
    // 2nd one is an Integer
    // You'll need to find the path from the root to a node containing the Integer
    // return the path as a String
    public static String findPath( BSTNode root, Integer key ){
        if(root==null) return "No Path Found";
        if(root.elem==key){
            return ""+key;
        }
        String path;
        if(key<root.elem){
            path=findPath(root.left,key);
        }else{
            path=findPath(root.right,key);
        }
        if(path=="No Path Found"){
            return path;
        }else{
            return root.elem+" "+path;
        }
    }
    //============================================================================

}
