package com.example.transfers.controller.model;

import com.example.transfers.controller.model.DTO.TransferDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransfersOutput {
    List<TransferDTO> transfers;
    int totalCost;
    int totalWeight;

}
