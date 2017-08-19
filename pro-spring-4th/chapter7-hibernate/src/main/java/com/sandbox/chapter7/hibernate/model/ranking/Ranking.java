package com.sandbox.chapter7.hibernate.model.ranking;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by andrii on 18.08.17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Ranking.findAll",
                query = "select r " +
                        "from Ranking r "),
        @NamedQuery(name = "Ranking.findBySubjectAndObserverAndSkill",
                query = "select r " +
                        "from Ranking r " +
                        "where " +
                        "r.subject.name=:subject and " +
                        "r.observer.name=:observer and " +
                        "r.skill.name=:skill"),
        @NamedQuery(name = "Ranking.findBySubjectAndSkill",
                query = "select r " +
                        "from Ranking r " +
                        "where " +
                        "r.subject.name=:subject and " +
                        "r.skill.name=:skill"),
        @NamedQuery(name = "Ranking.findBySubject",
                query = "select r " +
                        "from Ranking r " +
                        "where " +
                        "r.subject.name=:subject"),
})
public class Ranking implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "SUBJECT_ID")
    private Person subject;
    @Id
    @OneToOne
    @JoinColumn(name = "OBSERVER_ID")
    private Person observer;
    @Id
    @OneToOne
    @JoinColumn(name = "SKILL")
    private Skill skill;
    @Column(name = "RANK")
    private Integer ranking;

    public Ranking() {
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

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                ", subject=" + subject +
                ", observer=" + observer +
                ", skill=" + skill +
                ", ranking=" + ranking +
                '}';
    }
}
