package com.example.transfers.service;

import com.example.transfers.service.model.FinalResult;
import com.example.transfers.service.model.SelectedTransfers;
import com.example.transfers.service.model.Transfer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.max;

@Service
public class ServiceClassImpl implements ServiceClass {

    @Override
    public FinalResult optimalSolution(int maxWeight, List<Transfer> transfers, int maxBoxWeight){
        FinalResult result = FinalResult.builder()
                .totalCost(0)
                .totalWeight(0)
                .transfers(new ArrayList<>())
                .build();

        int currentW = 0;
        while (currentW <= maxWeight){
            currentW += maxBoxWeight;
            SelectedTransfers currTransfer = helper (maxBoxWeight, transfers);
            result.setTotalWeight(result.getTotalWeight() +  currTransfer.getTotalWeight());
            result.setTotalCost(result.getTotalCost() +  currTransfer.getTotalCost());
            result.getTransfers().add(currTransfer.getTransfers());
        }

        if(currentW % maxWeight != 0){
            SelectedTransfers currTransfer = helper (maxWeight % maxBoxWeight, transfers);
            result.setTotalWeight(result.getTotalWeight() +  currTransfer.getTotalWeight());
            result.setTotalCost(result.getTotalCost() +  currTransfer.getTotalCost());
            result.getTransfers().add(currTransfer.getTransfers());
        }

    return result;
    }

    private SelectedTransfers helper(int maxWeight, List<Transfer> transfers){
        List<Transfer> transfersList = new ArrayList<>();
        int totalWeight = 0;
        int totalCost = 0;

        SelectedTransfers selectedTransfers = SelectedTransfers.builder()
                .totalCost(totalCost)
                .totalWeight(totalWeight)
                .transfers(transfersList)
                .build();

        int currentWeight;
        int currentCost;
        int [][] dp = new int[transfers.size()+1][maxWeight+1];

        for(int i = 1; i <= transfers.size(); i++) {
            for (int j = 0; j <= maxWeight; j++) {
                currentWeight = transfers.get(i - 1).getWeight();
                currentCost = transfers.get(i - 1).getCost();

                if (currentWeight <= j) {
                    int includeItem = 0;
                    if (j - currentWeight >= 0) {
                        includeItem = currentCost + dp[i - 1][j - currentWeight];
                    }
                    dp[i][j] = max(includeItem, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        selectedTransfers.setTotalCost(dp[transfers.size()][maxWeight]);
        int weightLimit = maxWeight;
        totalCost = 0;
        for (int i = transfers.size(); i >= 1; i--) {
            if (dp[i][weightLimit] != dp[i-1][weightLimit]) {
                Transfer currentTransfer = transfers.get(i - 1);
                selectedTransfers.getTransfers().add(currentTransfer);
                totalWeight += currentTransfer.getWeight();
                totalCost += currentTransfer.getCost();
                weightLimit -= currentTransfer.getWeight();
                selectedTransfers.getTransfers().remove(currentTransfer);
            }
        }

        selectedTransfers.setTotalWeight(totalWeight);
        selectedTransfers.setTotalCost(totalCost);

        return selectedTransfers;
    }
}