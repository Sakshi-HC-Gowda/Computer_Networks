
package bellmandemofinal;
import java.util.*;
public class BellmanDemoFinal {
static Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
        int V,E=1,checkNegative=0;
        int w[][]=new int[20][20];
        int edge[][]=new int[50][2];
        System.out.println("Enter the no.of vertices");
        V=in.nextInt();
        System.out.println("Enter the weight matrix");
        for(int i=1;i<=V;i++)
            for(int j=1;j<=V;j++){
                w[i][j]=in.nextInt();
                if(w[i][j]!=0){
                    edge[E][0]=i;
                    edge[E++][1]=j;
                }
            }
        checkNegative=bellmanFord(w,V,E,edge);
        if(checkNegative==1)
            System.out.println("\n No negative weight cycle\n");
        else
            System.out.println("\n Negative weight cycle exist");
    }
    public static int bellmanFord(int w[][],int V,int E,int edge[][]){
        int u,v,s,flag=1;
        int distance[]=new int[20];
        int parent[]=new int[20];
        for(int i=1;i<=V;i++){
            distance[i]=999;
            parent[i]=-1;
        }
        System.out.println("Enter the source vertex");
        s=in.nextInt();
        distance[s]=0;
        for(int i=1;i<=V-1;i++){
            for(int k=1;k<=E;k++){
                u=edge[k][0];
                v=edge[k][1];
                if(distance[u]+w[u][v]<distance[v])
                {
                    distance[v]=distance[u]+w[u][v];
                    parent[v]=u;
                }}}
                for(int k=1;k<=E;k++){
                    u=edge[k][0];
                    v=edge[k][1];
                    if(distance[u]+w[u][v]<distance[v])
                        flag=0;
                }
                if(flag==1)
                    for(int i=1;i<=V;i++)
                        System.out.println("Vertex"+i+"->cost="+distance[i]+"parent="+(parent[i]));
                return flag;
            
        
    }
    
}
//Enter the no.of vertices
//4
//Enter the weight matrix
//0 5 3 6
//999 0 2 999
//3 999 0 1
//6 999 1 0
//Enter the source vertex
//1
//Vertex1->cost=0parent=-1
//Vertex2->cost=5parent=1
//Vertex3->cost=3parent=1
//Vertex4->cost=4parent=3
//
// No negative weight cycle