package com.triet.service;

import com.triet.dto.TransferInfoDTO;
import com.triet.model.Transfer;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface ITransferService extends IGeneralService<Transfer> {
    boolean transfer(BigDecimal amount, long senderId, long recipientId) throws SQLException;
}
