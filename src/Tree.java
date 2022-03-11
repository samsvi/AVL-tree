import javax.swing.*;

import static java.lang.Math.max;

public class Tree {

    Node root;

    int height (Node x) {
        if(x == null)
            return 0;
        else
            return x.height;
    }

    void newHeight (Node x) {
        x.height = max(height(x.left), height(x.right))+1;
    }

    int balanceFactor(Node x) {
        if(x == null)
            return 0;
        else
            return height(x.left)-height(x.right);
    }

    /*
        left rotate
                parent                                                          newRoot
               /       \                                                       /       \
              B          newRoot                -->                        parent
                        /                                                       \
                 newRootChild                                                  newRootChild
     */


    //left rotation
    Node lrotate(Node parent) {
        Node newRoot = parent.right;
        Node newRootChild = newRoot.left;
        newRoot.left = parent;
        parent.right = newRootChild;
        newHeight(parent);
        newHeight(newRoot);
        return newRoot;
    }

    //right rotation
    Node rrotate(Node parent) {
        Node newRoot = parent.left;
        Node newRootChild = newRoot.right;
        newRoot.right = parent;
        parent.left = newRootChild;
        newHeight(parent);
        newHeight(newRoot);
        return newRoot;
    }

    Node rebalance(Node x) {
        if(balanceFactor(x) < -1) {
            if(balanceFactor(x.left) <= 0) {
                rrotate(x);
            }
            else {
                x.left = lrotate(x.left);
                x = rrotate(x);
            }
        }
        else {
            if(balanceFactor(x) > 1) {
                if(balanceFactor(x.right) >= 0) {
                    lrotate(x);
                }
                else {
                    x.right = rrotate(x.right);
                    x = lrotate(x);
                }
            }
        }
            return x;

    }




    Node insert(Node x, int key) {
        if(x == null)
            return new Node(key);

        if(key < x.key) {
            x.left = insert(x.left, key);
        }
        else {
            if(key > x.key) {
                x.right = insert(x.right, key);
            }
            else
                return x;                                  // can't be eqaul
        }
        newHeight(x);
        return rebalance(x);
    }

    void preOrder(Node node)
    {
        if (node != null)
        {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /*


    Node delete() {

    }

    Node search() {

    }
*/
    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 7);


        tree.preOrder(tree.root);
    }
}
