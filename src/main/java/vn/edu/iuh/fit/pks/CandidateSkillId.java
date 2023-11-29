package vn.edu.iuh.fit.pks;

import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.entities.Skill;

import java.util.Objects;

public class CandidateSkillId {
    private Candidate candidate;
    private Skill skill;

    public CandidateSkillId() {
    }

    public CandidateSkillId(Candidate candidate, Skill skill) {
        this.candidate = candidate;
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandidateSkillId that)) return false;
        return Objects.equals(candidate, that.candidate) && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate, skill);
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
