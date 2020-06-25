package webb.stephen.countdown.number.Nodes;

public class Division extends ArithmeticNode {
    @Override
    IntNode calculate(IntNode a, IntNode b) throws Exception {
        if (a.getValue() % b.getValue() != 0){
            throw new Exception("IntA:"+a.toString()+" does not divided evenly in IntB:"+b.toString());
        }
        return new IntNode(a.getValue()/b.getValue());
    }

    @Override
    public String toString() {
        return "/";
    }
}
