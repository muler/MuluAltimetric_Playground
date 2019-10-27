package com.mulu.artist.altimetric.toptrackservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Artist {
    private String name;
    private String ontour;
    private String bio;
}
