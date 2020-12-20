public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public void buildTree(T[] datas) {
        for (int i = 0; i < datas.length; i++) {
            insert(datas[i]);
        }
    }

    public TreeNode<T> get(T data) {
        TreeNode<T> current = root;
        while (current != null && data.compareTo(current.getData()) != 0) {
            if (data.compareTo(current.getData()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return current;
    }

    public TreeNode<T> getMin() {
        return getMin(root);
    }

    private TreeNode<T> getMin(TreeNode<T> treeNode) {
        while (treeNode.getLeft() != null) {
            treeNode = treeNode.getLeft();
        }
        return treeNode;
    }

    public TreeNode<T> getMax() {
        return getMax(root);
    }

    private TreeNode<T> getMax(TreeNode<T> treeNode) {
        while (treeNode.getRight() != null) {
            treeNode = treeNode.getRight();
        }
        return treeNode;
    }

    public TreeNode<T> getSuccessor(T data) {
        TreeNode<T> current = get(data);
        if (current == null) {
            return null;
        }

        if (current.getRight() != null) {
            return getMin(current.getRight());
        }

        TreeNode<T> parent = current.getParent();
        while (parent != null && current.isRightChild()) {
            current = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    public TreeNode<T> getPredecessor(T data) {
        TreeNode<T> current = get(data);
        if (current == null) {
            return null;
        }
        if (current.getLeft() != null) {
            return getMax(current.getLeft());
        }

        TreeNode<T> parent = current.getParent();
        while (parent != null && current.isLeftChild()) {
            current = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    public void insert(T data) {
        TreeNode<T> insertNode = new TreeNode<>(data);
        TreeNode<T> parent = null;
        TreeNode<T> current = root;
        while (current != null) {
            parent = current;
            if (data.compareTo(current.getData()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        if (parent == null) {
            root = insertNode;
        } else if (insertNode.getData().compareTo(parent.getData()) < 0) {
            parent.setLeft(insertNode);
        } else {
            parent.setRight(insertNode);
        }
    }

    public boolean delete(T data) {
        TreeNode<T> deleteNode = get(data);
        if (deleteNode == null) {
            return false;
        }
        if (deleteNode.getLeft() == null) {
            transplant(deleteNode, deleteNode.getRight());
        } else if (deleteNode.getRight() == null) {
            transplant(deleteNode, deleteNode.getLeft());
        } else {
            TreeNode<T> successor = getMin(deleteNode.getRight());
            if (successor.getParent() != deleteNode) {
                transplant(successor, successor.getRight());
                successor.setRight(deleteNode.getRight());
            }
            transplant(deleteNode, successor);
            successor.setLeft(deleteNode.getLeft());
        }
        return true;
    }

    private void transplant(TreeNode<T> oldNode, TreeNode<T> newNode) {
        if (oldNode.getParent() == null) {
            root = newNode;
        } else if (oldNode.isLeftChild()) {
            oldNode.getParent().setLeft(newNode);
        } else {
            oldNode.getParent().setRight(newNode);
        }
    }

    public void printTree() {
        inorderTraversal(root);
    }

    public void inorderTraversal(TreeNode<T> root) {
        if (root == null) return;
        inorderTraversal(root.getLeft());
        System.out.print(root.getData() + " ");
        inorderTraversal(root.getRight());
    }

}