package system;

import system.DirectorySystem;
import system.File;
import system.Folder;
import system.Node;

/**
 * Created by Thong on 10/5/2018.
 */
public class ExampleSystem1 extends DirectorySystem {

    public ExampleSystem1() {
        Folder v1 = new Folder("v1");
        Folder v2 = new Folder("v2");
        File v3 = new File("v3");
        Folder v4 = new Folder("v4");

        Folder root = this.root();

        // basic
        this.addChild(root, v1);
        this.addChild(root, v2);
        this.addChild(root, v3);
        this.addChild(root, v4);

        this.addChild(v1, v2);
    }
}
