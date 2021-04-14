package hu.unideb.inf;

import java.util.List;

public interface BicicleDAO extends AutoCloseable {
    public void saveBicicle(Bicicle b);
    public void deleteBicicle(Bicicle b);
    public void updateteBicicle(Bicicle b);
    public List<Bicicle> getBicicles();
}
