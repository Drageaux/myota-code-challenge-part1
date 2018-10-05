package system;

public class File extends Node {
    public File(String name, Node directParent) {
        super(name, Type.TYPE_FILE, directParent);
    }
}
