package kg.charginov.channelservice.service;

import kg.charginov.channelservice.model.dto.ChannelDto;
import kg.charginov.channelservice.model.dto.ChannelRequest;
import kg.charginov.channelservice.model.entity.Channel;

import java.util.List;

public interface ChannelService {

    ChannelDto findById(Long id);

    ChannelDto save(ChannelRequest request);

    List<ChannelDto> findAll();

    ChannelDto delete(Long id);

    ChannelDto findChannelByUserId(Long userId);

}
