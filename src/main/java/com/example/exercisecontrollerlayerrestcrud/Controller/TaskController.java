package com.example.exercisecontrollerlayerrestcrud.Controller;

import com.example.exercisecontrollerlayerrestcrud.Api.Apiresponse;
import com.example.exercisecontrollerlayerrestcrud.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Task> getTask() {
        return tasks;
    }

    @PostMapping("/add")
    public Apiresponse addTask(@RequestBody Task task) {
        tasks.add(task);
        return new Apiresponse("Task added");
    }

    @PutMapping("/update/{index}")
    public Apiresponse updatedTask(@PathVariable int index, @RequestBody Task task) {
        tasks.set(index, task);
        return new Apiresponse(" Task updated ");
    }


    @DeleteMapping("/delete/{index}")
    public Apiresponse deletedTask(@PathVariable int index) {
        tasks.remove(index);
        return  new Apiresponse("Task Deleted");
    }

    @PutMapping("/change/{index}")
    public Apiresponse changedTask(@PathVariable int index) {

        if (tasks.get(index).getStatus().equalsIgnoreCase("not done")) {
            tasks.get(index).setStatus("done");
            return new Apiresponse( " Task changed ");}
    
            return new Apiresponse( " Task not changed ");

    }

    @GetMapping("/Search/{title}")
    public Apiresponse SearchTask(@PathVariable String title ){
        for (Task t: tasks) {
            if (t.getTitle().equalsIgnoreCase(title))
               return new Apiresponse( " title is found ");
        }

        return new Apiresponse( " title is not found ");
    }

}