package webb.stephen.countdown.number.Nodes;

public class Subtraction extends ArithmeticNode {
    @Override
    IntNode calculate(IntNode a, IntNode b) {
        return new IntNode(a.getValue()-b.getValue());
    }

    @Override
    public String toString() {
        return "-";
    }
}
