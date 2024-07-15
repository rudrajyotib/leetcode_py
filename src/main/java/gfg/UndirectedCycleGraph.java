/*
https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph
 */

package gfg;

import java.util.ArrayList;

public class UndirectedCycleGraph {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        Graph graph = new Graph(V);
        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> neighbors = adj.get(i);
            for (Integer neighbor : neighbors) {
                if (!graph.addEdge(i, neighbor)) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Graph {
        final int vertices;
        final int[] parent;

        Graph(int vertices) {
            this.vertices = vertices;
            this.parent = new int[vertices];
            for (int i = 0; i < vertices; i++) {
                this.parent[i] = i;
            }
        }

        public int find(int vertex) {
            if (this.parent[vertex] == vertex) {
                return vertex;
            }
            this.parent[vertex] = find(this.parent[vertex]);
            return this.parent[vertex];
        }

        public boolean addEdge(int source, int destination) {
            if (this.find(source) == this.find(destination)) {
                return false;
            }
            union(source, destination);
            return true;
        }

        public void union(int source, int destination) {
            this.parent[destination] = this.parent[source];
        }

    }
}
