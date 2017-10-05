package fr.emse.ai.search.solver;

import fr.emse.ai.search.core.AbstractTreeSearch;
import fr.emse.ai.search.core.Node;
import fr.emse.ai.search.core.Problem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public class BreadthFirstTreeSearch extends AbstractTreeSearch {

    public Collection<Node> initFrontier() {
        return new ArrayList<Node>();
    }

    public Node chooseLeafNode(Collection<Node> frontier, Problem problem) {
        return ((ArrayList<Node>) frontier).remove(0);
    }
}