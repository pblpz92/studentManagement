package com.example.demo.service;

import com.example.demo.model.Mentor;
import com.example.demo.repository.MentorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorService {

    private final MentorRepository mentorRepository;

    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }

    public Mentor getMentorById(Long id) {
        return mentorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mentor not found with id: " + id));
    }

    public Mentor saveMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    public Mentor updateMentor(Long id, Mentor mentorDetails) {
        Mentor mentor = getMentorById(id);
        mentor.setName(mentorDetails.getName());
        mentor.setSurnames(mentorDetails.getSurnames());
        mentor.setPhoneNumber(mentorDetails.getPhoneNumber());
        mentor.setEmail(mentorDetails.getEmail());
        mentor.setCompany(mentorDetails.getCompany());
        return mentorRepository.save(mentor);
    }

    public void deleteMentor(Long id) {
        mentorRepository.deleteById(id);
    }
}
