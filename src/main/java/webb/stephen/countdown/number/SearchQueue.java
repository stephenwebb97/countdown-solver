package webb.stephen.countdown.number;

import webb.stephen.countdown.number.Nodes.IntNode;
import webb.stephen.countdown.number.Nodes.SearchNode;
import webb.stephen.countdown.number.Nodes.SearchNodeComparator;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SearchQueue extends PriorityQueue<SearchNode>  {


    public SearchQueue(Comparator<SearchNode> comparator) {
        super(comparator);
    }

    static SearchQueue createSearchQueue(Integer goal) {
        return createSearchQueue(new IntNode(goal));
    }

    static SearchQueue createSearchQueue(IntNode goal){
        Comparator<SearchNode> comparator = new SearchNodeComparator(goal);
        return new SearchQueue(comparator);
    }


}
