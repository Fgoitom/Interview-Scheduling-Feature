package service;

import model.InterviewsInfo;

public interface InterviewsInfoService {

    public abstract InterviewsInfo getInterviewAvailability(int interviewee_id);
    public abstract InterviewsInfo  updateInterviewInfo(InterviewsInfo updateInterviewInfo, int interviewee_id);
    public abstract void deleteInterviewInfo();

}
