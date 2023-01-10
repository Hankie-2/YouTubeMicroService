package kg.charginov.videoservice.service.impl;

import kg.charginov.videoservice.exception.VideoNotFoundException;
import kg.charginov.videoservice.model.dto.Channel;
import kg.charginov.videoservice.model.dto.VideoDto;
import kg.charginov.videoservice.model.dto.VideoRequest;
import kg.charginov.videoservice.model.entity.Video;
import kg.charginov.videoservice.model.mapper.VideoMapper;
import kg.charginov.videoservice.repository.VideoRepository;
import kg.charginov.videoservice.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final VideoRepository repository;

    @Autowired
    private final RestTemplate restTemplate;

    private final String CHANNEL_SERVICE_URL = "http://localhost:7070/channel-service/channel/";

    @Override
    public VideoDto findVideoById(Long id) {
        return VideoMapper.INSTANCE
                .toDto(repository.findById(id)
                        .orElseThrow( () -> new VideoNotFoundException("Нет видео с ID '" + id + "'",404)));
    }

    @Override
    public VideoDto save(VideoRequest request) {
        Video video = Video.builder()
                .channelId(request.getChannelId())
                .createdAt(LocalDateTime.now())
                .name(request.getName())
                .build();

        Channel channel = restTemplate.exchange(CHANNEL_SERVICE_URL+request.getChannelId(), HttpMethod.GET,null,Channel.class).getBody();

        if(channel == null){
            throw new VideoNotFoundException("Канал не найден",404);
        }

        return VideoMapper.INSTANCE.toDto(repository.save(video));
    }

    @Override
    public VideoDto delete(Long id) {
        VideoDto video = findVideoById(id);
        if(video==null){
            throw new VideoNotFoundException("Не нашли видео с ID '" + id + "'",404);
        }
        repository.deleteById(id);
        return VideoMapper.INSTANCE.toDto(VideoMapper.INSTANCE.toEntity(video));
    }

    @Override
    public List<VideoDto> findAll() {
        return VideoMapper.INSTANCE.toDtoList(repository.findAll());
    }
}
