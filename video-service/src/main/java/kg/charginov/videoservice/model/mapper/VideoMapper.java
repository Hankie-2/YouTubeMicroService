package kg.charginov.videoservice.model.mapper;

import kg.charginov.videoservice.model.dto.VideoDto;
import kg.charginov.videoservice.model.entity.Video;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VideoMapper extends BaseMapper<Video, VideoDto>{

    VideoMapper INSTANCE = Mappers.getMapper(VideoMapper.class);

}
