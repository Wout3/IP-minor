package r0661554.project.taskmanager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import r0661554.project.taskmanager.dto.Taskdto;
import r0661554.project.taskmanager.repository.TaskRepository;
import r0661554.project.taskmanager.service.TaskService;
import r0661554.project.taskmanager.service.TaskServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

   // @Autowired
   // public TaskController(TaskService taskService){ this.taskService = taskService; }

    @Autowired
    public TaskController(TaskRepository repo){ this.taskService = new TaskServiceImpl(repo); }


    @GetMapping
    public String getTask(Model model){
        model.addAttribute("tasks", taskService.getTaskdtos());
        return "task";
    }

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @PostMapping("/new")
    public String addTask(@ModelAttribute @Valid Taskdto taskdto, BindingResult bindingresult, Model model){
        if(bindingresult.hasErrors())
        {
            model.addAttribute("task", taskdto);
            return "new";
        }
        taskService.addTask(taskdto);
        return "redirect:/tasks";
    }

    @GetMapping("/new")
    public String addTask(Model model){
        model.addAttribute("task", new Taskdto());
        return "new";
    }

    @PostMapping("/{id}/sub/create")
    public String addSubTask(@ModelAttribute @Valid Taskdto taskdto, BindingResult bindingresult, Model model, @PathVariable("id") Long id){
        if(bindingresult.hasErrors())
        {
            model.addAttribute("task", taskdto);
            return "newsub";
        }
        taskService.addSubTask(taskdto, id);
        model.addAttribute("task", taskService.getTaskdto(id));
        System.out.println("string::" + taskService.getTaskdto(id).getSubTasks().size());
        //model.addAttribute("subtasks", taskService.getTask(id).getSubTasks());
        return "redirect:/tasks/" + id;
    }

    @GetMapping("/{id}/sub/create")
    public String addSubTask(Model model, @PathVariable("id") Long id){
        Taskdto taskdto = taskService.getTaskdto(id);
        model.addAttribute("task", taskdto);
        return "newsub";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@ModelAttribute @Valid Taskdto taskdto, BindingResult bindingresult, Model model, @PathVariable("id") Long id){
        if(bindingresult.hasErrors())
        {
            model.addAttribute("task", taskdto);
            return "redirect:/tasks/" + taskdto.getId() ;
        }
        Taskdto t = taskService.updateTask(taskdto);
        //model.addAttribute("task", taskService.getTaskdto(id));
        return "redirect:/tasks/" + t.getId() ;
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable("id") Long id, Model model){
        Taskdto taskdto = taskService.getTaskdto(id);
        model.addAttribute("task", taskdto);
        return "edit";
    }

    @GetMapping("/{id}")
    public String getTaskDescription(Model model, @PathVariable("id") Long id)
    {
        model.addAttribute("task", taskService.getTaskdto(id));
        return "discription";
    }
}
