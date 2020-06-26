package webb.stephen.countdown.number.Nodes;

public class IntNode extends Node{
    Integer value;

    public IntNode(Integer i){
        value = i;
    }

    public IntNode(int i){
        value = i;
    }

    public IntNode(IntNode i){
        value = i.getValue();
    }

    Integer getValue(){
        return value;
    }


}
