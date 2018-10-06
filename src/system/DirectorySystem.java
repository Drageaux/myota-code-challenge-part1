package system;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

import static system.Command.*;
import static system.Type.*;


public class DirectorySystem {

    protected Folder rootDir = new Folder("/");


    public DirectorySystem() {

    }

    /**
     * @return the root folder Node
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
        if (parent.getType() == TYPE_DIR && parent != child) {

            // TODO: need BFS
            if (child.getType() == TYPE_DIR) {
                Folder childFolder = (Folder) child;
                if (this.childrenBreadFirstSearch(parent)) {
                    System.out.println("STOP, found duplicate");
                    return false;
                }
            }

            parent.children.add(child);
            System.out.println("parent " + parent + " added child " + child);
        } else {
            System.out.println("parent " + parent + " is not a folder or is the same as child " + child);
        }
        return false;
    }

    protected boolean childrenBreadFirstSearch(Node node) {
        // for each child of startingNode, add child to queue
        //  once all node are added, remove node from head of queue
        //  update startingNode to be what is head of queue

        HashSet<Node> visited = new HashSet<Node>();
        Queue<Node> q = new LinkedList<Node>();

        q.add(node);

        while (q.size() != 0) {
            Node currTop = q.poll();
            System.out.println("queuing " + currTop);

            if (node.getType() == TYPE_DIR) {
                Folder folder = (Folder) currTop; // type cast to get children
                // list all child folders
                for (Node n :
                        (List<Node>) folder.getChildren()
                                .stream()
                                .filter(x -> x.getType() == TYPE_DIR)
                        ) {
                    if (n == node) {
                        System.out.println("STOP, found match");
                        return true;
                    } else {
                        visited.add(folder);
                        q.add(n);
                    }
                }
            }
        }


        return false;
    }


    /**
     * Detects whether node creates a cycle (only folders can create cycles).
     * (NOTE: suffers in performance as both numbers of parents and children increase)
     *
     * @param node
     * @return true if detects a cycle in a graph including node; false if there is no cycle
     */
    protected boolean detectCycle(Node node) {
        if (node.getType() == TYPE_FILE) {
            // FIXME: not sure if this is 100% true; not specified in requirements; could be implied
            System.out.println(node + " is a file and cannot create cycle");
            return false;
        } else if (node.getType() == TYPE_DIR) {
            Folder folder = (Folder) node;
            folder.children.contains(node);
        }

        return false;
    }


    /**
     * Prints complete path of all nodes in the directory system.
     * (NOTE: the restraints of this method, such as return type and arg type makes it a bad candidate for recursion)
     *
     * @param root
     */
    protected void retrieve(Node root) {
        String results = this.getRootStructure(this.root());
        System.out.println(results + "\nDone");
    }


    private String getRootStructure(Folder root) {
        String results = "";
        // add to String array
        // each String is a full path
        // to find each String, follow each node to the end
        List<String> resultsList = new ArrayList<String>();

        resultsList.add("/");
        // root level's children
        for (Node n : root.getChildren()) {
            resultsList.add("/" + n);
            resultsList.addAll(this.getChildRecursive(n, "/" + n + "/"));
        }

        // loop resultList to compile a String type result
        for (String s : resultsList) {
            results += "\n" + s;
        }
        return results;
    }


    private List<String> getChildRecursive(Node parent, String prefix) {
        List<String> resultList = new ArrayList<String>();

        if (parent.getType() == TYPE_DIR) {
            // type casting to allow parent to getChildren()
            Folder p = (Folder) parent;
            for (Node n : p.getChildren()) {
                resultList.add(prefix + n);
                resultList.addAll(getChildRecursive(n, prefix + n + "/")); // FIXME: potential stack overflow if node structure not optimized
            }
        }

        return resultList;
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
                return;
            case 3:
                ExampleSystem2 ex2 = new ExampleSystem2();
                ex2.retrieve(ex2.root());
                return;
        }
    }
}

