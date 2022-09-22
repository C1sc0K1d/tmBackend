package personal.tmBackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.tmBackend.dtos.TransferenceDataDto;
import personal.tmBackend.entities.TransferenceData;
import personal.tmBackend.mappers.TransferenceDataMapper;
import personal.tmBackend.requests.TransferenceDataRequest;
import personal.tmBackend.responses.TransferenceDataResponse;
import personal.tmBackend.services.TransferenceDataService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tranfer")
@RequiredArgsConstructor
public class TransferenceDataController {

    private final TransferenceDataMapper mapper;
    private final TransferenceDataService service;

    @GetMapping
    public List<TransferenceDataDto> getAll() {
        return this.service.findAll();
    }

    @PostMapping
    public ResponseEntity<?> addTranference(@RequestBody @Valid TransferenceDataRequest request) {
        TransferenceData transferenceData = this.service.transfer(request);
        if (transferenceData.getTax().isBlank() || transferenceData.getTax().isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Transação não valida");
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(this.mapper.toSingleResult(transferenceData), HttpStatus.OK) ;
    }

    private class ErrorResponse {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
