/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.system.peoplemetadata;

import zm.hashcode.tics.client.web.Menu;
import com.vaadin.ui.VerticalLayout;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.tabs.GenderTab;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.tabs.IdentificationTypeTabTab;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.tabs.LanguageProficiencyTab;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.tabs.LanguageTab;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.tabs.MaritalStatusTab;
import zm.hashcode.tics.client.web.content.system.peoplemetadata.tabs.RaceTab;
import zm.hashcode.tics.client.web.content.users.tabs.ResetTab;

/**
 *
 * @author boniface
 */
public class PeopleMetaDataMenu extends Menu {

    public PeopleMetaDataMenu(TicsMain app, String selectedTab) {
        super(app, selectedTab);

        final VerticalLayout genderTab = new VerticalLayout();
        genderTab.setMargin(true);
        genderTab.addComponent(new GenderTab(getMain()));


        final VerticalLayout identificationTypeTab = new VerticalLayout();
        identificationTypeTab.setMargin(true);
        identificationTypeTab.addComponent(new IdentificationTypeTabTab(getMain()));

        final VerticalLayout languageProciencyTab = new VerticalLayout();
        languageProciencyTab.setMargin(true);
        languageProciencyTab.addComponent(new LanguageProficiencyTab(getMain()));

        final VerticalLayout languageTab = new VerticalLayout();
        languageTab.setMargin(true);
        languageTab.addComponent(new LanguageTab(getMain()));


        final VerticalLayout maritalStatusTab = new VerticalLayout();
        maritalStatusTab.setMargin(true);
        maritalStatusTab.addComponent(new MaritalStatusTab(getMain()));

        final VerticalLayout raceTab = new VerticalLayout();
        raceTab.setMargin(true);
        raceTab.addComponent(new RaceTab(getMain()));

        final VerticalLayout titleTab = new VerticalLayout();
        titleTab.setMargin(true);
        titleTab.addComponent(new ResetTab(getMain()));

        getTab().addTab(genderTab, "GENDER", null);
        getTab().addTab(identificationTypeTab, "Identification TYPE", null);
        getTab().addTab(languageProciencyTab, "Language  PROFICIENCY", null);

        getTab().addTab(languageTab, "LANGUAGE", null);
        getTab().addTab(maritalStatusTab, "Marital STATUS", null);
        getTab().addTab(raceTab, "RACE", null);

        getTab().addTab(titleTab, "TITLE", null);



        switch (selectedTab) {
            case "LANDING":
                getTab().setSelectedTab(genderTab);
                break;
            case "IDENTITY":
                getTab().setSelectedTab(identificationTypeTab);
                break;
            case "PROFICIENCY":
                getTab().setSelectedTab(languageProciencyTab);
                break;

            case "LANGUAGE":
                getTab().setSelectedTab(languageTab);
                break;
            case "MARITAL":
                getTab().setSelectedTab(maritalStatusTab);
                break;
            case "RACE":
                getTab().setSelectedTab(raceTab);
                break;
            case "TITLE":
                getTab().setSelectedTab(titleTab);
                break;
        }
        addComponent(getTab());

    }
}
