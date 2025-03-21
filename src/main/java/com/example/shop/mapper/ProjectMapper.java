package com.example.shop.mapper;

import com.example.shop.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectMapper {

    Project getProjectById(@Param("id") int id);

    List<Project> getAllProjects();

    void createProject(Project project);

    void updateProject(Project project);

    void deleteProject(@Param("id") int id);

    List<Project> getProjectsByCategory(String category);
    List<Project> searchProjects(String category, String query);
}
