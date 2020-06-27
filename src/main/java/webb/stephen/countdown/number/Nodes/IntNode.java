package webb.stephen.countdown.number.Nodes;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class IntNode extends Node{
    Integer value;

    private void setValue(Integer value) {
        this.value = value;
    }

    public IntNode(Integer i){
        this.setValue(i);
    }

    public IntNode(int i){
        value = i;
    }

    public IntNode(IntNode i){
        value = i.getValue();
    }

    public Integer getValue(){
        return value;
    }

    static List<IntNode> integerListToIntNodeList(List<Integer> integers){
        List<IntNode> retList = new LinkedList<IntNode>();
        for (Integer integer:integers) {
            retList.add(new IntNode(integer));
        }
        return retList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntNode)) return false;
        IntNode intNode = (IntNode) o;
        return Objects.equals(getValue(), intNode.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public String toString() {
        return getValue().toString();
    }
}
