import java.util.ArrayList;
import java.util.List;
import cn.liukai234.mydraw.shapes.*;

public class Board {
	private List<Shape>shapes;
	
	public Board() {
		shapes=new ArrayList<Shape>();
	}
	
	public void insertShape(Shape shape) {
		shapes.add(shape);
	}
	
	public void refresh() {
		for(Shape shape:shapes) {
			shape.draw();
		}
	}
	
	public String getSaveStream() {
		String string = "";
		for(Shape shape:shapes) {
			string += shape.getString();
		}
		return string;
	}
}
