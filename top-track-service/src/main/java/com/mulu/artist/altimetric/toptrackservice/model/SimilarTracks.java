package com.mulu.artist.altimetric.toptrackservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class SimilarTracks {
    private String name;
    private Long playcount;
    private String url;
    private Artist artist;
}
