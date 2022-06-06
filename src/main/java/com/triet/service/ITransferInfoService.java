package com.triet.service;

import com.triet.dto.TransferInfoDTO;

import java.util.List;

public interface ITransferInfoService extends IGeneralService<TransferInfoDTO>{
    @Override
    List<TransferInfoDTO> findAll();
}
