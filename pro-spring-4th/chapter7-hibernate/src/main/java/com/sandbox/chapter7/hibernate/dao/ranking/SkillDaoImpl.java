package com.sandbox.chapter7.hibernate.dao.ranking;

import com.sandbox.chapter7.hibernate.model.ranking.Skill;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by andrii on 19.08.17.
 */
@Transactional
@Repository
public class SkillDaoImpl implements SkillDao {

    @Resource
    private SessionFactory sessionFactory;

    @Override
    public Skill addSkill(String skillName) {
        Skill skill = new Skill(skillName);
        sessionFactory.getCurrentSession().saveOrUpdate(skill);
        return skill;
    }
}
