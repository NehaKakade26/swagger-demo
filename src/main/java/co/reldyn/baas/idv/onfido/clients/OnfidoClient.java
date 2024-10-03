package co.reldyn.baas.idv.onfido.clients;

import co.reldyn.baas.idv.onfido.config.OnfidoClientConfig;
import co.reldyn.baas.idv.onfido.dtos.CreateApplicantDto;
import co.reldyn.baas.idv.onfido.dtos.CreateWorkflowRunDto;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "onfido-client",
        url = "${onfido.base.url}",
        configuration = OnfidoClientConfig.class)
public interface OnfidoClient {

    @PostMapping("/v3.6/applicants/")
    CreateApplicantDto.Response createApplicant(@RequestBody CreateApplicantDto.Request dto);

    @PostMapping("/v3.6/workflow_runs/")
    CreateWorkflowRunDto.Response createWorkflowRun(@RequestBody CreateWorkflowRunDto.Request dto);

    @GetMapping("/v3.6/workflow_runs/{workflowRunId}")
    CreateWorkflowRunDto.Response retrieveWorkflowRun(
            @PathVariable("workflowRunId") String workflowRunId);

    @GetMapping("/v3.6/workflow_runs")
    List<CreateWorkflowRunDto.Response> retrieveWorkflowRunList();
}
