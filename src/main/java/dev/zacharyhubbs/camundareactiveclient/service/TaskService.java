package dev.zacharyhubbs.camundareactiveclient.service;

import dev.zacharyhubbs.camundareactiveclient.client.TaskClient;
import dev.zacharyhubbs.camundareactiveclient.model.TaskImpl;
import org.camunda.bpm.engine.rest.dto.task.TaskQueryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    TaskClient client;

    public TaskService(TaskClient client){
        this.client = client;
    }

    public TaskImpl getTaskById(String taskId){
        return client.getResult(taskId);
    }
    public List<TaskImpl> getTaskByQuery(TaskQueryDto taskQueryDto){
        return client.getResult(taskQueryDto);
    }
}
