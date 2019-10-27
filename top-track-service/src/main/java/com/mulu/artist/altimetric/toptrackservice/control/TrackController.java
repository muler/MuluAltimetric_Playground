package com.mulu.artist.altimetric.toptrackservice.control;


import com.mulu.artist.altimetric.toptrackservice.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.mulu.artist.altimetric.toptrackservice.model.Track;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/track")
@Api(value="TrackController", description = "Top Track per Country REST API",tags = "Track Controller")
public class TrackController {

    @Autowired
    TrackService trackService;

    @GetMapping("top/{country}")
    @ApiOperation(value="get top track", notes = "${TrackController.topTrack.notes}")
    @CrossOrigin(origins = {"http://localhost:8080"},
            maxAge = 4800, allowCredentials = "false")
    public Track getTopTrack(@ApiParam(value = "Country Name", required = true) @PathVariable String country) {
        try{
            return trackService.getTopTrack(country);
        }
        catch (JSONException e) {
            return null;
        }

    }

    @GetMapping("top/name/{country}")
    @ApiOperation(value="get top track", notes = "${TrackController.topTrack.notes}")
    @CrossOrigin(origins = {"http://localhost:8080"},
            maxAge = 4800, allowCredentials = "false")
    public String getTopTrackName(@ApiParam(value = "Country Name", required = true) @PathVariable String country) {
        try{
            return trackService.getTopTrackName(country);
        }
        catch (JSONException e) {
            return null;
        }

    }


}
