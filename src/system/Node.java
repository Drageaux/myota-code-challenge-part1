package system;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thong on 10/5/2018.
 */
public class Node {


    private String name;
    private int type;
    List<Node> children = new ArrayList<Node>();

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

    @Override
    public String toString() {
        return this.name;
    }
}
