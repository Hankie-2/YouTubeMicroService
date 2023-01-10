package kg.charginov.channelservice.repository;

import kg.charginov.channelservice.model.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Long> {

    @Query(value = "SELECT * FROM channel WHERE user_id =?1",nativeQuery = true)
    Channel findChannelByUserId(Long userId);

}
