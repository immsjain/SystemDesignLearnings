import java.util.*;

public class MapBasedJobScheduler implements JobScheduler{
    Map<Date,List<Job>>map;

    public MapBasedJobScheduler() {
        this.map = new HashMap<>();
    }

    public Map<Date, List<Job>> getMap() {
        return map;
    }

    public void setMap(Map<Date, List<Job>> map) {
        this.map = map;
    }

    @Override
    public boolean scheduleReq(Request req) {
        if(!map.containsKey(req.getDate())){
            map.put(req.getDate(),new ArrayList<>());
        }else if(map.get(req.getDate()).contains(req.getJob())){
            System.out.println("job already scheduled");
            return false;
        }
        System.out.println("job has been scheduled successfully");
        map.get(req.getDate()).add(req.getJob());
        return true;
    }

    @Override
    public boolean executeRequest(Date date) {
        if(!map.containsKey(date)){
            System.out.println("no job has been found");
            return false;
        }
        List<Job>list = map.get(date);
        for (Job job: list) {
            job.run();
        }
        return true;
    }

    @Override
    public List<Job> getAllScheduledReq(Date date) {
        if(!map.containsKey(date)){
            System.out.println("no job has been found");
            return new ArrayList<>();
        }
        return map.get(date);
    }
}
