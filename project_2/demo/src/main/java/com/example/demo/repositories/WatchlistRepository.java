package com.example.demo.repositories;

import com.example.demo.models.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchlistRepository extends JpaRepository<Watchlist, Integer> {

    //@Query(nativeQuery = true, value="Select * from watchlists where user_id=:userId")
    List<Watchlist> findByUserId(int userId);
    List<Watchlist> findByName(String name);
    List<Watchlist> findByUserIdAndName(int userId, String name);
    //List<Watchlist> saveByUserIdAndNameAndMovieId(int userId, String name,String movieId);


    //void saveByUserIdAndNameAndMovie(Watchlist watchlist);
   // Watchlist save(Watchlist watchlist);






    void deleteByUserIdAndMovieId(int userId,String movieId);





}