package cn.liukai234.mydraw.shapes;
import org.eclipse.swt.graphics.GC;

public class RoundRect implements Shape{
	private int top;
	private int left;
	private int width;
	private int height;
	private int arcWidth = 50;
	private int arcHeight = 50;
	private GC gcMain;
	
	public RoundRect() {}
	public RoundRect(int top,int left,int width,int height,int arcWidth,int arcHeight,GC gc){
		this.top=top;
		this.left=left;
		this.width=width;
		this.height=height;
		this.arcWidth=arcWidth;
		this.arcHeight=arcHeight;
		this.gcMain=gc;
	}
	
	@Override
	public void draw() {
		gcMain.drawRoundRectangle(top, left, width, height, arcWidth, arcHeight);
	}
	
	public void setTop(int top) { this.top = top; }
	public void setLeft(int left) { this.left = left; }
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
	public void setGC(GC gcMain) { this.gcMain = gcMain; }
}
