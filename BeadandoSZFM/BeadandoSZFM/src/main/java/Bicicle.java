import java.time.LocalTime;
import java.util.List;

public class Bicicle{
    private int bicicleID; //Azonosító
    private int cost; //az ára óránként
    private LocalTime StartTime;
    private int timer; //megkezdett fél órák
    private int service; //időből számolt karbantartás;
    private int available; // 1 elérhető, 0 nem
    private boolean type; //1 elektromos, 0 sima
    private List<String> users; //Azoknak a listája akik használták

    public Bicicle(int bicicleID, int cost, int timer, int service, int available, boolean type, List<String> users) {
        this.bicicleID = bicicleID;
        this.cost = cost;
        this.timer = timer;
        this.service = service;
        this.available = available;
        this.type = type;
        this.users = users;
    }

    public LocalTime getStartTime() {
        return StartTime;
    }

    public void setStartTime(LocalTime startTime) {
        StartTime = startTime;
    }

    public int getBicicleID() {
        return bicicleID;
    }

    public int getCost() {
        return cost;
    }

    public int getTimer() {
        return timer;
    }

    public int getService() {
        return service;
    }

    public int getAvailable() {
        return available;
    }

    public boolean isType() {
        return type;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setBicicleID(int bicicleID) {
        this.bicicleID = bicicleID;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void setService(int service) {
        this.service = service;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
    public void StartTime() //elmenti az időt amikor elvitték a járművet
    {
        setStartTime(LocalTime.now());
    }

    public void StopTime() { //kiszámolja hányszor fél őra telt el a visszahozásig
        String now = LocalTime.now().toString();//Stringre konvertálás a befejezés idejét
        String start = getStartTime().toString();//Stringre konvertálás a kezdés idejét
        String t1[] = now.split(":");//Splitelés ':'-ként 18:12:05.172 -> {'18';'12';'05.172'}
        String t2[] = start.split(":");
        int kul = 0;
        int[] ido1 = new int[t1.length - 1];
        int[] ido2 = new int[t1.length - 1];
        for (int i = 0; i < t1.length - 1; i++) { // óra és perc konvertálása int-be úgy hogy elhagyjuk a másodpercet nehogy bezavarjon
            ido1[i] = Integer.parseInt(t1[i]);
            ido2[i] = Integer.parseInt(t2[i]);
        }
        kul = ((ido2[0] - ido1[0]) * 60 + (ido2[1] - ido1[1])) / 30; //kiszámolni hányszor telt el 30p a két idő között
        setTimer(kul);
    }

    //private Users user;
    Users user = new Users(123,"asd","asd");
    public Users getUser() {
        return user;
    }
}


