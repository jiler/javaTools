
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wujunpeng on 2017/5/12.
 * getStringFromDate : DateתString(һ�����������������������)
 * getDateFromString : StringתDate
 * getOffsetDate : �õ�һ��ƫ������(����ǰ������Сʱǰ)
 *
 * Date���Դ�����
 * �Ƚ���������������compareTo: ת��long�ͣ�ǰ��ʱ����򷵻�1����ȷ���0������ʱ��󷵻�-1
 * before: ǰ��ʱ��󷵻�false,����ʱ��󷵻�true
 * after: ������before�෴�ġ�
 */
public class DateJilerUtil {

    /**
     * DateתString
     * @param date ����
     * @param formateString ��ʽ��eg:"yyyy-MM-dd HH:mm:ss"
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
     * DateתString
     * @param date ���� ת����"yyyy-MM-dd HH:mm:ss"��ʽ
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
     * StringתDate
     * @param dateString �ַ���
     * @param formateString ��ʽ��eg:"yyyy-MM-dd HH:mm:ss"
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
     * �õ�һ��ƫ�����ڣ�����ǰ������Сʱǰ��
     * @param date
     * @param unit ƫ�Ƶ�λ
     * @param offset ƫ���������Ϊ��ֵ�����ʾ����󣬼���Сʱ��
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
            calendar.add(Calendar.SECOND, offset);//����Сʱ֮��
        }
        if(unit.equals("minute")){
            calendar.add(Calendar.MINUTE, offset);//����Сʱ֮��
        }
        if(unit.equals("hour")){
            calendar.add(Calendar.HOUR_OF_DAY, offset);//����Сʱ֮��
        }
        if(unit.equals("day")){
            calendar.add(Calendar.DAY_OF_MONTH, offset);//�����
        }
        if(unit.equals("week")){
            calendar.add(Calendar.WEEK_OF_YEAR, offset);//����Сʱ֮��
        }
        if(unit.equals("month")){
            calendar.add(Calendar.MONTH, offset);//�����
        }
        if(unit.equals("year")){
            calendar.add(Calendar.YEAR, offset);//�����
        }
        return calendar.getTime();
    }
    /**
     * ʹ�÷���
     DateJilerUtil dateObj = new DateJilerUtil();
     String formate = "yyyy-MM-dd HH:mm:ss";
     Date today = new Date();
     String dateString = dateObj.getStringFromDate(today, formate);
     System.out.println("DateתString: " + dateString);
     String dateStringDefault = dateObj.getStringFromDate(today);
     System.out.println("DateתString: " + dateStringDefault);
     Date transferFromString = dateObj.getDateFromString(dateString, formate);
     System.out.println("StringתDate: " + transferFromString);
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