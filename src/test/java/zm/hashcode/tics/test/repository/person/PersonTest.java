/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.test.repository.person;

import java.util.ArrayList;
import java.util.List;
import zm.hashcode.tics.domain.offices.Facility;
import zm.hashcode.tics.domain.people.Demography;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.domain.people.PersonIdentities;
import zm.hashcode.tics.domain.ui.demographics.Gender;
import zm.hashcode.tics.domain.ui.demographics.IdentificationType;
import zm.hashcode.tics.domain.ui.demographics.Race;
import zm.hashcode.tics.domain.ui.demographics.Title;
import zm.hashcode.tics.repository.offices.FacilityRepository;
import zm.hashcode.tics.repository.people.PersonRepository;
import zm.hashcode.tics.repository.ui.demographics.GenderRepository;
import zm.hashcode.tics.repository.ui.demographics.IdentificationTypeRepository;
import zm.hashcode.tics.repository.ui.demographics.RaceRepository;
import zm.hashcode.tics.repository.ui.demographics.TitleRepository;
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

//    @Test
    public void createRepository() {
        personRepository = ctx.getBean(PersonRepository.class);
        identificationTypeRepository = ctx.getBean(IdentificationTypeRepository.class);
        titleRepository = ctx.getBean(TitleRepository.class);
        facilityRepository = ctx.getBean(FacilityRepository.class);
        genderRepository = ctx.getBean(GenderRepository.class);
        raceRepository = ctx.getBean(RaceRepository.class);

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
}
