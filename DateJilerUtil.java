
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wujunpeng on 2017/5/12.
 * getStringFromDate : Date转String(一个参数和两个参数两种情况)
 * getDateFromString : String转Date
 * getOffsetDate : 得到一个偏移日期(几天前，几个小时前)
 *
 * Date类自带函数
 * 比较两个函数可以用compareTo: 转成long型，前面时间大则返回1，相等返回0，后面时间大返回-1
 * before: 前面时间大返回false,后面时间大返回true
 * after: 则是与before相反的。
 */
public class DateJilerUtil {

    /**
     * Date转String
     * @param date 日期
     * @param formateString 格式，eg:"yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public String getStringFromDate(Date date, String formateString){
        if(date == null){
            return "";
        }
        if(formateString == null || "".equals(formateString.trim())){
            formateString = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formateString);
        String dateString = sdf.format(date);
        return dateString;
    }

    /**
     * Date转String
     * @param date 日期 转换成"yyyy-MM-dd HH:mm:ss"格式
     * @return
     */
    public String getStringFromDate(Date date){
        if(date == null){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = sdf.format(date);
        return dateString;
    }

    /**
     * String转Date
     * @param dateString 字符串
     * @param formateString 格式，eg:"yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public Date getDateFromString(String dateString, String formateString){
        if(dateString == null || "".equals(dateString.trim())){
            return null;
        }
        if(formateString == null || "".equals(formateString.trim())){
            formateString = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(formateString);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 得到一个偏移日期：几天前，几个小时前，
     * @param date
     * @param unit 偏移单位
     * @param offset 偏移量，如果为负值，则表示几天后，几个小时后
     * @return
     */
    public Date getOffsetDate(Date date, String unit, Integer offset){
        if(date == null ){
            return null;
        }
        if(offset == null){
            return date;
        }
        if(unit == null || "".equals(unit.trim())){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        Date todayOffset = new Date();
        calendar.setTime(todayOffset);
        if(unit.equals("second")){
            calendar.add(Calendar.SECOND, offset);//几个小时之后
        }
        if(unit.equals("minute")){
            calendar.add(Calendar.MINUTE, offset);//几个小时之后
        }
        if(unit.equals("hour")){
            calendar.add(Calendar.HOUR_OF_DAY, offset);//几个小时之后
        }
        if(unit.equals("day")){
            calendar.add(Calendar.DAY_OF_MONTH, offset);//几天后
        }
        if(unit.equals("week")){
            calendar.add(Calendar.WEEK_OF_YEAR, offset);//几个小时之后
        }
        if(unit.equals("month")){
            calendar.add(Calendar.MONTH, offset);//几天后
        }
        if(unit.equals("year")){
            calendar.add(Calendar.YEAR, offset);//几天后
        }
        return calendar.getTime();
    }
    /**
     * 使用方法
     DateJilerUtil dateObj = new DateJilerUtil();
     String formate = "yyyy-MM-dd HH:mm:ss";
     Date today = new Date();
     String dateString = dateObj.getStringFromDate(today, formate);
     System.out.println("Date转String: " + dateString);
     String dateStringDefault = dateObj.getStringFromDate(today);
     System.out.println("Date转String: " + dateStringDefault);
     Date transferFromString = dateObj.getDateFromString(dateString, formate);
     System.out.println("String转Date: " + transferFromString);
     Date d0 = dateObj.getOffsetDate(today,"second",1);
     Date d1 = dateObj.getOffsetDate(today,"minute",30);
     Date d2 = dateObj.getOffsetDate(today,"hour",2);
     Date d3 = dateObj.getOffsetDate(today,"day",30);
     Date d4 = dateObj.getOffsetDate(today,"month",1);
     Date d5 = dateObj.getOffsetDate(today,"year",2);
     Date d6 = dateObj.getOffsetDate(today,"week",1);
     System.out.println(dateObj.getStringFromDate(today));
     System.out.println(dateObj.getStringFromDate(d0));
     System.out.println(dateObj.getStringFromDate(d1));
     System.out.println(dateObj.getStringFromDate(d2));
     System.out.println(dateObj.getStringFromDate(d3));
     System.out.println(dateObj.getStringFromDate(d4));
     System.out.println(dateObj.getStringFromDate(d5));
     System.out.println(dateObj.getStringFromDate(d6));
     */
}