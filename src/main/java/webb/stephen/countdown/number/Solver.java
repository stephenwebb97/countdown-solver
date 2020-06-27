package webb.stephen.countdown.number;

import webb.stephen.countdown.number.Nodes.IntNode;
import webb.stephen.countdown.number.Nodes.NullArithmeticNode;
import webb.stephen.countdown.number.Nodes.PreviousSearchNode;
import webb.stephen.countdown.number.Nodes.SearchNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solver {

    private IntNode goal;


    public Integer getGoal() {
        return goal.getValue();
    }

    private IntNode getGoalIntNode(){
        return goal;
    }

    public void setGoal(Integer goal) {
        this.goal = new IntNode(goal);
    }

    private void setGoal(IntNode goal) {
        this.goal = goal;
    }


    public Solver(Integer goal){
        this.setGoal(goal);
        this.setNumbers(new LinkedList<IntNode>());
    }



    private List<IntNode> numbers;


    public void addNumber(Integer num){
        this.getNumbers().add(new IntNode(num));
    }


    public void solve(){
        SearchQueue queue = SearchQueue.createSearchQueue(goal);
        for (int i = 0; i < numbers.size(); i++) {
            List<IntNode> currNumber = new LinkedList<IntNode>(numbers);
            currNumber.remove(i);
            queue.add(new SearchNode(numbers.get(i),null,currNumber));
        }
        this.solve(queue);

    }

    private String solutionToString(SearchNode current){
        if (current != null)
            return current.toString() +" " + this.solutionToString(current.getPrev());
        return "";
    }

    private void solve(SearchQueue queue){
        while (!queue.isEmpty()){
            SearchNode currNode = queue.poll();
            System.out.println(this.solutionToString(currNode));
            if (currNode.getValue() == goal){
                System.out.println(this.solutionToString(currNode));
                System.exit(0);
            }
            currNode.search(queue);
        }
    }

    public List<IntNode> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<IntNode> numbers) {
        this.numbers = numbers;
    }
}
