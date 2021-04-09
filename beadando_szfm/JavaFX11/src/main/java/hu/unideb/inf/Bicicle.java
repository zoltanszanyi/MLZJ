package hu.unideb.inf;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Bicicle{
    private int bicicleID; //Azonosító
    private int cost; //az ára óránként
    private long StartTime;
    private long timer; //megkezdett fél órák
    private int service = 100; //időből számolt karbantartás;
    private int available; // 1 elérhető, 0 nem
    private boolean type; //1 elektromos, 0 sima
    private int charge = 100;
    private List<String> users; //Azoknak a listája akik használták

    public Bicicle(int bicicleID, int cost, long timer, int service, int available, boolean type, int charge ,List<String> users) {
        this.bicicleID = bicicleID;
        this.cost = cost;
        this.timer = timer;
        this.service = service;
        this.available = available;
        this.type = type;
        this.charge = charge;
        this.users = users;
    }


    public Bicicle() {
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public long getStartTime() { return StartTime; }

    public void setStartTime(long startTime) { StartTime = startTime; }

    public int getBicicleID() { return bicicleID; }

    public int getCost() { return cost; }

    public long getTimer() { return timer; }

    public int getService() { return service; }

    public int getAvailable() { return available; }

    public boolean isType() { return type; }

    public List<String> getUsers() { return users; }

    public void setBicicleID(int bicicleID) { this.bicicleID = bicicleID; }

    public void setCost(int cost) { this.cost = cost; }

    public void setTimer(long timer) { this.timer = timer; }

    public void setService(int service) { this.service = service; }

    public void setAvailable(int available) { this.available = available; }

    public void setType(boolean type) { this.type = type; }

    public void setUsers(List<String> users) { this.users = users; }

    public void StartTime() //elmenti az időt amikor elvitték a járművet
    {
        setStartTime(System.currentTimeMillis()/1000);
    }

    public long StopTime() { //kiszámolja hányszor fél óra telt el a visszahozásig
        long nowTime = System.currentTimeMillis()/1000;
        long startTime = getStartTime();
        long kul = 0;
        kul = ((nowTime - startTime) * 60) / 30; //kiszámolni hányszor telt el 30p a két idő között
        setTimer(kul);
        return kul;
    }

    public void checkCharge()
    {
        setCharge((int) (getCharge()-(getTimer()*random())));
    }

    public void checkService()
    {
        setService((int) (getService()-getTimer()*3));
    }

    public int random()
    {
        int rand = (int)(1 + (Math.random() * (7 - 1)));
        return rand;
    }


}


