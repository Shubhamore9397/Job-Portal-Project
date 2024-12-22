package com.project.JobApp;

import com.project.JobApp.model.JobPost;
import com.project.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }


    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId){
        return service.getJob(postId);
    }


    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }


    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }


    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId)
    {
        service.deleteJob(postId);
        return "Deleted";
    }


    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable String keyword){
        return service.search(keyword);
    }


    @GetMapping("load")
    public String loadData(){
        service.load();
        return "Success";
    }
}
