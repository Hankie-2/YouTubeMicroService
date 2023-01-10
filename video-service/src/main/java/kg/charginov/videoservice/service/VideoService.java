package kg.charginov.videoservice.service;

import kg.charginov.videoservice.model.dto.VideoDto;
import kg.charginov.videoservice.model.dto.VideoRequest;

import java.util.List;

public interface VideoService {

    VideoDto findVideoById(Long id);

    VideoDto save(VideoRequest request);

    VideoDto delete(Long id);

    List<VideoDto> findAll();

}
