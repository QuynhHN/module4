package com.example.song.dto;



import javax.validation.constraints.*;

public class SongDTO {
    private Integer id;
    @NotEmpty(message = "can not be blank or space")
    @Size(max = 800, min = 1, message = "Do not enter more than 800 characters")
    @Pattern(regexp = "^((?=[A-Za-z0-9,])(?![_\\\\\\\\-]).)*$",  message = "Do not enter more than 800 characters")
    private String name;
    @NotNull(message = "can not be blank or space")
    @Size(max = 300,min = 1, message = "Do not enter more than 300 characters")
    @Pattern(regexp = "^((?=[A-Za-z0-9,])(?![_\\\\\\\\-]).)*$",  message = "Do not enter more than 800 characters")
    private String singer;
    @NotNull(message = "can not be blank or space")
    @Size(max = 1000,min = 1, message = "Do not enter more than 1000 characters")
    @Pattern(regexp = "^((?=[A-Za-z0-9,])(?![_\\\\\\\\-]).)*$",  message = "Do not enter more than 800 characters")
    private String type;

    public SongDTO() {
    }

    public SongDTO(Integer id, String name, String singer, String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}