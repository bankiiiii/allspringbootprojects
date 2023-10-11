//package com.assessor.assessor.service;
//
//import com.assessor.assessor.model.Assessor;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.Collection;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class AssessorService {
//
//    private static Map<String, Assessor> assessorRepo = new HashMap<>();
//
//
//
//
//
//
//
//    static {
//        Assessor walk = new Assessor();
//        walk.setId("1");
//        walk.setName("taofeek");
//        walk.setNumber("08023456776");
//        walk.setDateJoined(LocalDate.now());
//
//
//
//        assessorRepo.put(walk.getId(), walk);
//
//
//
//
//        Assessor talk = new Assessor();
//        talk.setId("2");
//        talk.setName("banki");
//        talk.setNumber("09028345453");
//        talk.setDateJoined(LocalDate.now());
//
//
//        assessorRepo.put(talk.getId(), talk);
//
//
//
//
//
//    }
//
//
//    public void createAssessor(Assessor assessor) throws RuntimeException {
//        if((assessorRepo.containsKey(assessor.getId()) )){
//            throw new RuntimeException("Customer Id Exist");
//        }
//        for (Assessor ass: assessorRepo.values()) {
//            if (ass.getNumber().equals(assessor.getNumber())){
//                throw new RuntimeException("Customer Number already exist");
//            }
//        }
//        assessor.setDateJoined(LocalDate.now());
//        assessorRepo.put(assessor.getId(), assessor);
//    }
//
//
//    public void deleteAssessor(String id) {
//        if (assessorRepo.containsKey(id)) {
//            assessorRepo.remove(id);
//        }
//    }
//
//    public void updateAssessor(String id, Assessor assessor) {
//        if (assessorRepo.containsKey(id)) {
//            assessorRepo.replace(id,assessor);
//        }
//    }
//
//    public Assessor getAssessor(String id) {
//        return assessorRepo.get(id);
//    }
//
//    public Collection<Assessor> getAssessors() {
//        return assessorRepo.values();
//    }
//
//
//}
