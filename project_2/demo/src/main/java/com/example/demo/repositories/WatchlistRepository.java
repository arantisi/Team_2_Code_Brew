package com.example.demo.repositories;

import com.example.demo.models.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {

    @Query(nativeQuery = true, value="Select * from watchlists where user_id=:userId")
    List<Watchlist> findByUserId(int userId);

}
