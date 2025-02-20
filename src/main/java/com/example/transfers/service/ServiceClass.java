package com.example.transfers.service;

import com.example.transfers.service.model.FinalResult;
import com.example.transfers.service.model.SelectedTransfers;
import com.example.transfers.service.model.Transfer;

import java.util.List;

public interface ServiceClass {

    FinalResult optimalSolution(int maxWeight, List<Transfer> transfers, int maxBoxWeight);

}
