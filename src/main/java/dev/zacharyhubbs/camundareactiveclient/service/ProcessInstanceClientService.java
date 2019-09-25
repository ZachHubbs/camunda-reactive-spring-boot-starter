package dev.zacharyhubbs.camundareactiveclient.service;

import dev.zacharyhubbs.camundareactiveclient.client.ProcessInstanceClient;
import org.camunda.bpm.engine.rest.dto.runtime.ProcessInstanceDto;
import org.camunda.bpm.engine.rest.dto.runtime.ProcessInstanceQueryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessInstanceClientService {

   private ProcessInstanceClient processInstanceClient;


    public ProcessInstanceClientService(ProcessInstanceClient processInstanceClient) {
        this.processInstanceClient = processInstanceClient;
    }

    public ProcessInstanceDto getProcessInstanceById(String taskId) {
       return processInstanceClient.getProcessInstanceById(taskId).flatMap(res -> res.bodyToMono(ProcessInstanceDto.class)).block();

    }

    public List<ProcessInstanceDto> getProcessInstanceByQuery(ProcessInstanceQueryDto processInstanceQueryDto) {
        return processInstanceClient.getProcessInstancesByQuery(processInstanceQueryDto).flatMap(res -> res.bodyToMono(List.class)).block();
    }
}
