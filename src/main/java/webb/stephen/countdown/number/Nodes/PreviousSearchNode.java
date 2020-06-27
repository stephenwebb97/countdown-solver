package webb.stephen.countdown.number.Nodes;

public class PreviousSearchNode extends SearchNode {
    private ArithmeticNode getArithmeticNode() {
        return arithmeticNode;
    }

    private void setArithmeticNode(ArithmeticNode arithmeticNode) {
        this.arithmeticNode = arithmeticNode;
    }

    private ArithmeticNode arithmeticNode;

    public PreviousSearchNode(SearchNode prev){
        super(prev);
        this.setArithmeticNode(new NullArithmeticNode());
    }

    public PreviousSearchNode(SearchNode prev,ArithmeticNode node){
        super(prev);
        this.setArithmeticNode(node);
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.getArithmeticNode().toString();
    }
}
