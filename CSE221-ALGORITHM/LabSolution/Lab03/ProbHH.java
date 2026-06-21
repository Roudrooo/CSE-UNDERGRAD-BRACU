import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class ProbHH {
    static int postCur;
    static int[] inorder, postorder;

    static class Node {
        int val; Node left, right;
        Node(int val) { this.val = val; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int n=Integer.parseInt(br.readLine());
        inorder=new int[n]; postorder=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        int idx=0;
        while(st.hasMoreTokens()) inorder[idx++]=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        idx=0;
        while(st.hasMoreTokens()) postorder[idx++]=Integer.parseInt(st.nextToken());

        postCur=n-1;
        Node root=constructTree(0,n-1);
        printPreorder(root,pw);
        pw.println();
        pw.close();
    }

    static Node constructTree(int start, int end) {
        if(start > end) return null;
        int rootVal = postorder[postCur--];
        Node root = new Node(rootVal);

        int split = findIndex(inorder, start, end, rootVal);
        // Build right subtree first because postorder last is root
        root.right = constructTree(split + 1, end);
        root.left = constructTree(start, split - 1);
        return root;
    }

    static int findIndex(int[] arr, int left, int right, int target) {
        int i = left;
        while(i <= right) {
            if(arr[i] == target) return i;
            i++;
        }
        return -1; // should never happen
    }

    static void printPreorder(Node root, PrintWriter pw) {
        if(root == null) return;
        pw.print(root.val + " ");
        printPreorder(root.left, pw);
        printPreorder(root.right, pw);
    }
}