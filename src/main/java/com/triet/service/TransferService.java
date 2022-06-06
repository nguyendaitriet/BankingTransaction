package com.triet.service;

import com.triet.model.Transfer;
import com.triet.utils.MySQLConnUtils;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TransferService implements ITransferService{
    public static String message;

    @Override
    public boolean transfer(BigDecimal amount, long senderId, long recipientId) throws SQLException {
        Connection connection = MySQLConnUtils.getSqlConnection();
        CallableStatement statement = connection.prepareCall("{CALL sp_transfer_transaction(?, ?, ?, ?, ?)}");
        statement.setBigDecimal(1, amount);
        statement.setLong(2, senderId);
        statement.setLong(3, recipientId);
        statement.execute();
        message = statement.getString(4);
        return statement.getBoolean(5);
    }

    @Override
    public List<Transfer> findAll() {
        return null;
    }

    @Override
    public Transfer findById(long id) throws SQLException {
        return null;
    }

    @Override
    public boolean save(Transfer transfer) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Transfer transfer) throws SQLException {
        return false;
    }

    @Override
    public boolean remove(long id) throws SQLException {
        return false;
    }


}
