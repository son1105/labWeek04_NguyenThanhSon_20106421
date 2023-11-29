package vn.edu.iuh.fit.pks;

import vn.edu.iuh.fit.entities.Job;
import vn.edu.iuh.fit.entities.Skill;

import java.util.Objects;

public class JobSkillId {
    private Job job;
    private Skill skill;

    public JobSkillId() {
    }

    public JobSkillId(Job job, Skill skill) {
        this.job = job;
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobSkillId that)) return false;
        return Objects.equals(getJob(), that.getJob()) && Objects.equals(getSkill(), that.getSkill());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJob(), getSkill());
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
