- src
  - main
    - java
      - com.exam
        - controller
          - LoginController.java
          - ProfileController.java
          - ExamController.java
          - SessionController.java
        - model
          - User.java
          - Question.java
        - service
          - UserService.java
          - ExamService.java
        - repository
          - UserRepository.java
          - QuestionRepository.java
        - util
          - TimerUtil.java
    - resources
      - templates
        - login.html
        - profile.html
        - exam.html
        - session.html
  - test
- pom.xml


// User.java
package com.exam.model;

public class User {
    private String username;
    private String password;
    private String fullName;
    // other fields, getters, setters
}

// LoginController.java
package com.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}

// ProfileController.java
// Similar to LoginController for updating the profile

// ExamController.java
package com.exam.controller;

import com.exam.model.Question;
import com.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping("/exam")
    public String showExamPage(Model model) {
        List<Question> questions = examService.getQuestions();
        model.addAttribute("questions", questions);
        return "exam";
    }

    @PostMapping("/submit-exam")
    public String submitExam(/* handle submitted answers */) {
        // Logic to handle submitted answers
        return "redirect:/session";
    }
}

// SessionController.java
package com.exam.controller;

import com.exam.util.TimerUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {

    @GetMapping("/session")
    public String showSessionPage(Model model) {
        // Set model attributes for the session page
        model.addAttribute("remainingTime", TimerUtil.calculateRemainingTime());
        return "session";
    }

    @GetMapping("/end-session")
    public String endSession() {
        // Logic to end the session
        return "redirect:/logout";
    }
}

// TimerUtil.java
package com.exam.util;

public class TimerUtil {

    public static long calculateRemainingTime() {
        // Logic to calculate remaining time
        return 0L;
    }
}
