public class TreeNode<T extends Comparable<T>> {

    private T data;
    private TreeNode<T> parent;
    private TreeNode<T> left;
    private TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
        if (this.left != null) {
            this.left.parent = this;
        }
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
        if (this.right != null) {
            this.right.parent = this;
        }
    }


    public boolean isLeftChild() {
        if (parent == null) {
            return false;
        }
        return this == parent.left;
    }

    public boolean isRightChild() {
        if (parent == null) {
            return false;
        }
        return this == parent.right;
    }

    @Override
    public String toString() {
        return "TreeNode [data=" + data +
                ", parent=" + (parent == null ? null : parent.data) +
                ", left=" + (left == null ? null : left.data) +
                ", right=" + (right == null ? null : right.data) + "]";
    }

}