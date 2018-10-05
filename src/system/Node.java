package system;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thong on 10/5/2018.
 */
public class Node {

    private String name;
    private int type;
    private List<Node> directParents = new ArrayList<Node>();

    public Node(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public List<Node> getDirectParents() {
        return this.directParents;
    }

    public void addDirectParent(Node parent) {
        // model level checks

        // if name is "/" a.k.a is root, do not add parent
        if (parent.getName() == "/") System.out.println("ERROR: Trying to set parents to root directory");

        // if no parents yet, feel free to add
        return;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
