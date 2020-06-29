package webb.stephen.countdown.number.Nodes;

import com.google.gson.Gson;
import webb.stephen.countdown.number.SearchQueue;

import java.util.LinkedList;
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

    private void setPrev(SearchNode prev) {
        this.prev = prev;
    }

    private IntNode value;
    private SearchNode prev;

    private IntNode consumedNumber;

    private ArithmeticNode usedArithmetic;

    public SearchNode(IntNode currValue,
                      SearchNode previous ,
                      List<IntNode> remainderIn,
                      IntNode consumedNumber,
                      ArithmeticNode usedArithmeticNode
    ){
        this.setPrev(previous);
        this.setRemainder(remainderIn);
        this.setValue(currValue);
        this.setConsumedNumber(consumedNumber);
        this.setUsedArithmetic(usedArithmeticNode);
    }



    public SearchNode(SearchNode searchNode){
        this(searchNode.getValue(),searchNode.getPrev(),searchNode.getRemainder(),searchNode.getConsumedNumber(),searchNode.getUsedArithmetic());
    }

    public void search(SearchQueue queue){
        List<ArithmeticNode> arithmeticNodesList = ArithmeticNode.getAllArithmeticNodes();

        if (!remainder.isEmpty()){
            List<IntNode> currNumber = new LinkedList<IntNode>(remainder);
            IntNode next = currNumber.get(0);
            currNumber.remove(0);
            for (ArithmeticNode node:arithmeticNodesList){

                try{
                    queue.add(new SearchNode(node.calculate(value,next),this,currNumber,next,node));
                }catch (Exception e){

                }

            }
        }


    }



    public IntNode getValue(){
        return value;
    }

    public SearchNode getPrev() {
        return prev;
    }

    @Override
    public String toString() {
        if (this.getPrev() == null)
            return this.getValue().toString();
        else
            return "("+
                    this.getValue().toString() + " = " +
                    this.getPrev().getValue().toString() + " " +
                    this.getUsedArithmetic().toString()+ " " +
                    this.getConsumedNumber().toString()+ ")";
    }

    public IntNode getConsumedNumber() {
        return consumedNumber;
    }

    private void setConsumedNumber(IntNode consumedNumber) {
        this.consumedNumber = consumedNumber;
    }

    public ArithmeticNode getUsedArithmetic() {
        return usedArithmetic;
    }

    private void setUsedArithmetic(ArithmeticNode usedArithmetic) {
        this.usedArithmetic = usedArithmetic;
    }
}
