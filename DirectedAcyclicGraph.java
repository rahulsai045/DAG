package com.test7;

import java.util.ArrayList;
import java.util.List;

public class DirectedAcyclicGraph {
	public static void main(String[] args) {
		List<Vertex> vertices = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            vertices.add(new Vertex(i));
        }

        // Create edges
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(vertices.get(0), vertices.get(1)));
        edges.add(new Edge(vertices.get(0), vertices.get(2)));
        edges.add(new Edge(vertices.get(1), vertices.get(3)));
        edges.add(new Edge(vertices.get(2), vertices.get(3)));
        edges.add(new Edge(vertices.get(3), vertices.get(4)));

        // Create graph and add edges
        Graph graph = new Graph(vertices.size());
        for (Edge edge : edges) {
            graph.addEdge(edge.from, edge.to);
        }

        // Find the longest path starting from vertex 0
        Vertex startVertex = vertices.get(0);
        int longestPathLength = graph.findLongestPath(startVertex);

        // Print the result
        System.out.println("Longest path length from vertex 0: " + longestPathLength); // Expected output: 4
    }
    
}
