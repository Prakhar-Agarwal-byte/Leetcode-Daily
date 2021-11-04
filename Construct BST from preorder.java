class Solution {
    int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
    private TreeNode dfs(int[] preorder, int min, int max) {
        if (idx < 0 || idx >= preorder.length) return null;
        if (preorder[idx] <= min || preorder[idx] >= max) return null;
        TreeNode node = new TreeNode(preorder[idx++]);
        node.left = dfs(preorder, min, node.val);
        node.right = dfs(preorder, node.val, max);
        return node;
    }
}
