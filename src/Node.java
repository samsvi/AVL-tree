import static java.lang.Math.max;


public class Node {
    int height, key;
    Node left, right;

    Node (int k) {

    }
}

public class Tree {

    int height (Node x) {
        if(x == null)
            return null;
        return x.height;

    }

    void newHeight (Node x) {
        x.height = max(height(x.left), height(x.right));
    }

    /*
        left rotate
                parent
               /       \
              B          newRoot                -->
             / \          /       \
            C   D      newRootChild   A
     */

    Node lrotate(Node parent) {
       Node newRoot = parent.right;
       Node newRootChild = newRoot.left;
       newRoot.left = parent;
       parent.right = newRootChild;
       newHeight(parent);
       newHeight(newRoot);
       return newRoot;
    }

    Node rrotate(Node parent) {
        Node newRoot = parent.left;
        Node newRootChild = newRoot.right;
        newRoot.right = parent;
        parent.left = newRootChild;
        newHeight(parent);
        newHeight(newRoot);
        return newRoot;
    }

    Node insert(Node x, int key) {
        if(x == null)
            return (new Node(key));

        if(key < x.key) {

        }

    }
}
