package com.sandbox.chapter7.hibernate.model.ranking;

import java.io.Serializable;

/**
 * Created by andrii on 20.08.17.
 */
public class RankingId implements Serializable {

    private Person subject;
    private Person observer;
    private Skill skill;

    protected RankingId() {
    }

    public RankingId(Person subject, Person observer, Skill skill) {
        this.subject = subject;
        this.observer = observer;
        this.skill = skill;
    }

    public Person getSubject() {
        return subject;
    }

    public void setSubject(Person subject) {
        this.subject = subject;
    }

    public Person getObserver() {
        return observer;
    }

    public void setObserver(Person observer) {
        this.observer = observer;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RankingId rankingId = (RankingId) o;

        if (subject != null ? !subject.equals(rankingId.subject) : rankingId.subject != null) return false;
        if (observer != null ? !observer.equals(rankingId.observer) : rankingId.observer != null) return false;
        return skill != null ? skill.equals(rankingId.skill) : rankingId.skill == null;
    }

    @Override
    public int hashCode() {
        int result = subject != null ? subject.hashCode() : 0;
        result = 31 * result + (observer != null ? observer.hashCode() : 0);
        result = 31 * result + (skill != null ? skill.hashCode() : 0);
        return result;
    }
}
