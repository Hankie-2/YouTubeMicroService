package kg.charginov.videoservice.repository;

import kg.charginov.videoservice.model.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video,Long> {

    @Query(nativeQuery = true,value = "SELECT * FROM video WHERE channel_id =?1")
    Video findVideoByChannelId(Long channelId);

}
