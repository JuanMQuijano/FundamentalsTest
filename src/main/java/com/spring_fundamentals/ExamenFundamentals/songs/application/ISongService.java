package com.spring_fundamentals.ExamenFundamentals.songs.application;

import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.input.SongDTO;
import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.output.SongDTOOut;
import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.output.SongInfoDTO;

import java.util.List;

public interface ISongService {

    SongDTOOut createOne(SongDTO songEntity);

    List<SongDTOOut> findAll();

    SongInfoDTO findByID(Long id);

    SongDTOOut updateSong(Long id, SongDTO songEntity);

    void deleteSong(Long id);

}
