/**
 * 
 */
package binarytree;

import java.util.ArrayList;

/**
 * @author MAAG
 *
 */
public interface IBinarySearchTree<K, V> {

	void insert(K id, V value);
	
	V delete(K id);
	
	V find(K id);
	
	int count();
	
	boolean isEmpty();
	
	ArrayList<V> getElements();
	
	void inOrder(ITreeTraversal<K> traversal);
	
	void preOrder(ITreeTraversal<K> traversal);
	
	void postOrder(ITreeTraversal<K> traversal);
	
}
