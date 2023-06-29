package de.imunixx.backend.controller;

import de.imunixx.backend.service.EmailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system")
@CrossOrigin
public class SystemController {

    private final EmailSenderService emailSenderService;

    public SystemController(EmailSenderService emailSenderService) { this.emailSenderService = emailSenderService; }

    @PostMapping(path = "/send-email", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void sendEmail(@RequestParam("toEmail") String toEmail, @RequestParam("subject") String subject, @RequestParam("body") String body) throws MessagingException {
        emailSenderService.sendEmail(toEmail, subject, body, false);
    }
}
