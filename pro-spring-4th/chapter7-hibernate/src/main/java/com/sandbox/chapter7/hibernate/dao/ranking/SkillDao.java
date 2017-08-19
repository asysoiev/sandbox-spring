package com.sandbox.chapter7.hibernate.dao.ranking;

import com.sandbox.chapter7.hibernate.model.ranking.Skill;

/**
 * Created by andrii on 19.08.17.
 */
public interface SkillDao {

    Skill addSkill(String skillName);

}
