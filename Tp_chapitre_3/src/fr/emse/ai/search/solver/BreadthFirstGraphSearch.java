package fr.emse.ai.search.solver;

import fr.emse.ai.search.core.AbstractGraphSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;

public class BreadthFirstGraphSearch extends AbstractGraphSearch {

    public Collection<Node> initFrontier() {
        return new ArrayList<>();
    }

    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        return ((ArrayList<Node>) frontier).remove(0);
    }
}