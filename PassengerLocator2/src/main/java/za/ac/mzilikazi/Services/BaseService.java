package za.ac.mzilikazi.Services;

public interface BaseService <E, ID> {
    E save(E id);
    E findById(ID id);
    E update(E id);
    void delete(E id);
}
