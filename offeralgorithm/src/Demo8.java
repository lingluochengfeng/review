/**
 * 二叉树的下一个节点
 * 题目：给定一颗二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右节点，还有一个指向父节点。
 * 如：一个二叉树的中序遍历序列是：{d,b,h,e,i,a,f,c,g}
 * @author ASUS
 * @since 2018-12-06 21:15
 */
public class Demo8 {

    //不通过
    public BinaryTreeNode getNextNode(BinaryTreeNode pNode){
        if (pNode == null)
            return null;

        BinaryTreeNode tempNode = null;

        //如果该节点有右节点
        if (pNode.right != null){
            tempNode = pNode.right;
            while (tempNode.left != null){
                tempNode = tempNode.left;
            }
        }

        //如果该节点没有右节点，它是其父节点的左子节点
        if (pNode.parent == null){
            return null;
        }
        if (pNode.parent.left == pNode){
            return pNode.parent;
        }

        //如果该节点没有右子节点，它是其父节点的右子节点
        tempNode = pNode.parent;
        while (tempNode.parent != null){
            if (pNode.parent.left == tempNode){
                return tempNode.parent;
            }
            //继续向上寻找父节点
            tempNode = tempNode.parent;
        }
        return null;
    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/9023a0c988684a53960365b889ceaf5e
     来源：牛客网
     */
    TreeLinkNode GetNext(TreeLinkNode node) {
        if(node==null) return null;
        if(node.right!=null){    //如果有右子树，则找右子树的最左节点
            node = node.right;
            while(node.left!=null) node = node.left;
            return node;
        }
        while(node.next!=null){ //没右子树，则找第一个当前节点是父节点左孩子的节点
            if(node.next.left==node) return node.next;
            node = node.next;
        }
        return null;   //退到了根节点仍没找到，则返回null
    }

}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}



