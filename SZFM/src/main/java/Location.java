public class Location {
    private int locID;
    private int fullness; // telítettség százalékban
    private int max; //maximum férőhely
    private int nowin; //bentlévő járművek
    private String address; //cím

    public Location(int locID, int max, int nowin, String address) {
        this.locID = locID;
        this.max = max;
        this.nowin = nowin;
        this.address = address;
    }

    public int getLocID() {
        return locID;
    }

    public void setLocID(int locID) {
        this.locID = locID;
    }

    public int getFullness() {
        return fullness;
    }

    public void setFullness(int fullness) {
        this.fullness = (getNowin()/getMax())*100;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getNowin() {
        return nowin;
    }

    public void setNowin(int nowin) {
        this.nowin = nowin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
