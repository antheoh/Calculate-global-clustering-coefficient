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
        Graph g=Graph.loadFile();
        HashSet<Integer> nodes=g.getNodes();
        System.out.println("Number of nodes:"+nodes.size());
        for ( Integer targetNode:nodes){
            HashSet<Integer> friends=g.getFriends(targetNode);
            System.out.println("\n\nNode: "+targetNode+" has "+friends.size()+" friends");
            ArrayList <Edge> possibleConnections= g.getPossibleConnections(friends);
            int maxConnections=possibleConnections.size();
            System.out.println("Ta possible connections tou komvou "+targetNode+" einai: "+maxConnections);
            int numTriangles=g.getNumTriangles(possibleConnections);
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
    }
    
}
