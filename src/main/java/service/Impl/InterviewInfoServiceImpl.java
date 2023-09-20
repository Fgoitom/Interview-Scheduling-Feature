package service.Impl;

import model.Interviewer;
import model.InterviewsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import repository.InterviewInfoRepo;
import repository.InterviewerRepo;
import service.InterviewsInfoService;

public class InterviewInfoServiceImpl implements InterviewsInfoService {

    @Autowired
    InterviewerRepo interviewerRepo;
    @Autowired
    InterviewInfoRepo interviewInfoRepo;
    @Override
    public InterviewsInfo getInterviewAvailability(int interviewee_id) {
        return null;
        //interviewInfoRepo.findById(interviewee_id).getInterviewsInfo().getStatus()
    }

    @Override
    public InterviewsInfo updateInterviewInfo(InterviewsInfo updateInterviewInfo, int interviewee_id) {
        return null;
    }

    @Override
    public void deleteInterviewInfo() {

    }
//    @Override
//    public Student getStudentById(Long studentId) {
//        return studentRepository.findById(studentId).orElse(null);
//    }
//
//    @Override
//    public Student updateStudent(Student updatedStudent, Long studentId) {
//        return studentRepository.findById(studentId)
//                .map(student -> {
//                    student.setStudentNumber(updatedStudent.getStudentNumber());
//                    student.setFirstName(updatedStudent.getFirstName());
//                    student.setMiddleName(updatedStudent.getMiddleName());
//                    student.setLastName(updatedStudent.getLastName());
//                    student.setCgpa(updatedStudent.getCgpa());
//                    return studentRepository.save(student);
//                })
//                .orElseGet(() -> studentRepository.save(updatedStudent));
//    }
//
//    @Override
//    public void deleteStudentById(Long studentId) {
//        studentRepository.deleteById(studentId);
//
//
}
