package system;

import static system.Type.TYPE_DIR;

/**
 * Created by Thong on 10/5/2018.
 */
public class DirectorySystem {

    private Node rootDir = new Node("/", TYPE_DIR);


    public DirectorySystem (){

    }

    /**
     * @return
     */
    Node root() {
        return this.rootDir;
    }

    /**
     * Adds a child node to the parent node.
     *
     * @param parent
     * @param child
     * @return true if successfully created; false otherwise
     */
    boolean addChild(Node parent, Node child) {
        return false;
    }

    /**
     * Detects whether node is both a parent and a child of another node.
     *
     * @param node
     * @return true if detects a cycle in a graph including node; false if there is no cycle
     */
    boolean detectCycle(Node node) {
        return false;
    }

    void retrieve(Node root) {
        System.out.println(this.root());
    }
}

