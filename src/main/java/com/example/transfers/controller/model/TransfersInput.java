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
public class TransfersInput {
    int maxWeight;
    int maxBoxWeight;
    List<TransferDTO> availableTransfers;
}
