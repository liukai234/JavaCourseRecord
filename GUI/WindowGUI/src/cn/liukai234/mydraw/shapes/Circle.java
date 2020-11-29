package cn.liukai234.mydraw.shapes;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;

public class Circle implements Shape{
	private int top;
	private int left;
	private int width;
	private int height;
	private GC gcMain;

	public static String Type = "Circle";

	public Circle() {}
	public Circle(int top,int left,int width,int height,GC gc){
		this.top=top;
		this.left=left;
		this.width=width;
		this.height=height;
		this.gcMain=gc;
	}
	
	private Color paintColor = null;
	public void setPaintColor(Color paintColor) {
		this.paintColor = paintColor;
	}
	
	private int lineStyle = SWT.LINE_SOLID;
	public void setLineStyle(int lineStyle) {
		this.lineStyle = lineStyle;
	}

	private int lineWidth = 1;
	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}
	
	@Override
	public void draw() {
		gcMain.setLineStyle(lineStyle);
		gcMain.setLineWidth(lineWidth);
		gcMain.setForeground(paintColor);
		gcMain.drawOval(top,left,width,height);
	}

	String str = null;
	public String getString() {
		str = top + " " + left + " " + width + " " + height + " " + paintColor + " " + lineStyle + " " + lineWidth + " ";
		return str;
	}
	
	public void setTop(int top) { this.top = top; }
	public void setLeft(int left) { this.left = left; }
	public void setWidth(int width) { this.width = width; }
	public void setHeight(int height) { this.height = height; }
	public void setGC(GC gcMain) { this.gcMain = gcMain; }
}
