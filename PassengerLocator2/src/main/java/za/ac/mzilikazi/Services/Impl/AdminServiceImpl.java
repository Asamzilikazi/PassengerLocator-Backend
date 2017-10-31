package za.ac.mzilikazi.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.mzilikazi.Domain.Admin;
import za.ac.mzilikazi.Repository.AdminRepository;
import za.ac.mzilikazi.Services.AdminService;

@Component
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository repository;

    @Override
    public Admin save(Admin entity)
    {
        return repository.save(entity);
    }

    @Override
    public Admin findById(String s)
    {
        return repository.findOne(s);
    }

    @Override
    public Admin update(Admin entity)
    {
        return repository.save(entity);
    }

    @Override
    public void delete(Admin entity)
    {
        repository.delete(entity);
    }


}

