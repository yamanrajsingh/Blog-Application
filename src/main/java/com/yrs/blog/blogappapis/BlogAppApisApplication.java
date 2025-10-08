package com.yrs.blog.blogappapis;

import com.yrs.blog.blogappapis.config.AppConstant;
import com.yrs.blog.blogappapis.entities.Role;
import com.yrs.blog.blogappapis.repositories.RoleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class BlogAppApisApplication {

    @Autowired
    private RoleRepo roleRepo;



    public static void main(String[] args) {

        SpringApplication.run(BlogAppApisApplication.class, args);
    }


  @Bean
  public ModelMapper modelMapper(){
        return new ModelMapper();
  }

    public void run(String... args) throws Exception {
        try{
            Role role = new Role();
            role.setId(AppConstant.ADMIN_USER);
            role.setRole("ROLE_ADMIN");

            Role role1 = new Role();
            role1.setId(AppConstant.NORMAL_USER);
            role1.setRole("ROLE_USER");
            List<Role> roles = List.of(role, role1);
            List <Role> result =  this.roleRepo.saveAll(roles);

            result.forEach(System.out::println);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
