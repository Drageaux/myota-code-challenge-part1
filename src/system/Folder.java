package system;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Node {
    // only folders have children
    protected List<Node> children = new ArrayList<Node>();

    public Folder(String name) {
        super(name, Type.TYPE_FOLDER);
    }

    public List<Node> getChildren() {
        return this.children;
    }
}
