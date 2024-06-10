package com.doubtclerance.apis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doubtclerance.apis.enitites.HyperLeap.AssignmentSubjectsGradeMapping;
import com.doubtclerance.apis.repositories.HyperLeap.AssignmentSubjectsGradeMappingRepository;
import com.doubtclerance.apis.responseDTOs.Hyperleap.GetAssignmentSubjectsGradeMappingResponse;
import com.doubtclerance.apis.requestDTOs.Hyperleap.GetAssignmentSubjectsGradeMappingRequest;
import com.doubtclerance.apis.responseDTOs.Hyperleap.GetAssignmentSubjectsGradeMappingResponse;
import com.doubtclerance.apis.service.AssignmentSubjectService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import reactor.core.publisher.Flux;

import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@Operation(summary = "AssignmentSubjectsGradeMapping", responses = {
    @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AssignmentSubjectsGradeMapping.class))),
    @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
    @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })
    @GetMapping(value = "/assignmentSubjectsGradeMapping")
public List<AssignmentSubjectsGradeMapping> AssignmentSubjectsGrade(@RequestParam(value = "gradeId", required = true) Integer gradeId,
    @RequestParam(value = "tenantId", required = true) Integer tenantId, @RequestParam(value = "examId", required = true) Integer examId) {
        return assignmentSubjectsService.getAssignmentSubjectsGradeMapping(gradeId, tenantId, examId);
}
