package masayuki.jpa.entity;

import java.time.LocalDateTime;

public interface UpdatedAware {

    void setUpdatedAt(LocalDateTime updatedAt);
}
