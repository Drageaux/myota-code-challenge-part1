package system;

/**
 * Created by Thong on 10/5/2018.
 */
public class ExampleSystem2 extends DirectorySystem {

    public ExampleSystem2() {
        System.out.println("\nInitializing Example 1 system...\n");

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
    }
}
