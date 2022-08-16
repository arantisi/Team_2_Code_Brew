package com.security.practice.services;

import com.security.practice.models.Watchlist;
import com.security.practice.repos.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WatchlistService {

    @Autowired
    private WatchlistRepository watchlistRepo;

    public List<Watchlist> getWatchlistByUserId(int userId) {
        return watchlistRepo.findByUserId(userId);
    }

    public List<Watchlist> getWatchlistByName(String name) {
        return watchlistRepo.findByName(name);
    }

    public List<Watchlist> getWatchlistByUserIdAndName(int userId,String name) {
        return watchlistRepo.findByUserIdAndName(userId,name);
    }

    public List<Watchlist> getAllWatchlists() {
        return watchlistRepo.findAll();
    }

    public void deleteWatchlistByUserIdAndMovieId(int userId,String movieId) {
        watchlistRepo.deleteByUserIdAndMovieId(userId,movieId);
    }



    public void postSaveWatchlist(Watchlist watchlist)
    {
        watchlistRepo.save(watchlist);
    }

    public void addToWatchlist(Watchlist watchlist)
    {
        watchlistRepo.save(watchlist);
    }




}