package com.newassessor.newassessor.service;

import com.newassessor.newassessor.model.NewAssessor;
import com.newassessor.newassessor.repository.DatabaseRepository;
import com.newassessor.newassessor.repository.HashMapRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AssessorServiceTest {

    @Mock
    private DatabaseRepository databaseRepository;

    @Mock
    private HashMapRepository hashMapRepository;

    @InjectMocks
    private AssessorService assessorService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveAssessor() {
        NewAssessor assessor = new NewAssessor();
        assessor.setName("John Doe");
        assessor.setNumber("123456789");

        // any is a mockito method- matches arguement to the specified types
        //this is just like saying, match any object type NewAssessor
        //basically to "save" data
        when(databaseRepository.save(any(NewAssessor.class))).thenReturn(assessor);
        when(hashMapRepository.save(any(NewAssessor.class))).thenReturn(assessor);

        NewAssessor savedAssessor = assessorService.saveAssessor(assessor);

        verify(databaseRepository, times(1)).save(any(NewAssessor.class));
        verify(hashMapRepository, times(1)).save(any(NewAssessor.class));

        assertEquals("John Doe", savedAssessor.getName());
        assertEquals("123456789", savedAssessor.getNumber());
    }

    @Test
    public void testGetAssessorById_FromHashMap() {
        //prepare mock
        long id = 1;
        NewAssessor assessorFromHashMap = new NewAssessor();
        assessorFromHashMap.setId(id);
        assessorFromHashMap.setName("John Doe");
        assessorFromHashMap.setNumber("123456789");

        //mock the behaviour of the hashMap using mockito
        when(hashMapRepository.findById(id)).thenReturn(assessorFromHashMap);
        //when(databaseRepository.findById(id)).thenReturn(Optional.empty());

        NewAssessor resultAssessor = assessorService.getAssessorById(id);

        verify(hashMapRepository, times(1)).findById(id);
        //verify(databaseRepository, times(0)).findById(id);

        assertEquals(assessorFromHashMap.getId(), resultAssessor.getId());
//        assertEquals("John Doe", resultAssessor.getName());
//        assertEquals("123456789", resultAssessor.getNumber());
        assertEquals(assessorFromHashMap.getName(), resultAssessor.getName());
        assertEquals(assessorFromHashMap.getNumber(), resultAssessor.getNumber());
    }

    @Test
    public void testGetAssessorById_FromDatabase() {
        long id = 2;
        NewAssessor assessorFromDatabase = new NewAssessor();
        assessorFromDatabase.setId(id);
        assessorFromDatabase.setName("Jane Smith");
        assessorFromDatabase.setNumber("987654321");

        //when(hashMapRepository.findById(id)).thenReturn(null);
        when(databaseRepository.findById(id)).thenReturn(Optional.of(assessorFromDatabase));

        NewAssessor resultAssessor = assessorService.getAssessorById(id);

        //verify(hashMapRepository, times(1)).findById(id);
        verify(databaseRepository, times(1)).findById(id);

        assertEquals(id, resultAssessor.getId());
        assertEquals("Jane Smith", resultAssessor.getName());
        assertEquals("987654321", resultAssessor.getNumber());
    }

    @Test
    public void testGetAllAssessors() {
        // Prepare mock data
        List<NewAssessor> mockAssessors = new ArrayList<>();
        mockAssessors.add(new NewAssessor());
        //mockAssessors.add(new NewAssessor());
        //mockAssessors.add(new NewAssessor());

        // Mock the behavior of HashMapRepository to return the mock data
        when(hashMapRepository.findAll()).thenReturn(mockAssessors);

        // Call the service method
        List<NewAssessor> resultAssessors = assessorService.getAllAssessors();

        // Verify that the repository method was called
        verify(hashMapRepository, times(1)).findAll();

        // Check the result
        assertEquals(mockAssessors.size(), resultAssessors.size());
        assertEquals(mockAssessors.get(0).getId(), resultAssessors.get(0).getId());
        assertEquals(mockAssessors.get(0).getName(), resultAssessors.get(0).getName());
        assertEquals(mockAssessors.get(0).getNumber(), resultAssessors.get(0).getNumber());

        // ... add more assertions for other properties if necessary
    }


    @Test
    public void testUpdateAssessor() {
        long id = 1;
        NewAssessor existingAssessor = new NewAssessor();
        existingAssessor.setId(id);
        existingAssessor.setName("John Doe");
        existingAssessor.setNumber("123456789");
        existingAssessor.setDateJoined(null);

        NewAssessor updatedAssessor = new NewAssessor();
        updatedAssessor.setId(id);
        updatedAssessor.setName("John Updated");
        updatedAssessor.setNumber("987654321");
        updatedAssessor.setDateJoined(null);

        when(databaseRepository.save(any(NewAssessor.class))).thenReturn(updatedAssessor);
        when(hashMapRepository.update(any(NewAssessor.class))).thenReturn(updatedAssessor);

        NewAssessor resultAssessor = assessorService.updateAssessor(id, updatedAssessor);

        verify(databaseRepository, times(1)).save(any(NewAssessor.class));
        verify(hashMapRepository, times(1)).update(any(NewAssessor.class));

        assertEquals(id, resultAssessor.getId());
        assertEquals("John Updated", resultAssessor.getName());
        assertEquals("987654321", resultAssessor.getNumber());
    }

    @Test
    public void testDeleteAssessor() {
        long id = 1;

        doNothing().when(databaseRepository).deleteById(id);
        doNothing().when(hashMapRepository).deleteById(id);

        assessorService.deleteAssessor(id);

        verify(databaseRepository, times(1)).deleteById(id);
        verify(hashMapRepository, times(1)).deleteById(id);
    }
}

