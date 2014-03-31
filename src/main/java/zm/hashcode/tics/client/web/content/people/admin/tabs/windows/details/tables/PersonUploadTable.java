/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.client.web.content.people.admin.tabs.windows.details.tables;

import com.vaadin.server.FileDownloader;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Reindeer;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import zm.hashcode.tics.app.facade.documents.FileStorageFacade;
import zm.hashcode.tics.app.facade.people.PersonFacade;
import zm.hashcode.tics.app.util.files.PersonFilesgeUtil;
import zm.hashcode.tics.client.web.TicsMain;
import zm.hashcode.tics.domain.people.Person;
import zm.hashcode.tics.services.documents.FileStorageService;

/**
 *
 * @author boniface
 */
public class PersonUploadTable extends Table {


    private final Person person;
    private FileStorageService storageService = FileStorageFacade.getFileStorageService();
   

    public PersonUploadTable(final TicsMain main, final Person person, final VerticalLayout content) {
      
        this.person = person;

        addContainerProperty("File Name", String.class, null);
        addContainerProperty("Download", Button.class, null);
        addContainerProperty("Delete", Button.class, null);

        List<String>  personFiles = person.getFiles();
        
            for (final String fileId : personFiles) {
                final Button download = new Button("Download");
                download.setStyleName(Reindeer.BUTTON_LINK);
                download.setData(fileId);

                download.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        PersonFilesgeUtil personFilesgeUtil = new PersonFilesgeUtil(fileId);
                        StreamResource.StreamSource imageSource = personFilesgeUtil;
                        StreamResource resource = new StreamResource(imageSource, personFilesgeUtil.getFileName());
                        FileDownloader fileDownloader = new FileDownloader(resource);
                        fileDownloader.extend(download);
                    }
                });
                Button delete = new Button("Delete");
                delete.setStyleName(Reindeer.BUTTON_LINK);
                delete.setData(fileId);
                delete.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent event) {
                        deleteFile((String) event.getButton().getData());
                        removeItem((String) event.getButton().getData());
                    }
                });

                addItem(new Object[]{storageService.getById(fileId).getFilename(), download, delete,}, fileId);
            }
        

        setNullSelectionAllowed(false);
        setSelectable(true);
        // Send changes in selection immediately to server.
        setImmediate(true);
    }
    
    public void addDataToButtons(){
        
    }

    public void loadTable(InputStream in, String fileName, String mimeType) {
//        String uploadDate = dateTimeFormatHelper.getDayMonthYear(new Date());
//        String fileId = storageService.save(in, mimeType, fileName);
//        Set<String> files = updateEmpDetails(fileId);
//        for (String filesId : files) {
//
//            Button download = new Button("Download");
//            download.setStyleName(Reindeer.BUTTON_LINK);
//            download.setData(filesId);
//
//            PersonFilesgeUtil personFilesgeUtil = new PersonFilesgeUtil(fileId);
//            StreamResource.StreamSource imageSource = personFilesgeUtil;
//            StreamResource resource = new StreamResource(imageSource, personFilesgeUtil.getFileName());
//            FileDownloader fileDownloader = new FileDownloader(resource);
//            fileDownloader.extend(download);
//
//
//            Button delete = new Button("Delete");
//            delete.setStyleName(Reindeer.BUTTON_LINK);
//            delete.setData(filesId);
//            delete.addClickListener(new Button.ClickListener() {
//                @Override
//                public void buttonClick(Button.ClickEvent event) {
//                    deleteFile((String) event.getButton().getData());
//                    removeItem((String) event.getButton().getData());
//                }
//            });
//
//            addItem(new Object[]{storageService.getById(filesId).getFilename(), download, delete,}, filesId);
//        }
//        // Allow selecting items from the table.
//        setNullSelectionAllowed(false);
//        setSelectable(true);
//        //Send changes in selection immediately to server.
//        setImmediate(true);
    }

    public void deleteFile(String filename) {
        List<String> personFiles = person.getFiles();
        Set<String> files = new HashSet<>();
        files.addAll(personFiles);
        files.remove(filename);

     
        
    }



   



}
