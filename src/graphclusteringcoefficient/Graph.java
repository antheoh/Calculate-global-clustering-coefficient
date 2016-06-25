/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphclusteringcoefficient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anastasis
 */
public class Graph extends ArrayList<Edge> {
    public static Graph loadFile() throws FileNotFoundException, IOException{
        Graph g=new Graph();
        BufferedReader br=new BufferedReader(new FileReader(new File("roadNet-CA.txt")));
        String line;
        try {            
            while (( line = br.readLine()) !=null ) {
                line=line.trim();
                String[] elements=line.split("\t");
                
                int nodeA=Integer.parseUnsignedInt(elements[0].trim());                
                int nodeB=Integer.parseUnsignedInt(elements[1].trim());
                Edge e=new Edge(nodeA,nodeB);        
                g.add(e);
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;        
    }
    
    
    
    //hashset gia na einai unique
    public HashSet<Integer> getNodes() {
        HashSet<Integer> nodes=new HashSet<>();
        for ( Edge e:this){
            nodes.add(e.getNodeA());
            nodes.add(e.getNodeB());
        }
        return nodes;
    }
    
    public HashSet <Integer> getFriends(int targetNode){
        HashSet<Integer> friends=new HashSet<>();
        for ( Edge e:this){
            if ( e.getNodeA()==targetNode ){
                friends.add(e.getNodeB());
            }
            else if ( e.getNodeB()==targetNode){
                friends.add(e.getNodeA());
            }
        }
        return friends;
    }
    
    public ArrayList<Edge> getPossibleConnections(HashSet <Integer> friends){
        ArrayList <Edge> possibleConnections=new ArrayList<>();
        Object[] friendNodes=friends.toArray();
        for ( int i=0;i<friends.size();i++){
            for ( int j=i+1;j<friends.size();j++){
                Edge e=new Edge((Integer)friendNodes[i],(Integer)friendNodes[j]);
                possibleConnections.add(e); //olous tous pithanous filous gia to komvo pou me endiaferei
            }
        }
        return possibleConnections;
    }
    
    
    
    
    public int getNumTriangles(ArrayList<Edge> possibleConnections){
        int count=0;
        //mou dineis oles tis pithanes akmes twn filw
        
        for(Edge s:possibleConnections){
            for(Edge t:this){
                if ( s.equals(t)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    
    
    
    
    
    
}
