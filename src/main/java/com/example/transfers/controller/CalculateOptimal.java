package com.example.transfers.controller;

import com.example.transfers.controller.model.DTO.TransferDTO;
import com.example.transfers.controller.model.TransfersInput;
import com.example.transfers.controller.model.TransfersOutput;
import com.example.transfers.service.ServiceClass;
import com.example.transfers.service.model.FinalResult;
import com.example.transfers.service.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculateOptimal {

    @Autowired
    private ServiceClass serviceClass;

    @GetMapping("/calculate")
    public ResponseEntity<TransfersOutput> calculate(@RequestBody TransfersInput input) {

        List<Transfer> transfers = input.getAvailableTransfers().stream().map(
                transferDTO -> Transfer.builder()
                        .cost(transferDTO.getCost())
                        .weight(transferDTO.getWeight())
                        .build()
        ).toList();

        FinalResult selectedTransfers = serviceClass.optimalSolution(input.getMaxWeight(), transfers, input.getMaxBoxWeight());

        TransfersOutput output = TransfersOutput.builder()
                .totalCost(selectedTransfers.getTotalCost())
                .totalWeight(selectedTransfers.getTotalWeight())
                .transfers(selectedTransfers.getTransfers().stream().map(
                        transfersList -> transfersList.stream().map(
                                transfer -> TransferDTO.builder()
                                        .weight(transfer.getWeight())
                                        .cost(transfer.getCost())
                                        .build()
                        ).toList()
                ).toList()).build();

        return ResponseEntity.ok(output);
    }
}
