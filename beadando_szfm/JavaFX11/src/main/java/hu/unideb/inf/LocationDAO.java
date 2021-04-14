package hu.unideb.inf;

import java.util.List;

public interface LocationDAO extends AutoCloseable {
    public void saveLocation(Location l);
    public void deleteLocation(Location l);
    public void updateteLocation(Location l);
    public List<Location> getLocations();
}
