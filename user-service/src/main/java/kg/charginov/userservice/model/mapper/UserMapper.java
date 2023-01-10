package kg.charginov.userservice.model.mapper;

import kg.charginov.userservice.model.dto.UserDto;
import kg.charginov.userservice.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<User, UserDto> {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

}
