package dev.zacharyhubbs.camundareactiveclient.service;

import dev.zacharyhubbs.camundareactiveclient.client.ProcessInstanceClient;
import dev.zacharyhubbs.camundareactiveclient.model.ProcessInstanceImpl;
import org.camunda.bpm.engine.rest.dto.runtime.ProcessInstanceQueryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessInstanceService {

    ProcessInstanceClient processInstanceClient;


    public ProcessInstanceService(ProcessInstanceClient processInstanceClient) {
        this.processInstanceClient = processInstanceClient;
    }

    public ProcessInstanceImpl getProcessInstanceById(String taskId) {
        return processInstanceClient.getResult(taskId);
    }

    public List<ProcessInstanceImpl> getProcessInstanceByQuery(ProcessInstanceQueryDto processInstanceQueryDto) {
        return processInstanceClient.getResult(processInstanceQueryDto);
    }
}
