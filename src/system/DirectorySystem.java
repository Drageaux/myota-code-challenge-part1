package system;

import java.util.ArrayList;
import java.util.List;

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
     * (NOTE: the restraint that this method returns
     *
     * @param root
     */
    protected void retrieve(Node root) {

        // add root, go through each child
        // each child will append its child, meaning no longer self

//        if (root.getType() == TYPE_FOLDER) {
//            // if is a folder, retrieve recursively
//            Folder r = (Folder) root;
//            if (root.getName() == "/") { // exclusive line for root
//                System.out.println("/");
//                for (Node n : r.getChildren()) {
//                    System.out.println("/" + n);
//                    this.retrieve(n); // then add each child
//                }
//            } else {
//                for (Node n : r.getChildren()) {
//                    System.out.print("/"); // prefix with a single slash only
//                    System.out.print(n);
//                    this.retrieve(n);
//                    System.out.println("/" + n);
//                }
//            }
//        } else if (root.getType() == TYPE_FILE) {
//
//            System.out.println("/" + root);
//        }
    }

    private String getChildRecursive(Node parent, String prefix) {
        String results = parent.toString();
        // add to String array
        // each String is a full path
        // to find each String, follow each node to the end
        List<String> resultList = new ArrayList<String>();

        if (parent.getType() == TYPE_FOLDER){

        }

        return "";
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

