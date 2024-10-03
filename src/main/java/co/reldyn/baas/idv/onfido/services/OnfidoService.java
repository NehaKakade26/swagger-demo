package co.reldyn.baas.idv.onfido.services;

import co.reldyn.baas.idv.onfido.clients.OnfidoClient;
import co.reldyn.baas.idv.onfido.common.ResponseEnum.ResponseCode;
import co.reldyn.baas.idv.onfido.dtos.CreateApplicantDto;
import co.reldyn.baas.idv.onfido.dtos.CreateWorkflowRunDto;
import co.reldyn.baas.idv.onfido.entities.Profile;
import co.reldyn.baas.idv.onfido.exceptions.BusinessException;
import co.reldyn.baas.idv.onfido.repositories.ProfileRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OnfidoService {

    private final OnfidoClient client;
    private final ProfileRepository profileRepository;
    private final String CONTEXT = "onfido_service";

    public CreateApplicantDto.Response createApplicant(CreateApplicantDto.Request dto) {
        try {
            return client.createApplicant(dto);
        } catch (FeignException e) {
            log.debug("Error occured while creating applicant.......");
            throw new BusinessException(
                    String.valueOf(ResponseCode.APPLICANT_CREATION_ERROR.getCode()),
                    ResponseCode.APPLICANT_CREATION_ERROR.getMessage(),
                    CONTEXT);
        }
    }

    public CreateWorkflowRunDto.Response createWorkflowRun(CreateWorkflowRunDto.Request dto) {
        try {
            return client.createWorkflowRun(dto);
        } catch (FeignException e) {
            log.debug(
                    "Error occured while creating workflow for applicant : {}",
                    dto.getApplicantId());
            throw new BusinessException(
                    String.valueOf(ResponseCode.WORKFLOW_CREATION_ERROR.getCode()),
                    ResponseCode.WORKFLOW_CREATION_ERROR.getMessage(),
                    CONTEXT);
        }
    }

    public void getCallback(Object payload) throws JsonProcessingException {
        // Saving the data from callback into database
        ObjectMapper objectMapper = new ObjectMapper();
        String data = objectMapper.writeValueAsString(payload);
        Profile profile = Profile.builder().data(data).build();
        profileRepository.save(profile);
    }

    public CreateWorkflowRunDto.Response retrieveWorkflowRun(String workflowRunId) {
        try {
            // return client.retrieveWorkflowRun(workflowRunId);
            return CreateWorkflowRunDto.Response.builder().id(workflowRunId).build();
        } catch (FeignException e) {
            log.debug(
                    "Error occured while retrieving workflow for applicant, Workflow Id : {}",
                    workflowRunId,
                    e);
            throw new BusinessException(
                    String.valueOf(ResponseCode.RETRIEVE_WORKFLOW_ERROR.getCode()),
                    ResponseCode.RETRIEVE_WORKFLOW_ERROR.getMessage(),
                    CONTEXT);
        }
    }

    public List<CreateWorkflowRunDto.Response> retrieveWorkflowRunList() {
        try {
            return client.retrieveWorkflowRunList();
        } catch (FeignException e) {
            log.debug("Error occured while retrieving workflow list for applicant");
            throw new BusinessException(
                    String.valueOf(ResponseCode.RETRIEVE_WORKFLOW_LIST_ERROR.getCode()),
                    ResponseCode.RETRIEVE_WORKFLOW_LIST_ERROR.getMessage(),
                    CONTEXT);
        }
    }
}
