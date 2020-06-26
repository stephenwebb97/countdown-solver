package webb.stephen.countdown.number.Nodes;

import java.util.LinkedList;
import java.util.List;

public abstract class ArithmeticNode extends Node {
    abstract IntNode calculate(IntNode a, IntNode b) throws Exception;

    static List<ArithmeticNode> getAllArithmeticNodes(){
        List<ArithmeticNode> list = new LinkedList<>();
        list.add(new Division());
        list.add(new Multiplication());
        list.add(new Addition());
        list.add(new Subtraction());
        return list;
    }
}
