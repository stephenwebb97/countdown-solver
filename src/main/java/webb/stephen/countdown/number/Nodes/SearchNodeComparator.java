package webb.stephen.countdown.number.Nodes;

import java.util.Comparator;

public class SearchNodeComparator implements Comparator<SearchNode> {

    private Integer inGoal;

    public SearchNodeComparator(IntNode goal){
        inGoal = goal.getValue();
    }

    public SearchNodeComparator(Integer goal){
        inGoal = goal;
    }

    public static Integer howClose(SearchNode currentValue,IntNode goal){
        return Math.abs(goal.getValue() - currentValue.getValue().getValue());
    }

    private Integer findValue(SearchNode searchNode){
        return howClose(searchNode,new IntNode(inGoal));
    }

    @Override
    public int compare(SearchNode o1, SearchNode o2) {

        Integer o1Value = findValue(o1);
        Integer o2Value = findValue(o2);

        if (o1Value > o2Value)
            return 1;
        else if (o1Value < o2Value)
            return -1;
        return 0;
    }
}
