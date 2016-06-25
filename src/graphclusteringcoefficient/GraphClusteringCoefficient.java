/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphclusteringcoefficient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author anastasis
 */
public class GraphClusteringCoefficient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int max_degree_node=0,vertex=0,max_connections_for_all_the_graph=0,max_triangles_for_all_the_graph=0;
        float globalClusteringCoefficient;
        Graph g=Graph.loadFile();
        HashSet<Integer> nodes=g.getNodes();
        System.out.println("Number of nodes:"+nodes.size());
        //gia kathe komvo ksehorista twra
        for ( Integer targetNode:nodes){
            HashSet<Integer> friends=g.getFriends(targetNode);
            if ( friends.size()>max_degree_node){
                max_degree_node=friends.size();
                vertex=targetNode;
            }
            System.out.println("\n\nNode: "+targetNode+" has "+friends.size()+" friends");
            ArrayList <Edge> possibleConnections= g.getPossibleConnections(friends);
            int maxConnections=possibleConnections.size();
            System.out.println("Ta possible connections tou komvou "+targetNode+" einai: "+maxConnections);
            int numTriangles=g.getNumTriangles(possibleConnections);
            max_connections_for_all_the_graph=max_connections_for_all_the_graph+maxConnections;
            max_triangles_for_all_the_graph=max_triangles_for_all_the_graph+numTriangles;
            System.out.println("O arithmos twn pragmatikwn trigwnwn tou komvou "+targetNode+" einai: "+numTriangles);
            double cf=0;
            if ( maxConnections !=0){
                cf= ( double)numTriangles/maxConnections;
            }
            else {
                cf=0;
            }
            System.out.println("Local clustering coefficient tou komvou "+targetNode+":"+cf);
        }
        System.out.println("\n\n\nMax degree node:"+vertex+" equals with:"+max_degree_node);
        globalClusteringCoefficient=((float)(max_triangles_for_all_the_graph*3)/((float)max_connections_for_all_the_graph));
        System.out.println("The number of triangles in the whole graph is equal with:"+max_triangles_for_all_the_graph);
        System.out.println("The total number of triplets both open and closed is equal with:"+max_connections_for_all_the_graph);
        System.out.println("\n\nGlobal clustering coefficient equals with:"+globalClusteringCoefficient);
    }
    
}
