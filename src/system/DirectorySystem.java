package system;

import static system.Command.*;
import static system.Type.*;

/**
 * Created by Thong on 10/5/2018.
 */
public class DirectorySystem {

    protected Folder rootDir = new Folder("/");


    public DirectorySystem() {

    }

    /**
     * @return
     */
    protected Folder root() {
        return this.rootDir;
    }

    /**
     * Adds a child node to the parent node.
     *
     * @param parent
     * @param child
     * @return true if successfully created; false otherwise
     */
    protected boolean addChild(Folder parent, Node child) {
        // parent must be a folder
        // parent and child instances are not the same
        if (parent.getType() == TYPE_FOLDER && parent != child) {
            parent.children.add(child);
            System.out.println("parent " + parent + " added child " + child);
        }
        return false;
    }

    /**
     * Detects whether node creates a cycle.
     *
     * @param node
     * @return true if detects a cycle in a graph including node; false if there is no cycle
     */
    protected boolean detectCycle(Node node) {
        if (node.getType() == TYPE_FILE) return false;
        // in order to detect cycles, we need to record all parents as well as children

        return false;
    }


    /**
     * Prints complete path of all nodes in the directory system.
     *
     * @param root
     */
    protected void retrieve(Node root) {
        System.out.println(root);
        if (root.getType() == TYPE_FOLDER) {
            // if is a folder, retrieve recursively
            Folder r = (Folder) root;
            for (Node n : r.getChildren()) {
                if (r.getName() == "/") { // don't add slash if parent is root
                    System.out.println("/" + n);
                } else {
                    System.out.println(r + "/" + n);
                }
            }
        }
    }


    public void execute(int cmd) {
        switch (cmd) {
            default:
                return;
            case CMD_RETRIEVE:
                this.retrieve(this.root());
                return;
            case 2:
                ExampleSystem1 ex1 = new ExampleSystem1();
                ex1.retrieve(ex1.root());
        }
    }
}

