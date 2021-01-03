//二叉树的最近公共祖先
class Solution {

    private TreeNode ans;

    public Solution() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        } 
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
}

//从前序与中序遍历序列构造二叉树
class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length==0 || inorder.length==0) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[0]);
		for(int i=0;i<preorder.length;++i) {
			if(preorder[0]==inorder[i]) {
				int[] pre_left = Arrays.copyOfRange(preorder,1,i+1);
				int[] pre_right = Arrays.copyOfRange(preorder,i+1,preorder.length);
				int[] in_left = Arrays.copyOfRange(inorder,0,i);
				int[] in_right = Arrays.copyOfRange(inorder,i+1,inorder.length);
				root.left = buildTree(pre_left,in_left);
				root.right = buildTree(pre_right,in_right);
				break;
			}
		}
		return root;
	}
}
