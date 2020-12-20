public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Integer[] iArray = new Integer[] { 1, 2, 5, 6, 8, 7, 9, 4 };
        tree.buildTree(iArray);
        tree.printTree(); System.out.println();
        tree.delete(6);
        tree.printTree(); System.out.println();
        tree.insert(3);
        tree.printTree(); System.out.println();
    }

}