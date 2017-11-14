package com.clem.narakaistudio.controller;

import com.clem.narakaistudio.bean.response.Video;
import com.clem.narakaistudio.job.RedisSourceManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Silence on 2016/11/11.
 */
@Controller
@AllArgsConstructor
public class IndexController {

    private final static String[] TAGS = {"QQ", "PANDA"};

    private final RedisSourceManager redisSourceManager;

    /**
     * 首页
     */
    @GetMapping("/")
    public String home(Model model) {
        List<Video> carouselPics = redisSourceManager.getVideosByKeyAndTag(redisSourceManager.VIDEO_PREFIX_HOME_CAROUSEL_KEY, TAGS[0]);
        List<Video> recommends = redisSourceManager.getVideosByKeyAndTag(redisSourceManager.VIDEO_PREFIX_HOME_RECOMMEND_KEY, TAGS[0]);
        List<Video> tvHots = redisSourceManager.getVideosByKeyAndTag(redisSourceManager.VIDEO_PREFIX_HOME_TV_KEY, TAGS[0]);
        List<Video> animeHots = redisSourceManager.getVideosByKeyAndTag(redisSourceManager.VIDEO_PREFIX_HOME_CARTOON_KEY, TAGS[0]);
        List<Video> movies = redisSourceManager.getVideosByKeyAndTag(redisSourceManager.VIDEO_PREFIX_HOME_MOVIE_KEY, TAGS[0]);
        model.addAttribute("carouselPics", carouselPics);
        model.addAttribute("recommends", recommends);
        model.addAttribute("tvHots", tvHots);
        model.addAttribute("animeHots", animeHots);
        model.addAttribute("movies", movies);
        return "index";
    }
}