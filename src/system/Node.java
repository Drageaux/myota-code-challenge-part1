package system;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thong on 10/5/2018.
 */
public class Node {


    private String name;
    private Type type;
    List<Node> children = new ArrayList<Node>();

    public Node(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
