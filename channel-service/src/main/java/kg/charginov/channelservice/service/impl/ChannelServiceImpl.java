package kg.charginov.channelservice.service.impl;

import kg.charginov.channelservice.exception.ChannelIsExistsException;
import kg.charginov.channelservice.exception.ChannelNotFoundException;
import kg.charginov.channelservice.model.dto.ChannelDto;
import kg.charginov.channelservice.model.dto.ChannelRequest;
import kg.charginov.channelservice.model.dto.User;
import kg.charginov.channelservice.model.entity.Channel;
import kg.charginov.channelservice.model.mapper.ChannelMapper;
import kg.charginov.channelservice.repository.ChannelRepository;
import kg.charginov.channelservice.service.ChannelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private final RestTemplate restTemplate;

    private final ChannelRepository repository;

    private final String USER_SERVICE_URL = "http://localhost:7070/user-service/user/";

    @Override
    public ChannelDto findById(Long id) {
        return ChannelMapper.INSTANCE
                .toDto(repository.findById(id)
                        .orElseThrow( () -> new ChannelNotFoundException("Не нашли канал с ID '" + id + "'",404)));
    }

    @Override
    public ChannelDto save(ChannelRequest request) {
        Channel channel = Channel.builder()
                .name(request.getName())
                .createdAt(LocalDateTime.now())
                .userId(request.getUserId())
                .build();

        User user = restTemplate.exchange(USER_SERVICE_URL+request.getUserId(), HttpMethod.GET,null,User.class).getBody();

        if((repository.findChannelByUserId(request.getUserId())!=null) && user==null){
            throw new ChannelIsExistsException("У пользователя '" + user.getUsername() + "' уже есть канал!",405);
        }

        log.info(channel + ": saved to database!");
        return ChannelMapper.INSTANCE.toDto(repository.save(channel));
    }

    @Override
    public List<ChannelDto> findAll() {
        return ChannelMapper.INSTANCE.toDtoList(repository.findAll());
    }

    @Override
    public ChannelDto delete(Long id) {
        ChannelDto channel = findById(id);
        if(channel==null){
            throw new ChannelNotFoundException("Не нашли канал с ID '" + id + "'",404);
        }
        repository.deleteById(id);
        return channel;
    }

    @Override
    public ChannelDto findChannelByUserId(Long userId) {
        return ChannelMapper.INSTANCE.toDto(repository.findChannelByUserId(userId));
    }
}