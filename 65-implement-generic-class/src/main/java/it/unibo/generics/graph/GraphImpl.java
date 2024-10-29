package it.unibo.generics.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

@SuppressWarnings("hiding")
public class GraphImpl<Object> implements Graph<Object> {

    Map<Object, Set<Object>> mappa; // mappa con chiave e valore come set di nodi
    int n; // numero di nodi

    public GraphImpl() {
        mappa = new HashMap<>();
    }

    @Override
    public void addNode(Object node) {
        Set<Object> set = new HashSet<>();
        mappa.put(node, set);
    }

    @Override
    public void addEdge(Object source, Object target) {
        if (source != null && target != null) {
            for (Map.Entry<Object, Set<Object>> entry : mappa.entrySet()) {
                if (entry.getKey().equals(source)) {
                    entry.getValue().add(target);
                }
            }
        }
    }

    @Override
    public Set<Object> nodeSet() {
        Set<Object> set = new HashSet<>();
        for (Object string : mappa.keySet()) {
            set.add(string);
        }
        return set;
    }

    @Override
    public Set<Object> linkedNodes(Object node) {
        Set<Object> set = new HashSet<>();
        for (Map.Entry<Object, Set<Object>> entry : mappa.entrySet()) {
            if (node.equals(entry.getKey())) {
                for (Object string : entry.getValue()) {
                    set.add(string);
                }
            }
        }
        return set;
    }

    @Override
    public List<Object> getPath(Object source, Object target) {
        // TODO Auto-generated method stub
        List<Object> path = new LinkedList<>();
        return path;
    }

}
