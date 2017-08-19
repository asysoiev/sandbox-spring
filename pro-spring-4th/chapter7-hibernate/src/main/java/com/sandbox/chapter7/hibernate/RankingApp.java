package com.sandbox.chapter7.hibernate;

import com.sandbox.chapter7.hibernate.dao.ranking.PersonDao;
import com.sandbox.chapter7.hibernate.dao.ranking.SkillDao;
import com.sandbox.chapter7.hibernate.model.ranking.Person;
import com.sandbox.chapter7.hibernate.model.ranking.Ranking;
import com.sandbox.chapter7.hibernate.model.ranking.Skill;
import com.sandbox.chapter7.hibernate.service.PersonService;
import com.sandbox.chapter7.hibernate.service.RankingService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;
import java.util.Set;

/**
 * Created by andrii on 19.08.17.
 */
public class RankingApp {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("hibernate");
        ctx.load("classpath:META-INF/spring/app-config.xml");
        ctx.refresh();


        RankingService rankingService = ctx.getBean(RankingService.class);
        PersonService personService = ctx.getBean(PersonService.class);
        PersonDao personDao = ctx.getBean(PersonDao.class);
        SkillDao skillDao = ctx.getBean(SkillDao.class);

        //prepare data
        Person subject = personService.addPerson("Andrii", "Sysoiev");
        Person observer = personService.addPerson("Irina", "Kovalenko");
        Skill skillJava = skillDao.addSkill("Java");
        Skill skillHibernate = skillDao.addSkill("Hibernate");
        Skill skillSpring = skillDao.addSkill("Spring");
        Skill skillConcurrency = skillDao.addSkill("Concurrency");

        System.out.println("=======================");
        System.out.println("Create object");
        rankingService.addRanking(subject, observer, skillJava, 8);
        rankingService.addRanking(subject, observer, skillHibernate, 7);
        rankingService.addRanking(subject, observer, skillConcurrency, 6);
        rankingService.addRanking(subject, observer, skillSpring, 8);
        System.out.println("=======================");

        System.out.println("=======================");
        System.out.println("Retrieve data");
        int averageRanking = rankingService.getAverageRanking(subject.getName(), skillJava.getName());
        System.out.println("Average ranking: " + averageRanking);
        Ranking retrievedRanking = rankingService.findRankingBySubjectAndObserverAndSkill(subject.getName(), observer.getName(), skillJava.getName());
        System.out.println("Retrieved ranking: " + retrievedRanking);
        System.out.println("=======================");

        System.out.println("=======================");
        System.out.println("Update data");
        retrievedRanking.setRanking(9);
        rankingService.saveRanking(retrievedRanking);
        retrievedRanking = rankingService.findRankingBySubjectAndObserverAndSkill(subject.getName(), observer.getName(), skillJava.getName());
        System.out.println("Retrieve ranking: " + retrievedRanking);
        System.out.println("=======================");

        System.out.println("=======================");
        System.out.println("Delete data");
        rankingService.deleteRanking(retrievedRanking);
        averageRanking = rankingService.getAverageRanking(subject.getName(), skillJava.getName());
        System.out.println("Average ranking: " + averageRanking);
        System.out.println("=======================");

        System.out.println("=======================");
        System.out.println("Get average of all rankings");
        Map<String, Integer> allRankings = rankingService.findRankingsFor(subject.getName());
        for (Map.Entry<String, Integer> ranking : allRankings.entrySet()) {
            System.out.println("Ranking name" + ranking.getKey() + " average rank: " + ranking.getValue());
        }
        System.out.println("Get best person for skill");
        Person bestPersonForSpring = rankingService.findBestPersonFor(skillSpring.getName());
        System.out.println("Best person for Spring is " + bestPersonForSpring.getName());
        System.out.println("=======================");

        System.out.println("=======================");
        System.out.println("Locks");
        Person lockedPerson = personService.loadById(subject.getId());
        lockedPerson.setSurname("Updated");
        personService.savePerson(lockedPerson);
        System.out.println("=======================");

        System.out.println("=======================");
        System.out.println("Associations and lazy loading");
        Person andrii = personDao.findByName("Andrii");
        System.out.println("Person: " + andrii);
        Set<Ranking> ranks = andrii.getRanks();
        for (Ranking rank : ranks) {
            System.out.println("Rank: " + rank);
        }
        System.out.println("=======================");
    }

}
