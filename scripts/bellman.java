import java.util.Scanner;

public class BellmanFord {
	private int num_ver;
	private int d[];
	public static final int max_val=999;
public BellmanFord(int num_ver)
{
	this.num_ver=num_ver;
	d=new int[num_ver];
}
public void BellmanFordEvaluation(int source,int a[][]) {
	for(int node=1; node<=num_ver; node++) {
		d[node]=0;
	}
	d[source]=0;
	
	for (int node=1; node<=num_ver; node++)
	{
		for(int sn=1; sn<=num_ver; sn++) {
			for(int dn=1; dn<=num_ver; dn++) {
				if(a[sn][dn]!=max_val) {
				if(d[dn]>d[sn]+a[sn][dn]) 
					d[dn]=d[sn]+a[sn][dn];
				}
			}
		}
	}
	for(int sn=1; sn<=num_ver; sn++) {
		for(int dn=1; dn<=num_ver; dn++) {
			if(a[sn][dn]!=max_val) {
			if(d[dn]>d[sn]+a[sn][dn]) 
			System.out.println("the graph contains negative edge");
			}
		}
	}
		for(int vertex=1; vertex<=num_ver; vertex++) {
			System.out.println("graph contains edge from"+source+ "to "+vertex+"is "+d[vertex]);
		}
}

	public static void main(String[] args) {
	int num_ver=0;int source;
	Scanner sc =new Scanner(System.in);
	System.out.println("enter no of vertices");
     num_ver=sc.nextInt();
     int a[][]=new  int[num_ver+1][num_ver+1];
     System.out.println("enter adjacency matrix");
     for(int sn=1; sn<=num_ver; sn++) {
 		for(int dn=1; dn<=num_ver; dn++) {
 			a[sn][dn]=sc.nextInt();
 			if(sn==dn)
 			{
 				a[sn][dn]=0; continue;
 			}
 			if(a[sn][dn]==0)
 			{
 				a[sn][dn]=max_val;
 			}
 		}
     
     }
     System.out.println("enter source vertex");
     source=sc.nextInt();
     BellmanFord b=new BellmanFord(num_ver);
     b.BellmanFordEvaluation(source, a);
     sc.close();

	}

}
