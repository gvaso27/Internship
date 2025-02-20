//package com.example.transfers.service;
//
//import com.example.transfers.service.model.SelectedTransfers;
//import com.example.transfers.service.model.Transfer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//class ServiceClassImplTest {
//
//    @InjectMocks
//    private ServiceClassImpl service;
//
//    @Test
//    void testOptimalSolution_BasicCase() {
//        // Given
//        List<Transfer> transfers = Arrays.asList(
//                Transfer.builder().weight(2).cost(3).build(),
//                Transfer.builder().weight(3).cost(4).build()
//        );
//        int maxWeight = 5;
//
//        // When
//        SelectedTransfers result = service.optimalSolution(maxWeight, transfers);
//
//        // Then
//        assertNotNull(result);
//        assertEquals(7, result.getTotalCost());
//        assertEquals(5, result.getTotalWeight());
//        assertEquals(2, result.getTransfers().size());
//    }
//
//    @Test
//    void testOptimalSolution_EmptyList() {
//        // Given
//        List<Transfer> transfers = Collections.emptyList();
//        int maxWeight = 10;
//
//        // When
//        SelectedTransfers result = service.optimalSolution(maxWeight, transfers);
//
//        // Then
//        assertNotNull(result);
//        assertEquals(0, result.getTotalCost());
//        assertEquals(0, result.getTotalWeight());
//        assertTrue(result.getTransfers().isEmpty());
//    }
//
//    @Test
//    void testOptimalSolution_SingleTransfer() {
//        // Given
//        List<Transfer> transfers = Collections.singletonList(
//                Transfer.builder().weight(3).cost(4).build()
//        );
//        int maxWeight = 5;
//
//        // When
//        SelectedTransfers result = service.optimalSolution(maxWeight, transfers);
//
//        // Then
//        assertNotNull(result);
//        assertEquals(4, result.getTotalCost());
//        assertEquals(3, result.getTotalWeight());
//        assertEquals(1, result.getTransfers().size());
//    }
//
//    @Test
//    void testOptimalSolution_AllItemsTooBig() {
//        // Given
//        List<Transfer> transfers = Arrays.asList(
//                Transfer.builder().weight(6).cost(10).build(),
//                Transfer.builder().weight(7).cost(12).build()
//        );
//        int maxWeight = 5;
//
//        // When
//        SelectedTransfers result = service.optimalSolution(maxWeight, transfers);
//
//        // Then
//        assertNotNull(result);
//        assertEquals(0, result.getTotalCost());
//        assertEquals(0, result.getTotalWeight());
//        assertTrue(result.getTransfers().isEmpty());
//    }
//
//    @Test
//    void testOptimalSolution_ComplexCase() {
//        // Given
//        List<Transfer> transfers = Arrays.asList(
//                Transfer.builder().weight(2).cost(3).build(),
//                Transfer.builder().weight(3).cost(4).build(),
//                Transfer.builder().weight(4).cost(5).build(),
//                Transfer.builder().weight(5).cost(6).build()
//        );
//        int maxWeight = 10;
//
//        // When
//        SelectedTransfers result = service.optimalSolution(maxWeight, transfers);
//
//        // Then
//        assertNotNull(result);
//
//        assertEquals(3, result.getTransfers().size());
//        assertEquals(10, result.getTotalWeight());
//        assertEquals(13, result.getTotalCost());
//
//    }
//
//    @Test
//    void testOptimalSolution_ZeroMaxWeight() {
//        // Given
//        List<Transfer> transfers = Arrays.asList(
//                Transfer.builder().weight(2).cost(3).build(),
//                Transfer.builder().weight(3).cost(4).build()
//        );
//        int maxWeight = 0;
//
//        // When
//        SelectedTransfers result = service.optimalSolution(maxWeight, transfers);
//
//        // Then
//        assertNotNull(result);
//        assertEquals(0, result.getTotalCost());
//        assertEquals(0, result.getTotalWeight());
//        assertTrue(result.getTransfers().isEmpty());
//    }
//
//    @Test
//    void testOptimalSolution_EqualWeightDifferentCosts() {
//        // Given
//        List<Transfer> transfers = Arrays.asList(
//                Transfer.builder().weight(3).cost(4).build(),
//                Transfer.builder().weight(3).cost(5).build(),
//                Transfer.builder().weight(3).cost(6).build()
//        );
//        int maxWeight = 6;
//
//        // When
//        SelectedTransfers result = service.optimalSolution(maxWeight, transfers);
//
//        // Then
//        assertNotNull(result);
//
//
//        assertEquals(2, result.getTransfers().size());
//        assertEquals(11, result.getTotalCost());
//        assertEquals(6, result.getTotalWeight());
//    }
//
//    @Test
//    void testOptimalSolution_ExactWeightMatch() {
//        // Given
//        List<Transfer> transfers = Arrays.asList(
//                Transfer.builder().weight(2).cost(3).build(),
//                Transfer.builder().weight(3).cost(4).build(),
//                Transfer.builder().weight(5).cost(6).build()
//        );
//        int maxWeight = 5;
//
//        // When
//        SelectedTransfers result = service.optimalSolution(maxWeight, transfers);
//
//        // Then
//        assertNotNull(result);
//        assertEquals(7, result.getTotalCost());
//        assertEquals(5, result.getTotalWeight());
//        assertEquals(2, result.getTransfers().size());
//    }
//}