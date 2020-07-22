//package graph;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
 
public class DijkstraGTest {
	
	public static void main(String[] args) {
		MyDijkstraG g = new MyDijkstraG(40);
		//增加顶点
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		//增加边和边的权重
		g.addEdge(0, 1, 3);
		g.addEdge(0, 3, 7);
		g.addEdge(1, 2, 4);
		g.addEdge(1, 3, 2);
		g.addEdge(2, 4, 6);
		g.addEdge(3, 2, 5);
		g.addEdge(3, 4, 4);
		//执行dijkstra算法
		g.doDijkstra();
	}
}
 
class MyDijkstraG{
	int AddDistance = 0;
	//最大的权值
	private static final int INFINITE = 10000;
	//二维数组，连接矩阵
	List<LinkedList<VertexWeigth>> matrix = null;
	//顶点队列
	private Vertex[] vertexList;
	//顶点的个数
	private int size;
	//辅助数组，记录某点的父顶点以及这个点到源点的距离
	private DistanceParent[] distanceParents;
	
	public MyDijkstraG(int maxSize){
		this.vertexList = new Vertex[maxSize];
		this.matrix = new ArrayList<LinkedList<VertexWeigth>>();
		this.size = 0;
		this.distanceParents = new DistanceParent[maxSize];
		
		for(int i = 0; i < maxSize; i++){
			LinkedList<VertexWeigth> list = new LinkedList<>();
			matrix.add(list);
		}
	}
 
	//增加顶点
	public void addVertex(String label){
		vertexList[size++] = new Vertex(label);
	}
	
	//增加边和权重
	public void addEdge(int start, int end, int weigth){
		VertexWeigth vw = new VertexWeigth(end, weigth);
		matrix.get(start).add(vw);
	}
	
	//执行算法
	public void doDijkstra(){
		//当前顶点
		int currentVertex = 0;
		//加入树中的顶点数
		int treeNum = 1;
		
		//初始化：第一个顶点到其余顶点的权重，父顶点下标都为0
		Iterator<VertexWeigth> iter = matrix.get(0).iterator();
		while(iter.hasNext()){
			VertexWeigth vw = iter.next();
			distanceParents[vw.vertexIndex] = new DistanceParent(vw.weigth, 0);
		}
		//初始化：把源点不可达的边的权重都为最大,同时防止空异常
		for(int i = 0; i < size; i++){
			if(distanceParents[i] == null){
				distanceParents[i] = new DistanceParent(INFINITE, 0);
			}
		}
		
		//每一次循环，都可以确认某一个顶点到源点的最小距离
		while(treeNum < size){
			currentVertex = getMin();
			
			//如果成立，说明剩余的顶点没有和当前顶点相连，可以退出了
			if(distanceParents[currentVertex].distance == INFINITE){
				System.err.println("full ......");
				break;
			}
			
			vertexList[currentVertex].setInTree(true);
			
			treeNum++;
			
			//打印
			print(currentVertex);
			//调整辅助数组
			adjust(currentVertex);
			
		}
		
	}
	
	/**
	 * 获取距离最小的非父顶点的下标
	 * @return
	 */
	public int getMin(){
		
		int temp = INFINITE;
		int tempIndex = -1;
		for(int i = 0; i < size; i++){
			int temp2 = distanceParents[i].distance;
			if(temp2 < temp && !vertexList[i].isInTree){
				temp = temp2;
				tempIndex = i;
			}
		}
		return tempIndex;
	}
	
	//调整辅助数组
	public void adjust(int currentVertex){
		
		Iterator<VertexWeigth> iter = matrix.get(currentVertex).iterator();
		while(iter.hasNext()){
			VertexWeigth vw = iter.next();
			int currentToFringe = vw.weigth;
			int startToFringe = distanceParents[currentVertex].distance+currentToFringe;
			
			if(vertexList[vw.vertexIndex].isInTree == false && distanceParents[vw.vertexIndex].distance > startToFringe){
				distanceParents[vw.vertexIndex].distance = startToFringe;
				distanceParents[vw.vertexIndex].parentVertex = currentVertex;
			}
		}
	}
	
	public void print(int currentVertex){
		
		// Vertex parentVertex = vertexList[distanceParents[currentVertex].parentVertex];
		// 记录父结点
		// 距离矢量累加
		// int AddDistance = 0;
		AddDistance += distanceParents[currentVertex].distance;
		System.out.println(vertexList[distanceParents[0].parentVertex].label+" --> "+vertexList[currentVertex].label+
							": "+distanceParents[currentVertex].distance+"; ");
	}
	
	/**
	 * 用于保存尾顶点的下标以及边的权重
	 * @author LiangYH
	 *
	 */
	class VertexWeigth{
		int vertexIndex;
		int weigth;
		
		public VertexWeigth(){
			
		}
		
		public VertexWeigth(int vertexIndex, int weigth){
			this.vertexIndex = vertexIndex;
			this.weigth = weigth;
		}
	}
	
	/**
	 *  顶点类
	 * @author admin
	 *
	 */
	class Vertex{
		//标签
		String label;
		//是否已经加入树中（即是否已经确认这个顶点到源点的最短路径）
		boolean isInTree;
		
		public Vertex(String label){
			this.label = label;
			this.isInTree = false;
		}
 
		public void setInTree(boolean isInTree) {
			this.isInTree = isInTree;
		}
		
		
	}
	
	/**
	 * 记录某点的父顶点以及这个点到源点的距离
	 * @author LiangYH
	 *
	 */
	class DistanceParent{
		//从源点到现在所在点的距离
		int distance;
		//现在所在点的父顶点
		int parentVertex;
		
		public DistanceParent(){
			
		}
		
		public DistanceParent(int distance, int parentVertex){
			this.distance = distance;
			this.parentVertex = parentVertex;
		}
	}
}