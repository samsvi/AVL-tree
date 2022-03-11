import static java.lang.Math.max;

public class Tree {

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






    Node insert(Node x, int key) {
        if(x == null)
            return (new Node(key));

        if(key < x.key) {

        }
        else {
            if(key > x.key) {

            }
            else
                return null;                                  // can't be eqaul
        }

    }

    public static void main(String[] args) {
        System.out.println("Hello");

    }
}
