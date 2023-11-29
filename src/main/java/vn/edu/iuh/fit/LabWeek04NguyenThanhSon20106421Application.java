package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.entities.CandidateSkill;
import vn.edu.iuh.fit.entities.Skill;
import vn.edu.iuh.fit.pks.CandidateSkillId;
import vn.edu.iuh.fit.repositories.CandidateRepository;
import vn.edu.iuh.fit.repositories.CandidateSkillRepository;
import vn.edu.iuh.fit.repositories.SkillRepository;

@SpringBootApplication(scanBasePackages = {"vn.edu.iuh.fit.repositories", "vn.edu.iuh.fit.entities"})
public class LabWeek04NguyenThanhSon20106421Application {

    public static void main(String[] args) {
        SpringApplication.run(LabWeek04NguyenThanhSon20106421Application.class, args);
    }

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private CandidateSkillRepository candidateSkillRepository;

    @Bean
    CommandLineRunner runner() {
        return args -> {
            System.out.println("====================================");
            System.out.println("Candidate");
            System.out.println("Get All Candidate");
            candidateRepository.getAll().forEach(System.out::println);
            System.out.println("====================================");
            System.out.println("Get One Candidate With CandidateId = 2");
            System.out.println(candidateRepository.findOne(2));
            System.out.println("====================================");
            System.out.println("Insert A New Candidate");
            System.out.println("Insert Result: " + candidateRepository.insert(
                    new Candidate(3,"Nguyen Tan Phong", "phong@gmail.com",
                            "098898652", "115 DHT")));
            System.out.println("====================================");
            System.out.println("Get All Candidate");
            candidateRepository.getAll().forEach(System.out::println);
            System.out.println("====================================");
            System.out.println("Update A Candidate");
            Candidate candidate = candidateRepository.findOne(3);
            candidate.setFullName("Le Thanh Toan");
            candidate.setAddress("12 Nguyen Van Bao");
            System.out.println("Update Result: " + candidateRepository.update(candidate));
            System.out.println("Get All Candidate");
            candidateRepository.getAll().forEach(System.out::println);
            System.out.println("====================================");
            System.out.println("Delete Candidate With CandidateId = 3");
            System.out.println(candidateRepository.delete(3));
            System.out.println("====================================");
            System.out.println("Get All Candidate");
            candidateRepository.getAll().forEach(System.out::println);
            System.out.println("====================================");
            System.out.println("====================================");
            System.out.println("====================================");

            System.out.println("Skill");
            System.out.println("Get All Skill");
            skillRepository.getAll().forEach(System.out::println);
            System.out.println("====================================");
            System.out.println("Get One Skill With SkillId = 2");
            System.out.println(skillRepository.findOne(2));
            System.out.println("====================================");
            System.out.println("Insert A New Skill");
            System.out.println("Insert Result: " + skillRepository.insert(new Skill(4,"Skill")));
            System.out.println("====================================");
            System.out.println("Get All Skill");
            skillRepository.getAll().forEach(System.out::println);
            System.out.println("====================================");
            System.out.println("Update A Skill");
            Skill skill = skillRepository.findOne(4);
            skill.setSkillName("Skill Update");
            System.out.println("Update Result: " + skillRepository.update(skill));
            System.out.println("Get All Skill");
            skillRepository.getAll().forEach(System.out::println);
            System.out.println("====================================");
            System.out.println("Delete Skill With SkillId = 4");
            System.out.println(skillRepository.delete(4));
            System.out.println("====================================");
            System.out.println("Get All Skill");
            skillRepository.getAll().forEach(System.out::println);
            System.out.println("====================================");
            System.out.println("====================================");
            System.out.println("====================================");

            System.out.println("CandidateSkill");
            System.out.println("Get All CandidateSkill");
            candidateSkillRepository.getAll().forEach(System.out::println);
            System.out.println("====================================");
            System.out.println("Get One CandidateSkill With CandidateId = 1 && SkillId=1");
            System.out.println(candidateSkillRepository.findOne(new CandidateSkillId(candidateRepository.findOne(1), skillRepository.findOne(1))));
            System.out.println("====================================");
            System.out.println("Insert A New CandidateSkill");
            System.out.println("Insert Result: " + candidateSkillRepository.insert(
                    new CandidateSkill(candidateRepository.findOne(1), skillRepository.findOne(3), 2)));
            System.out.println("====================================");
            System.out.println("Get All CandidateSkill");
            candidateSkillRepository.getAll().forEach(System.out::println);
            System.out.println("====================================");
            System.out.println("Update A CandidateSkill");
            CandidateSkill candidateSkill = candidateSkillRepository.findOne(
                    new CandidateSkillId(candidateRepository.findOne(1),
                    skillRepository.findOne(3)));
            candidateSkill.setLevel(4);
            System.out.println("Update Result: " + candidateSkillRepository.update(candidateSkill));
            System.out.println("Get All CandidateSkill");
            candidateSkillRepository.getAll().forEach(System.out::println);
            System.out.println("====================================");
            System.out.println("Delete CandidateSkill With CandidateSkill = 1 && SkillId=3");
            System.out.println(candidateSkillRepository.delete(
                    new CandidateSkillId(candidateRepository.findOne(1),
                    skillRepository.findOne(3))));
            System.out.println("====================================");
            System.out.println("Get All CandidateSkill");
            candidateSkillRepository.getAll().forEach(System.out::println);
        };
    }

}
