package com.test7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	private Map<Vertex, List<Vertex>> adjList = new HashMap<>();
    private Map<Vertex, Integer> longestPathCache = new HashMap<>();
	public Graph(int size) {
		adjList = new HashMap<>(size);
    }

    public void addEdge(Vertex from, Vertex to) {
        adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
    }

    public int findLongestPath(Vertex start) {
        if (longestPathCache.containsKey(start)) {
            return longestPathCache.get(start);
        }

        int maxLength = 0;
        if (adjList.containsKey(start)) {
            for (Vertex neighbor : adjList.get(start)) {
                int pathLength = findLongestPath(neighbor);
                if (pathLength > maxLength) {
                    maxLength = pathLength;
                }
            }
        }
        
        longestPathCache.put(start, maxLength + 1);
        return maxLength + 1;
    }
}
