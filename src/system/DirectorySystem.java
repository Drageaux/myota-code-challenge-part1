package system;

import java.util.*;
import java.util.stream.Collectors;

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
     * Adds a child node to the parent node, without adding illegal arrows.
     *
     * @param parent
     * @param child
     * @return true if successfully created; false otherwise
     */
    protected boolean addChild(Folder parent, Node child) {
        // parent must be a folder
        // parent and child instances are not the same
        if (parent.getType() == TYPE_DIR && parent != child) {

            // BFS to find duplicate
            if (child.getType() == TYPE_DIR) {
                if (this.childrenBreadthFirstSearch(parent, child)) {
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


    /**
     * Detects whether node creates a cycle (only folders can create cycles).
     * If the node find itself in any of its children's paths, then it's a cycle.
     * (NOTE: suffers in performance as both numbers of parents and children increase)
     *
     * @param node
     * @return true if detects a cycle in a graph including node; false if there is no cycle
     */
    protected boolean detectCycle(Node node) {
        if (node.getType() == TYPE_FILE) {
            // not sure if this is 100% true; not specified in requirements; could be implied
            System.out.println(node + " is a file and cannot create cycle");
            return false;
        } else if (node.getType() == TYPE_DIR) {
            if (this.childrenBreadthFirstSearch(node, node)) {
                System.out.println("Yes. Node " + node + " creates a cycle.");
                return true;
            }
        }

        System.out.println("No. Node " + node + " does NOT create a cycle.");
        return false;
    }


    /**
     * Breadth-first search if parent is in any of child's children (recursively).
     *
     * @param parent
     * @param child
     * @return true if parent in children's path; false otherwise
     */
    protected boolean childrenBreadthFirstSearch(Node parent, Node child) {
        // for each child of startingNode, add child to queue
        //  once all node are added, remove node from head of queue
        //  update startingNode to be what is head of queue

        HashSet<Node> visited = new HashSet<Node>();
        Queue<Node> q = new LinkedList<Node>();

        q.add(child);

        while (q.size() != 0) {
            Node currTop = q.poll();
            System.out.println("queuing " + currTop);

            if (child.getType() == TYPE_DIR) {
                Folder folder = (Folder) currTop; // type cast to get children

                // list all child folders in a stream; fancy code
                for (Node n : folder.getChildren()
                        .stream()
                        .filter(x -> x.getType() == TYPE_DIR)
                        .collect(Collectors.toList())) {
                    if (n == parent) {
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
     * Prints complete path of all nodes in the directory system.
     * (NOTE: the restraints of this method, such as return type and arg type makes it a bad candidate for recursion)
     *
     * @param root
     */
    protected void retrieve(Node root) {
        System.out.println("\nExecuting...");
        String results = this.getRootStructure(this.root());
        System.out.println(results + "\n\nDone!");
    }


    /**
     * Get all children for root, then return a new-line-separated list of children paths.
     *
     * @param root
     * @return
     */
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


    /**
     * Compile an array of paths recursively.
     * (NOTE: could potentially be done with BFS, which didn't come to mind)
     *
     * @param parent
     * @param prefix
     * @return
     */
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


    /**
     * Receive command and execute.
     *
     * @param cmd
     */
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
            case 4:
                ExampleSystem3 ex3 = new ExampleSystem3();
                return;
        }
    }
}

