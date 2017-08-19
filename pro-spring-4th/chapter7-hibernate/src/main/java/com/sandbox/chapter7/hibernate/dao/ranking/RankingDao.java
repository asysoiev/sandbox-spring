package com.sandbox.chapter7.hibernate.dao.ranking;

import com.sandbox.chapter7.hibernate.model.ranking.Ranking;

import java.util.List;

/**
 * Created by andrii on 19.08.17.
 */
public interface RankingDao {
    List<Ranking> getRankingBySubjectAndSkill(String subject, String skill);

    void saveRanking(Ranking ranking);

    Ranking findBySubjectAndObserverAndSkill(String subject,
                                             String observer, String skill);

    void delete(Ranking value);

    List<Ranking> getRankingsBySubject(String subject);

    List<Object[]> findBestPersonFor(String skill);
}
