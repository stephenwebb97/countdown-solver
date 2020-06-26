package webb.stephen.countdown.number;

import webb.stephen.countdown.number.Nodes.IntNode;
import webb.stephen.countdown.number.Nodes.SearchNode;
import webb.stephen.countdown.number.Nodes.SearchNodeComparator;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SearchQueue extends PriorityQueue<SearchNode> implements Queue<SearchNode> {

    SearchQueue(Integer goal){
        new SearchQueue(new IntNode(goal));
    }

    SearchQueue(IntNode goal){
        Comparator<SearchNode> comparator = new SearchNodeComparator(goal);
        new PriorityQueue<>(comparator);
    }
}
