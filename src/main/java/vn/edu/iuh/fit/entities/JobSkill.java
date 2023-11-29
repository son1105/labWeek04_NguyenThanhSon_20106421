package vn.edu.iuh.fit.entities;

public class JobSkill {
    private Job job;
    private Skill skill;
    private int level;

    public JobSkill() {
    }

    public JobSkill(Job job, Skill skill, int level) {
        this.job = job;
        this.skill = skill;
        this.level = level;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "JobSkill{" +
                "job=" + job +
                ",\n\tskill=" + skill +
                ",\n\tlevel=" + level +
                '}';
    }
}
