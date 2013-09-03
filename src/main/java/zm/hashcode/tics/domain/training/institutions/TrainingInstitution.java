/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.tics.domain.training.institutions;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import zm.hashcode.tics.domain.users.User;

/**
 *
 * @author boniface
 */
@Document
public final class TrainingInstitution implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;
    List<InstitutionAddress> institutionAddresses = new ArrayList<>();
    @DBRef
    private List<User> users = new ArrayList<>();
    @DBRef
    private List<TrainingInstructors> trainingInstructors = new ArrayList<>();

    private TrainingInstitution() {
    }

    private TrainingInstitution(Builder builder) {
        id = builder.id;
        name = builder.name;
        institutionAddresses = builder.institutionAddresses;
        users = builder.users;
        trainingInstructors = builder.trainingInstructors;

    }

    public static class Builder {

        private String id;
        private final String name;
        private List<InstitutionAddress> institutionAddresses = new ArrayList<>();
        private List<User> users = new ArrayList<>();
        private List<TrainingInstructors> trainingInstructors = new ArrayList<>();

        public Builder(String val) {
            this.name = val;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Builder institutionAddresses(List<InstitutionAddress> value) {
            institutionAddresses = value;
            return this;
        }

        public Builder users(List<User> value) {
            users = value;
            return this;
        }

        public Builder trainingInstructors(List<TrainingInstructors> value) {
            trainingInstructors = value;
            return this;
        }

        public TrainingInstitution build() {
            return new TrainingInstitution(this);
        }

        public Builder trainingInstitution(TrainingInstitution trainingInstitution) {
            id = trainingInstitution.getId();
            institutionAddresses = trainingInstitution.getInstitutionAddresses();
            users = trainingInstitution.getUsers();
            trainingInstructors = trainingInstitution.getTrainingInstructors();
            return this;
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<InstitutionAddress> getInstitutionAddresses() {
        return institutionAddresses;
    }

    public List<User> getUsers() {
        return ImmutableList.copyOf(users);
    }

    public List<TrainingInstructors> getTrainingInstructors() {
        return trainingInstructors;
    }

    @Override
    public String toString() {
        return "TrainingInstitution{" + "name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TrainingInstitution other = (TrainingInstitution) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
