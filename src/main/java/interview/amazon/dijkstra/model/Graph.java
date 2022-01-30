package interview.amazon.dijkstra.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Graph{

    private Set<Node> nodes = new HashSet<>();

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Graph graph = (Graph) o;
        return Objects.equals(nodes, graph.nodes);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nodes);
    }

    @Override
    public String toString(){
        return "Graph{" + "nodes=" + nodes + '}';
    }

}
