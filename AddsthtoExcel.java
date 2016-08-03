import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
//向excel中追加内容
public class AddsthtoExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\wujunpeng@dangdang.com\\Desktop\\result.xls");
		
		try {
			Workbook book = Workbook.getWorkbook(file);
			Sheet sheet = book.getSheet(0);  
	        // 获取行  
	        int length = sheet.getRows();  
	        System.out.println(length);  
	        WritableWorkbook wbook = Workbook.createWorkbook(file, book); // 根据book创建一个操作对象  
	        WritableSheet sh = wbook.getSheet(0);// 得到一个工作对象  
	        // 从最后一行开始加  
	        //添加的数据是一行字符串数组，每个单元格是一个字符串，（当然，格式可以变）
	        String[] arg = {"52.3","43143"};
	        for (int i = 0; i < arg.length; i++) {  
	            Label label = new Label(i, length, arg[i]);  
	            sh.addCell(label);  
	        }  
	        wbook.write();  
	        wbook.close();  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
