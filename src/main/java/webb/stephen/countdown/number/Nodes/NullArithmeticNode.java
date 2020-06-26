package webb.stephen.countdown.number.Nodes;

public class NullArithmeticNode extends ArithmeticNode {
    @Override
    IntNode calculate(IntNode a, IntNode b) throws Exception {
        throw new Exception("Tried to calculate on null node");
    }

    @Override
    public String toString() {
        return " ";
    }
}
