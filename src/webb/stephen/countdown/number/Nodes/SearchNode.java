package webb.stephen.countdown.number.Nodes;

import java.util.List;

public class SearchNode extends Node{
    private List<IntNode>remainder;

    SearchNode(IntNode currValIn, List<IntNode> remainderIn){
        remainder = remainderIn;
    }
}
