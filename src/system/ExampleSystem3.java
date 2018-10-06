package system;

import static system.Type.TYPE_DIR;

/**
 * Created by Thong on 10/5/2018.
 */
public class ExampleSystem3 extends DirectorySystem {

    public ExampleSystem3() {
        System.out.println("\nInitializing Example 3 system...\n");

        Folder v1 = new Folder("v1");
        Folder v2 = new Folder("v2");
        Folder v3 = new Folder("v3");
        Folder v4 = new Folder("v4");

        Folder root = this.root();

        // basic
        this.addChild(root, v1);

        this.addChild(root, root);
        this.addChild(v1, v2);
        this.addChild(v1, v4);
        this.addChild(v2, v4);
        this.addChild(v4, v3);

        // add illegal arrows
        this.addChild(v2, v1);
        this.addChild(v4, v1);
        this.addChild(v3, v1);

        System.out.println("\nDoes node " + v1 + " creates a cycle?");
        this.detectCycle(v2);
    }

    @Override
    /**
     * Adds a child node to the parent node, but allows illegal arrows.
     *
     * @param parent
     * @param child
     * @return true if successfully created; false otherwise
     */
    protected boolean addChild(Folder parent, Node child) {
        // parent must be a folder
        // parent and child instances are not the same
        if (parent.getType() == TYPE_DIR && parent != child) {
            parent.children.add(child);
            System.out.println("parent " + parent + " added child " + child);
        } else {
            System.out.println("parent " + parent + " is not a folder or is the same as child " + child);
        }
        return false;
    }
}
