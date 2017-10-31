package za.ac.mzilikazi.Repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.mzilikazi.Domain.Admin;

public interface AdminRepository extends CrudRepository<Admin, String> {

}