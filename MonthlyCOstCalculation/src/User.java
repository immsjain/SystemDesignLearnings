import java.util.*;

import static java.util.Collections.max;

public class User {
    private int id;
    private String name;

    private int[] monthlyspend;

    private Subscription lastSubscibed;
    private Date lastCalcTime;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        monthlyspend = new int[12];
        lastCalcTime = new Date(0,0,0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getMonthlyspend() {
        return monthlyspend;
    }

    public void setMonthlyspend(int[] monthlyspend) {
        this.monthlyspend = monthlyspend;
    }

    public Subscription getLastSubscibed() {
        return lastSubscibed;
    }

    public void setLastSubscibed(Subscription lastSubscibed) {
        this.lastSubscibed = lastSubscibed;
    }

    private void calculateCost(int cost, Date from, Date to){
        Date d = new Date(to.getYear(),Calendar.JANUARY,1);
        if(from.getTime()<d.getTime()){
            from = d;
        }
        int fromdays = (30-from.getDate()+1);
        monthlyspend[from.getMonth()]+=fromdays*(cost/30);
        monthlyspend[to.getMonth()]+=to.getDate()*(cost/30);
        for (int i = from.getMonth()+1;i<to.getMonth();i++) {
            monthlyspend[i]+=cost;
        }
        lastCalcTime = new Date();
    }

    public void Subscribe(Package p, Date date){
        Subscription subscription = new Subscription(p,date);
        if(lastSubscibed!=null){
            Date d = max(lastCalcTime.getTime(),lastSubscibed.getTimestamp().getTime());
            calculateCost(lastSubscibed.getaPackage().getPrice(),d,new Date());
        }
        lastSubscibed = subscription;
        return;
    }

    private Date max(long time, long time1) {
        if(time>=time1){
            return new Date(time);
        }
        return new Date(time1);
    }

    public int getMonthSpend(int month, Date date){
        if(lastSubscibed==null){
            return 0;
        }
        Date d = max(lastCalcTime.getTime(),lastSubscibed.getTimestamp().getTime());
        calculateCost(lastSubscibed.getaPackage().getPrice(),d,date);
        return monthlyspend[month];
    }
}
