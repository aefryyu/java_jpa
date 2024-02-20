package masayuki.jpa.listener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import masayuki.jpa.entity.UpdatedAware;

import java.time.LocalDateTime;

public class UpdatedAtListener {

    @PrePersist
    @PreUpdate
    public void setLastUpdatedAt(UpdatedAware object){
        object.setUpdatedAt(LocalDateTime.now());
    }
}
