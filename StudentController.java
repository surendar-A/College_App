package com.Ted;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.save(student);
    }
    @GetMapping("/st")
    public String vo()
    {
        return "student";
    }

    @GetMapping("/login4")
    public String showLoginForm() {
        return "login"; // Returns the login.html view
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        // Handle authentication (this is just a placeholder)
        if ("Surendar".equals(username) && "1234".equals(password) && "Student".equals(role)) {
            return "student"; // Redirect to a dashboard on successful login
        }
        else if ("faculty".equals(username) && "faculty1".equals(password) && "Faculty".equals(role)){
            return "faculty"; // Redirect to a dashboard on successful login
        }
        if ("admin".equals(username) && "admin1".equals(password)&& "Admin".equals(role) ){
            return "admin"; // Redirect to a dashboard on successful login
        }
        return "redirect:/login?error"; // Redirect back to login with error
    }
}
