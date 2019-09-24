package dev.zacharyhubbs.camundareactiveclient.service;

import dev.zacharyhubbs.camundareactiveclient.client.ProcessInstanceClient;
import org.camunda.bpm.engine.rest.dto.runtime.ProcessInstanceDto;
import org.camunda.bpm.engine.rest.dto.runtime.ProcessInstanceQueryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessInstanceService {

    ProcessInstanceClient processInstanceClient;


    public ProcessInstanceService(ProcessInstanceClient processInstanceClient) {
        this.processInstanceClient = processInstanceClient;
    }

    public ProcessInstanceDto getProcessInstanceById(String taskId) {
        return processInstanceClient.getResult(taskId);
    }

    public List<ProcessInstanceDto> getProcessInstanceByQuery(ProcessInstanceQueryDto processInstanceQueryDto) {
        return processInstanceClient.getResult(processInstanceQueryDto);
    }
}
