package binarytree;

/**
 *
 * @author Herber Sebastián Silva Muñoz
 */
public class BinaryTreeNode<K, V> {

    private K key;
    private V value;
    private BinaryTreeNode<K, V> parent;
    private BinaryTreeNode<K, V> left;
    private BinaryTreeNode<K, V> right;

    public BinaryTreeNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public BinaryTreeNode<K, V> getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode<K, V> parent) {
        this.parent = parent;
    }

    public BinaryTreeNode<K, V> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<K, V> left) {
        this.left = left;
    }

    public BinaryTreeNode<K, V> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<K, V> right) {
        this.right = right;
    }
    
    
}
