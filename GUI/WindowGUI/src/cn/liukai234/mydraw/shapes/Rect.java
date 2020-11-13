package cn.liukai234.mydraw.shapes;
import org.eclipse.swt.graphics.GC;

public class Rect implements Shape {
	private int top;
	private int left;
	private int width;
	private int height;
	private GC gcMain;

	public static String Type = "Rect";

	public Rect() {}
	public Rect(int top,int left,int width,int height,GC gc){
		this.top=top;
		this.left=left;
		this.width=width;
		this.height=height;
		this.gcMain=gc;
	}
	
	@Override
	public void draw() {
		gcMain.drawRectangle(top,left,width,height);
	}
	
	public void setTop(int top) { this.top = top; }
	public void setLeft(int left) { this.left = left; }
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
	public void setGC(GC gcMain) { this.gcMain = gcMain; }
}
