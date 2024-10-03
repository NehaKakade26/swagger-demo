package co.reldyn.baas.idv.onfido.controllers;

import co.reldyn.baas.idv.onfido.dtos.CreateApplicantDto;
import co.reldyn.baas.idv.onfido.dtos.CreateWorkflowRunDto;
import co.reldyn.baas.idv.onfido.services.OnfidoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/rest/api/v1")
public class OnfidoController {

    private final OnfidoService onfidoService;

    @PostMapping("/create-applicant")
    public ResponseEntity<CreateApplicantDto.Response> createApplicant(
            @RequestBody CreateApplicantDto.Request dto) {
        log.debug("Dto obtained : {}", dto);
        CreateApplicantDto.Response response = onfidoService.createApplicant(dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create-workflow-run")
    public ResponseEntity<CreateWorkflowRunDto.Response> createWorkflowRun(
            @RequestBody CreateWorkflowRunDto.Request dto) {
        log.debug("Dto obtained : {}", dto);
        CreateWorkflowRunDto.Response response = onfidoService.createWorkflowRun(dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/callback")
    public ResponseEntity<String> getCallBack(@RequestBody Object payload) {
        try {
            log.debug("Callback received.......");
            log.debug("===================================================================");
            log.debug("Callback object received:---------- {}", payload);
            onfidoService.getCallback(payload);
            return new ResponseEntity<>("Data saved successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "Error processing webhook", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/retrieve-workflow-run/{workflowRunId}", produces = "application/json")
    public ResponseEntity<CreateWorkflowRunDto.Response> retrieveWorkflowRun(
            @PathVariable("workflowRunId") String workflowRunId) {
        log.debug("Workflow Run Id obtained : {}", workflowRunId);
        CreateWorkflowRunDto.Response response = onfidoService.retrieveWorkflowRun(workflowRunId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/retrieve-workflow-run")
    public ResponseEntity<List<CreateWorkflowRunDto.Response>> retrieveWorkflowRunList() {
        List<CreateWorkflowRunDto.Response> responseList = onfidoService.retrieveWorkflowRunList();
        return ResponseEntity.ok(responseList);
    }
}
