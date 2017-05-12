
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by wujunpeng on 2017/5/12.
 * 根据RemindEmailRange的前两个字段排序，
 */
public class ObjectListSortUtil {
    /**
     * 为对象排序(插入法排序)
     * @param arrayList<RemindEmailRange> 输入参数是ArrayList
     * @return 输出参数是LinkedList,
     */
    public LinkedList<RemindEmailRange> rangeForList(ArrayList<RemindEmailRange> arrayList){
        LinkedList<RemindEmailRange> linkedList = new LinkedList<RemindEmailRange>();
        for(RemindEmailRange remindEmailRange : arrayList){
            if(linkedList.size()==0){
                linkedList.add(remindEmailRange);
                continue;
            }
            int length = linkedList.size();
            int i = 0;
            for(; i < length; i++){
                RemindEmailRange lindObj = linkedList.get(i);
                if(lindObj.getAccountName().hashCode() < remindEmailRange.getAccountName().hashCode()) {
                    continue;
                } else if (lindObj.getAccountName().hashCode() == remindEmailRange.getAccountName().hashCode()){
                    if(lindObj.getTime().hashCode()< remindEmailRange.getTime().hashCode()){
                        continue;
                    } else {
                        linkedList.add(i, remindEmailRange);
                        break;
                    }
                } else {
                    linkedList.add(i, remindEmailRange);
                    break;
                }
            }
            if(i == length){
                linkedList.add(i, remindEmailRange);
            }
        }
        return linkedList;
    }

    class RemindEmailRange{
        private String accountName;
        private String time;
        private Double money;

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Double getMoney() {
            return money;
        }

        public void setMoney(Double money) {
            this.money = money;
        }
    }
}
