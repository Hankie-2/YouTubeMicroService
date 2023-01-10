package kg.charginov.channelservice.model.mapper;

import kg.charginov.channelservice.model.dto.ChannelDto;
import kg.charginov.channelservice.model.entity.Channel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChannelMapper extends BaseMapper<Channel, ChannelDto> {

    ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);

}
