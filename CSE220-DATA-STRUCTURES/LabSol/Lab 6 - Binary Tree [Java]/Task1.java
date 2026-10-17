// Complete the convertMirror method
public class Task1 {

    //======================TASK#1======================
    // This method takes only 1 parameter which is root
    // You'll need to create a new Mirrored Tree and return the new root
    public static BTNode convertMirror( BTNode root ){
        // TO DO
        if(root!=null){
            BTNode left=root.left,right=root.right;
            root.left=right;
            root.right=left;
            convertMirror(left); 
            convertMirror(right);
            return root;
        }
        return null;  //remove this line
    }
    //==================================================

}
