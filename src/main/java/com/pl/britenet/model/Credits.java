package com.pl.britenet.model;

import java.util.List;

public class Credits {

    public Integer id;

    public List<CastMember> cast;
    public List<CrewMember> crew;
    public List<CastMember> guest_stars;

    public Credits() {
    }

    public Credits(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CastMember> getCast() {
        return cast;
    }

    public void setCast(List<CastMember> cast) {
        this.cast = cast;
    }

    public List<CrewMember> getCrew() {
        return crew;
    }

    public void setCrew(List<CrewMember> crew) {
        this.crew = crew;
    }

    public List<CastMember> getGuest_stars() {
        return guest_stars;
    }

    public void setGuest_stars(List<CastMember> guest_stars) {
        this.guest_stars = guest_stars;
    }
}
