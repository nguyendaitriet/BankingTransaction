package com.triet.service;

import com.triet.model.Transfer;

import java.math.BigDecimal;
import java.sql.SQLException;

public interface ITransferService extends IGeneralService<Transfer> {
    boolean transfer(BigDecimal amount, long senderId, long recipientId) throws SQLException;
}
