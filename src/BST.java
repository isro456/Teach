import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BST 
{
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        if (root.val > val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) return new TreeNode(val); 
    
    if (root.val > val) 
        root.left = insertIntoBST(root.left, val);
    else 
        root.right = insertIntoBST(root.right, val);
    
    return root;
}
    public int rangeSumBST(TreeNode root, int low, int high) 
    {
        if(root == null) return 0;
        int sum = 0;

        if(root.val >=  low  && root.val <= high) sum += root.val;
        if(root.val > low) sum += rangeSumBST(root.left, low, high);
        if(root.val < high) sum += rangeSumBST(root.right, low, high);

        return sum;

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root == null) return null;
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        else return root;
    }
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        collect(root, values);           
        Collections.sort(values);        
        
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            int diff = values.get(i) - values.get(i - 1);
            minDiff = Math.min(minDiff, diff);
        }
        
        return minDiff;
    }
    
    private void collect(TreeNode node, List<Integer> values) {
        if (node == null) return;
        values.add(node.val);
        collect(node.left, values);
        collect(node.right, values);
    }
    
}
