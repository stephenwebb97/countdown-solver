package webb.stephen.countdown.number.Nodes;

public class IntNode extends Node{
    Integer value;

    IntNode(Integer i){
        value = i;
    }

    IntNode(int i){
        value = i;
    }

    IntNode(IntNode i){
        value = i.getValue();
    }

    Integer getValue(){
        return value;
    }

}
