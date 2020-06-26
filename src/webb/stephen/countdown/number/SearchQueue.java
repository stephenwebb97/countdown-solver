package webb.stephen.countdown.number;

import webb.stephen.countdown.number.Nodes.SearchNode;
import webb.stephen.countdown.number.Nodes.SearchNodeComparator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SearchQueue {

    private PriorityQueue<SearchNode> queue;

    SearchQueue(Integer goal){
        Comparator<SearchNode> comparator = new SearchNodeComparator(goal);
        queue = new PriorityQueue<>(comparator);
    }

    public boolean add(SearchNode in){
        return queue.add(in);
    }

    public SearchNode poll(){
        return queue.poll();
    }

    public void remove(SearchNode in){
        queue.remove(in);
    }
}
