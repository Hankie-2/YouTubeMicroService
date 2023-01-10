package kg.charginov.userservice.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserDto {
    Long id;

    String username;

    String password;
}
