package dev.zacharyhubbs.camundareactiveclient.service;

import dev.zacharyhubbs.camundareactiveclient.client.TaskClient;
import lombok.Data;
import org.camunda.bpm.engine.rest.dto.task.TaskDto;
import org.camunda.bpm.engine.rest.dto.task.TaskQueryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskClientService {

    private TaskClient client;

    public TaskClientService(TaskClient client){
        this.client = client;
    }

    public TaskDto getTaskById(String taskId){
        return client.getTaskById(taskId);
    }
    public List<TaskDto> getTaskByQuery(TaskQueryDto taskQueryDto){
        return client.getTaskByQuery(taskQueryDto);
    }
}
