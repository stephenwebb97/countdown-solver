package webb.stephen.countdown.number.Nodes;

public abstract class ArithmeticNode extends Node {
    abstract IntNode calculate(IntNode a, IntNode b) throws Exception;
}
