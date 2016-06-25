/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphclusteringcoefficient;

/**
 *
 * @author anastasis
 */
public class Edge {
    private int nodeA;
    private int nodeB;

    public Edge(int nodeA, int nodeB) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public Edge() {
        this.nodeA=-1;
        this.nodeB=-1;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public void setNodeA(int nodeA) {
        this.nodeA = nodeA;
    }

    public void setNodeB(int nodeB) {
        this.nodeB = nodeB;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Edge)){
            return false;
        }
        return ((Edge)obj).getNodeA()==this.nodeA && ((Edge)obj).getNodeB()==this.nodeB;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.nodeA;
        hash = 47 * hash + this.nodeB;
        return hash;
    }
    
    
    
    
    
}
