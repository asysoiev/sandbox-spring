package com.sandbox.chapter7.hibernate.service;

import com.sandbox.chapter7.hibernate.dao.ranking.PersonDao;
import com.sandbox.chapter7.hibernate.dao.ranking.RankingDao;
import com.sandbox.chapter7.hibernate.model.ranking.Person;
import com.sandbox.chapter7.hibernate.model.ranking.Ranking;
import com.sandbox.chapter7.hibernate.model.ranking.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrii on 19.08.17.
 */
@Service
public class RankingServiceImpl implements RankingService {

    @Autowired
    private PersonDao personDao;
    @Autowired
    private RankingDao rankingDao;

    @Override
    public int getAverageRanking(String subject, String skill) {
        int summ = 0;
        List<Ranking> rankings = rankingDao.getRankingBySubjectAndSkill(subject, skill);
        for (Ranking ranking : rankings) {
            summ += ranking.getRanking();
        }
        return summ == 0 ? 0 : summ / rankings.size();
    }

    @Override
    public void addRanking(Person subject, Person observer, Skill skill, int rank) {
        Ranking ranking = new Ranking();
        ranking.setSubject(subject);
        ranking.setObserver(observer);
        ranking.setSkill(skill);
        ranking.setRanking(rank);
        rankingDao.saveRanking(ranking);
    }

    @Override
    public Ranking findRankingBySubjectAndObserverAndSkill(String subject,
                                                           String observer, String skill) {
        return rankingDao.findBySubjectAndObserverAndSkill(subject, observer, skill);
    }

    @Override
    public void saveRanking(Ranking value) {
        rankingDao.saveRanking(value);
    }

    @Override
    public void deleteRanking(Ranking value) {
        rankingDao.delete(value);
    }

    @Override
    public Map<String, Integer> findRankingsFor(String subject) {
        Map<String, Integer> results = new HashMap<>();
        List<Ranking> rankings = rankingDao.getRankingsBySubject(subject);
        String lastSkillName = "";
        int sum = 0;
        int count = 0;
        for (Ranking r : rankings) {
            if (!lastSkillName.equals(r.getSkill().getName())) {
                sum = 0;
                count = 0;
                lastSkillName = r.getSkill().getName();
            }
            sum += r.getRanking();
            count++;
            results.put(lastSkillName, sum / count);
        }
        return results;
    }

    @Override
    public Person findBestPersonFor(String skill) {
        List<Object[]> result = rankingDao.findBestPersonFor(skill);
        if (result.size() > 0) {
            return personDao.findByName((String) result.get(0)[0]);
        }
        return null;
    }
}
