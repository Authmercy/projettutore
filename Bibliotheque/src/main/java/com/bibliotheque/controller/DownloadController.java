package com.bibliotheque.controller;

import com.bibliotheque.repository.CategoryRepository;
import com.bibliotheque.repository.DownloadRepository;
import com.bibliotheque.services.DownloadService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("files")
@AllArgsConstructor
public class DownloadController {

}
