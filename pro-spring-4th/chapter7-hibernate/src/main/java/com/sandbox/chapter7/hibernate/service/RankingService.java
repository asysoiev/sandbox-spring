package com.sandbox.chapter7.hibernate.service;

import com.sandbox.chapter7.hibernate.model.ranking.Person;
import com.sandbox.chapter7.hibernate.model.ranking.Ranking;
import com.sandbox.chapter7.hibernate.model.ranking.Skill;

import java.util.Map;

/**
 * Created by andrii on 19.08.17.
 */
public interface RankingService {

    int getAverageRanking(String subject, String skill);

    void addRanking(Person subject, Person observer, Skill skill, int rank);

    Ranking findRankingBySubjectAndObserverAndSkill(String subject,
                                                    String observer, String skill);

    void saveRanking(Ranking value);

    void deleteRanking(Ranking value);

    Map<String, Integer> findRankingsFor(String subject);

    Person findBestPersonFor(String skill);
}
