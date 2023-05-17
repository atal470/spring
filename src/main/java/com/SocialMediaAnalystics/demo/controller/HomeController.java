package com.SocialMediaAnalystics.demo.controller;


import com.SocialMediaAnalystics.demo.model.Alien;
import com.SocialMediaAnalystics.demo.repository.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    @Autowired
    AlienRepo alienRepo;
    //find all value in alien table
    //Read
    @RequestMapping("/aliens")
    @ResponseBody
    public List<Alien> Alien(){
        return alienRepo.findAll();
    }
    //view homes.html
    @RequestMapping("/homes")
    public String home()
    {
        return "homes.html";
    }

    //pass a pid value that is present in the table and find the information about it
    @RequestMapping("/alien/{pid}")
    @ResponseBody
    public Optional<Alien> Alien(@PathVariable("pid") int pid){
        return alienRepo.findById(pid);
    }
    //add value in the table
    //Create
    @PostMapping(path = "/alien",consumes = {"application/json"})
    @ResponseBody
    public Alien addAlien(@RequestBody Alien alien){
        alienRepo.save(alien);
        return alien;
        }
    //Delete the value
    @DeleteMapping("/aliend/{pid}")
    @ResponseBody
    public String deleteAlien(@PathVariable("pid") int pid){
        Alien a=alienRepo.getOne(pid);
        System.out.println(a);
        alienRepo.delete(a);
        return "Deleted";

    }
    //Updating the value
    @PutMapping(path = "/UpdateAlien",consumes = {"application/json"})
    @ResponseBody
    public Alien UpdateAlien(@RequestBody Alien alien){
        alienRepo.save(alien);
        return alien;
    }

    //Repository Function

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int id){
        Alien alien= alienRepo.findById(id).orElse(new Alien());
        System.out.println("re");
        ModelAndView mv=new ModelAndView();
        mv.addObject(alien);
        mv.setViewName("home.jsp");
        System.out.println(mv);
//        System.out.println("value"+alienRepo.findByTech("Python").toString());
//        System.out.println(alienRepo.findByAidGreaterThan(103));
//        System.out.println(alienRepo.findByTechSorted("Python"));
        return mv;

    }

}
