package kg.charginov.videoservice.model.dto;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class VideoRequest {
    String name;
    LocalDateTime createdAt;
    Long channelId;
}
