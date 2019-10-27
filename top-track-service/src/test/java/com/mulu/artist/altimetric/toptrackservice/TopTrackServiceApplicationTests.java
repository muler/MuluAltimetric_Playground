package com.mulu.artist.altimetric.toptrackservice;

import com.mulu.artist.altimetric.toptrackservice.service.TrackService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class TopTrackServiceApplicationTests {

    @Autowired
    private TrackService trackService;
    @Test
    void checkTrackName() {

        String trackName = "Hello";
        String countryName = "Uganda";
        String topTrackName =  trackService.getTopTrackName(countryName);
        assertThat(trackName.equals(topTrackName));
    }

}
