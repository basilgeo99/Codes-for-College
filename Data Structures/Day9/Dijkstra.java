/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day9;

/**
 *
 * @author tulsi
 */
import java.util.Scanner; //Scanner Function to take in the Input Values 

public class Dijkstra {

    private static void dijkstra(int[][] adjacentMatrix) {
        int v = adjacentMatrix.length;
        boolean visited[] = new boolean[v];
        int distance[] = new int[v];
        distance[0] = 0;
        for (int i = 1; i < v; i++) {
            distance[i] = Integer.MAX_VALUE;  //setting as infinity
        }

        for (int i = 0; i < v - 1; i++) {
            //find vertex with min distance

            int minVertex = findMinVertex(distance, visited);
            visited[minVertex] = true;
            //Explore neighbours
            for (int j = 0; j < v; j++) {
                if (adjacentMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE) {
                    int newDistance = distance[minVertex] + adjacentMatrix[minVertex][j];
                    if (newDistance < distance[j]) {
                        distance[j] = newDistance;
                    }
                }
            }
        }

        //Print;
        for (int i = 0; i < v; i++) {
            System.out.println(i + " " + distance[i]);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("No. of Vertices : ");
        int v = s.nextInt();
        System.out.println("No of Edges : ");
        int e = s.nextInt();
        int adjacentMatrix[][] = new int[v][v];

        for (int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int weight = s.nextInt();
            adjacentMatrix[v1][v2] = weight;
            adjacentMatrix[v2][v1] = weight;
        }

        dijkstra(adjacentMatrix);
    }

    private static int findMinVertex(int[] distance, boolean[] visited) {
        int minVertex = 1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

}
