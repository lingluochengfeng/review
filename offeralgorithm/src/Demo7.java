/**
 * 重建二叉树
 * 题目描述：输入某二叉树的前序遍历和中序遍历的结果，请重新构造出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中不包含重复的数字。
 * 例如输入的前序遍历序列为｛1，2，4，7，3，5，6，8｝和中序遍历为{4,7,2,1,5,3,6,8},则重建出二叉树并输出它的头结点。
 *
 * 在二叉树的前序遍历序列中，第一个数字总是树的根节点的值。但在中序遍历中，根节点的值在序列的中间，
 * 左子树的结点的值位于根节点的值的左边，而右子树的结点的值位于根节点的右边。因此我们需要扫描中序遍历序列，
 * 才能找到根节点的值。
 * @author ASUS
 * @since 2018-12-05 20:31
 */
public class Demo7 {
    public static void main(String[] args) {
        //二叉树的先序序列
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        //二叉树的中序序列
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = reconstructe(preOrder, inOrder);
        printPostOrder(root); //后序打印二叉树
    }

    /**
     * 根据前序和中序序列完成二叉树的重建
     * @param preOrder 前序遍历序列
     * @param inOrder 中序遍历序列
     * @return
     */
    public static BinaryTreeNode reconstructe(int[] preOrder, int[] inOrder){
        if (preOrder == null || inOrder == null
                || preOrder.length == 0 || inOrder.length == 0){
            return null;
        }

        //二叉树根节点
        BinaryTreeNode root = new BinaryTreeNode(preOrder[0]);
        root.left = root.right = null;

        //左子树个数
        int leftNum = 0;
        for (int i = 0; i < inOrder.length; i++){
            if (root.val == inOrder[i]){
                break;
            }else {
                leftNum++;
            }
        }

        //右子树个数
        int rightNum = inOrder.length - 1 - leftNum;

        //重建左子树
        if (leftNum > 0){
            //左子树先序序列
            int[] leftPreOrder = new int[leftNum];
            //左子树的中序序列
            int[] leftInOrder = new int[leftNum];
            for (int i = 0; i < leftNum; i++){
                leftPreOrder[i] = preOrder[i + 1];
                leftInOrder[i] = inOrder[i];
            }
            BinaryTreeNode leftRoot = reconstructe(leftPreOrder, leftInOrder);
            root.left = leftRoot;
        }

        //重建右子树
        if (rightNum > 0){
            //右子树先序序列
            int[] rightPreOrder = new int[rightNum];
            //右子树中序序列
            int[] rightInOrder = new int[rightNum];

            for (int i = 0; i < rightNum; i++){
                rightPreOrder[i] = preOrder[leftNum + 1 + i];
                rightInOrder[i] = inOrder[leftNum + 1 + i];
            }
            BinaryTreeNode rightRoot = reconstructe(rightPreOrder, rightInOrder); //递归构建右子树
            root.right = rightRoot;
        }
        return root;
    }

    /**
     * 后序遍历二叉树（递归实现）
     * @param root
     */
    public static void printPostOrder(BinaryTreeNode root){
        if (root != null){
            printPostOrder(root.left);
            printPostOrder(root.right);
            System.out.println(root.val);
        }
    }
}

class BinaryTreeNode{
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode(int x){
        val = x;
    }
}
