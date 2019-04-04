package com.codegym.controllers;

import com.codegym.model.Student;
import com.codegym.service.StudentServiceImpl;
import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.*;

@Controller
public class StudentController {

    StudentServiceImpl studentService = new StudentServiceImpl();

    @RequestMapping(value = "/list")
    public String list(Model model){
        List<Student> students = this.studentService.list();
        model.addAttribute("students", this.studentService.list());
        model.addAttribute("students", students);
        return "list";
    }

    @RequestMapping( value = "/add")
    public String add(Model model){
        model.addAttribute("student", new Student());
        return "input";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student, Model model){
        if (this.studentService.isContains(student.getId())){
            model.addAttribute("message", "This id student is existed!");
            return "input";
        }else{
            this.studentService.save(student);
            model.addAttribute("students", this.studentService.list());
            model.addAttribute("message", "New student was added!");
            return "list";
        }
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam int id, Model model){
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "edit";
    }

    @RequestMapping(value = "/editStudent", method = RequestMethod.POST)
    public String editStudent(@ModelAttribute @Validated Student student, Model model){
       // this.studentService.remove(student.getId());
        studentService.update(student);
        model.addAttribute("students", this.studentService.list());
        model.addAttribute("message", "Information of a student was update!");
        return "list";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam int id, Model model){
        this.studentService.remove(id);
        model.addAttribute("students", this.studentService.list());
        model.addAttribute("message", "Information of a student was deleted!");
        return "list";
    }

    @RequestMapping(value = "/view")
    public String view(@RequestParam int id, Model model){
        Student student = this.studentService.findById(id);
        model.addAttribute("student", student);
        return "view";
    }

    @RequestMapping(value = "/searchStudent", method = RequestMethod.POST)
    public String searchStudent(@RequestParam String ID, Model model){
        int id;
        try{
            id = Integer.parseInt(ID);
        }catch (NumberFormatException e){
            model.addAttribute("error", e.getMessage());
            return "error";
        }
        Student student = this.studentService.findById(id);
        if (student == null){
            model.addAttribute("message", "This student does not existed");
            return "list";
        }else{
            model.addAttribute("student", student);
            return "view";
        }
    }

    @ExceptionHandler(BindException.class)
    private ModelAndView invalidData(BindException e){
        StringBuilder error = new StringBuilder();
        for (ObjectError objectError : e.getAllErrors()) {
            error.append(objectError.getDefaultMessage());
        }
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", error);
        return modelAndView;
    }
}
