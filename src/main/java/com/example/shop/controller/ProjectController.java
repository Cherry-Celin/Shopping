package com.example.shop.controller;

import com.example.shop.entity.Project;
import com.example.shop.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectMapper projectMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable int id) {
        Project project = projectMapper.getProjectById(id);
        if (project == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(project);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectMapper.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @PostMapping
    public ResponseEntity<String> createProject(@RequestBody Project project) {
        project.setCreate_time(new Date());
        projectMapper.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body("项目创建成功");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProject(@PathVariable int id, @RequestBody Project project) {
        project.setId(id);
        project.setCreate_time(new Date());
        projectMapper.updateProject(project);
        return ResponseEntity.ok("项目更新成功");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable int id) {
        projectMapper.deleteProject(id);
        return ResponseEntity.ok("项目删除成功");
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Project>> getProjectsByCategory(@PathVariable String category) {
        List<Project> projects = projectMapper.getProjectsByCategory(category);
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Project>> searchProjects(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String query) {

        List<Project> projects = projectMapper.searchProjects(category, query);
        return ResponseEntity.ok(projects);
    }
}
