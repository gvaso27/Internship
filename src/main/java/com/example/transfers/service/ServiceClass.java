package com.example.transfers.service;

import com.example.transfers.service.model.SelectedTransfers;
import com.example.transfers.service.model.Transfer;

import java.util.List;

public interface ServiceClass {

    SelectedTransfers optimalSolution(int maxWeight, List<Transfer> transfers);

}
