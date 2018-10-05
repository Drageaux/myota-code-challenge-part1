package system;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Node {
    protected List<Node> children = new ArrayList<Node>();

    public Folder(String name, Node directParent) {
        super(name, Type.TYPE_FOLDER, directParent);
    }
}
