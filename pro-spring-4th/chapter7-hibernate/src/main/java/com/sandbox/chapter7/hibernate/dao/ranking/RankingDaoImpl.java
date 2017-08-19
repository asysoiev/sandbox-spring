package com.sandbox.chapter7.hibernate.dao.ranking;

import com.sandbox.chapter7.hibernate.model.ranking.Ranking;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by andrii on 19.08.17.
 */
@Transactional
@Repository
public class RankingDaoImpl implements RankingDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List<Ranking> getRankingBySubjectAndSkill(String subject, String skill) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Ranking r "
                + "where r.subject.name=:name "
                + "and r.skill.name=:skill");
        query.setParameter("name", subject);
        query.setParameter("skill", skill);
        return query.getResultList();
    }

    @Override
    public void saveRanking(Ranking ranking) {
        sessionFactory.getCurrentSession().saveOrUpdate(ranking);
    }

    @Transactional(readOnly = true)
    @Override
    public Ranking findRankingBySubjectAndObserverAndSkill(String subject,
                                                           String observer, String skill) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Ranking r where "
                + "r.subject.name=:subject and "
                + "r.observer.name=:observer and "
                + "r.skill.name=:skill");
        query.setParameter("subject", subject);
        query.setParameter("observer", observer);
        query.setParameter("skill", skill);
        Ranking ranking = (Ranking) query.getSingleResult();
        return ranking;
    }

    @Override
    public void delete(Ranking value) {
        sessionFactory.getCurrentSession().delete(value);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Ranking> getRankingsBySubject(String subject) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Ranking r where "
                + "r.subject.name=:subject order by r.skill.name");
        query.setParameter("subject", subject);
        return query.getResultList();
    }

    @Override
    public List<Object[]> findBestPersonFor(String skill) {
        Query query = sessionFactory.getCurrentSession().createQuery("select r.subject.name, avg(r.ranking) as average"
                + " from Ranking r where "
                + "r.skill.name=:skill "
                + "group by r.subject.name "
                + "order by average desc");
        query.setParameter("skill", skill);
        List<Object[]> result = query.getResultList();
        return result;
    }
}
