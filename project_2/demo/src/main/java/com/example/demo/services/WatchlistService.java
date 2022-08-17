package com.example.demo.services;

import com.example.demo.models.Watchlist;
import com.example.demo.repositories.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class WatchlistService {

    @Autowired
    private WatchlistRepository watchlistRepo;

    public List<Watchlist> getWatchlistByUser(int userId) {
        return watchlistRepo.findByUserId(userId);
    }

    public List<Watchlist> getAllWatchlists() {
        return watchlistRepo.findAll();
    }

    public List<Watchlist> getWatchlistByName(int userId, String watchName) {
        return watchlistRepo.findByName(userId, watchName);
    }


}
