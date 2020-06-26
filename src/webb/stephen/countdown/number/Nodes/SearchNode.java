package webb.stephen.countdown.number.Nodes;

import webb.stephen.countdown.number.SearchQueue;

import java.util.List;

public class SearchNode extends Node{
    private List<IntNode> remainder;

    private List<IntNode> getRemainder() {
        return remainder;
    }

    private void setRemainder(List<IntNode> remainder) {
        this.remainder = remainder;
    }

    private void setValue(IntNode value) {
        this.value = value;
    }

    private void setPrev(PreviousSearchNode prev) {
        this.prev = prev;
    }

    private IntNode value;
    private PreviousSearchNode prev;

    public SearchNode(IntNode currValue, PreviousSearchNode previous, List<IntNode> remainderIn){
        this.setPrev(previous);
        this.setRemainder(remainderIn);
        this.setValue(currValue);
    }


    public SearchNode(SearchNode searchNode){
        new SearchNode(searchNode.getValue(),searchNode.getPrev(),searchNode.getRemainder());
    }

    public void search(SearchQueue queue){
        List<ArithmeticNode> arithmeticNodesList = ArithmeticNode.getAllArithmeticNodes();
        if (!remainder.isEmpty()){
            IntNode next = remainder.get(0);
            remainder.remove(0);
            for (ArithmeticNode node:arithmeticNodesList){
                try{
                    queue.add(new SearchNode(node.calculate(value,next),new PreviousSearchNode(this,node),remainder));
                }catch (Exception e){

                }

            }
        }


    }



    public IntNode getValue(){
        return value;
    }

    public PreviousSearchNode getPrev() {
        return prev;
    }
}
