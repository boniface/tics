/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.test.repository.person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.annotations.Test;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.people.Demography;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.people.PersonIdentities;
import zm.hashcode.tics.domain.reports.Report;
import zm.hashcode.tics.domain.training.schedule.ScheduledCourse;
import zm.hashcode.tics.domain.ui.demographics.Gender;
import zm.hashcode.tics.domain.ui.demographics.IdentificationType;
import zm.hashcode.tics.domain.ui.demographics.Race;
import zm.hashcode.tics.domain.ui.demographics.Title;
import zm.hashcode.tics.domain.ui.location.Location;
import zm.hashcode.tics.repository.offices.FacilityRepository;
import zm.hashcode.tics.repository.people.PersonRepository;
import zm.hashcode.tics.repository.training.schedule.ScheduledCourseRepository;
import zm.hashcode.tics.repository.ui.demographics.GenderRepository;
import zm.hashcode.tics.repository.ui.demographics.IdentificationTypeRepository;
import zm.hashcode.tics.repository.ui.demographics.RaceRepository;
import zm.hashcode.tics.repository.ui.demographics.TitleRepository;
import zm.hashcode.tics.services.report.ReportService;
import zm.hashcode.tics.test.AppTest;
import static zm.hashcode.tics.test.AppTest.ctx;

/**
 *
 * @author boniface
 */
public class PersonTest extends AppTest {

    private PersonRepository personRepository;
    private IdentificationTypeRepository identificationTypeRepository;
    private TitleRepository titleRepository;
    private FacilityRepository facilityRepository;
    private RaceRepository raceRepository;
    private GenderRepository genderRepository;
    private ScheduledCourseRepository scheduledCourseRepository;
    private ReportService reportService;

//    @Test
    public void createRepository() {
        personRepository = ctx.getBean(PersonRepository.class);
        reportService = ctx.getBean(ReportService.class);
        identificationTypeRepository = ctx.getBean(IdentificationTypeRepository.class);
        titleRepository = ctx.getBean(TitleRepository.class);
        facilityRepository = ctx.getBean(FacilityRepository.class);
        genderRepository = ctx.getBean(GenderRepository.class);
        raceRepository = ctx.getBean(RaceRepository.class);
        scheduledCourseRepository = ctx.getBean(ScheduledCourseRepository.class);

        final IdentificationType identificationType = identificationTypeRepository.findOne("5215c0b1e4b0fcf6cfc46a3a");
        final Facility facility = facilityRepository.findOne("521d9192e4b0bb4796157f45");
        final Title title = titleRepository.findOne("5215c0bfe4b0fcf6cfc46a3b");
        final Gender gender = genderRepository.findOne("5215c788e4b0a5c89b58baa3");
        final Race race = raceRepository.findOne("5215c788e4b0a5c89b58baa3");
        final Demography demo = new Demography.Builder(gender).race(race).build();
        PersonIdentities personIdentities = new PersonIdentities.Builder(identificationType)
                .idValue("ZG04412")
                .build();
//
        final List<PersonIdentities> ids = new ArrayList<>();
        ids.add(personIdentities);

        final Person person = new Person.Builder("Chanda ", "Beu")
                .othername("Other")
                .title(title)
                .demography(demo)
                .identities(ids)
                .facility(facility)
                .build();

        personRepository.save(person);
        System.out.println("THE Person ID is " + person.getId());

    }

//    @Test
    public void countPeople() {
        personRepository = ctx.getBean(PersonRepository.class);
        scheduledCourseRepository = ctx.getBean(ScheduledCourseRepository.class);
        facilityRepository = ctx.getBean(FacilityRepository.class);
        reportService = ctx.getBean(ReportService.class);
//        List<Person> people = (List<Person>) personRepository.findAll();
//        List<Facility> facilitys = (List<Facility>) facilityRepository.findAll();
        List<ScheduledCourse> courses = (List<ScheduledCourse>) scheduledCourseRepository.findAll();

        courses.stream().parallel().filter((c) -> (c.getParticipants().size() > 0)).forEach((c) -> {
            Set<Person> people = c.getParticipants();
            people.remove(null);
            people.stream().parallel().filter((person) -> (person.getFacility()!=null)).map((person) -> new Report.Builder(c.getCourse().getName())
                    .facility(person.getFacility().getFacilityName())
                    .courseTopic(c.getCourse().getCourseTopic())
                    .city(getCity(person.getFacility().getCity()))
                    .substrict(getSubDistrict(person.getFacility().getCity()))
                    .district(getDistrict(person.getFacility().getCity()))
                    .endDate(c.getEndDate())
                    .startDate(c.getStartDate())
                    .firstName(person.getFirstname())
                    .lastName(person.getSurname())
                    .personId(person.getId())
                    .venue(c.getVenue()).build()).forEach((r) -> {
                        reportService.persist(r);
                    });
        });
    }
    
    @Test
    public void deleteReport(){
         reportService = ctx.getBean(ReportService.class);
         
         List<Report> reports = reportService.findAll();
         
         reports.stream().parallel().forEach((report) -> {
            reportService.remove(report);
        });
        
    }

    private String getCity(Location city) {
         if(city!=null)
             return city.getName();
         return "NO CITY NAME";
    }

    private String getSubDistrict(Location city) {
        if(city!=null)
             return getSubD(city.getParent());
         return "NO CITY";
        
    }

    private String getSubD(Location parent) {
        if(parent!=null)
             return parent.getName();
         return "NO SUB DISTRICT";
    }

    private String getDistrict(Location city) {
        if(city!=null)
             return getDistrictSub(city.getParent());
         return "NO CITY NAME";
       
    }

    private String getDistrictSub(Location parent) {
         if(parent!=null)
             return getDist(parent.getParent());
         return "NO SUB DISTRICT";
    }

    private String getDist(Location parent) {
        if(parent!=null)
             return parent.getName();
         return "DISTRICT";
    }

  

    
}
