package kg.charginov.channelservice.model.dto;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ChannelDto {
    Long id;

    Long userId;

    String name;

    LocalDateTime createdAt;
}
