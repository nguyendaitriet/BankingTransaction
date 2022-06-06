package com.triet.service;

import com.triet.dto.TransferInfoDTO;
import com.triet.model.Customer;
import com.triet.utils.MySQLConnUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransferInfoService implements ITransferInfoService {

    private static final String TRANSFER_INFO_ALL = "SELECT * FROM bankingtransaction.vw_transfer_view;";

    @Override
    public List<TransferInfoDTO> findAll() {
        List<TransferInfoDTO> transferInfoList = new ArrayList<>();
        try {
            Connection connection = MySQLConnUtils.getSqlConnection();
            PreparedStatement statement = connection.prepareStatement(TRANSFER_INFO_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                transferInfoList.add(getTransferInfo(rs));
            }
        } catch (SQLException e) {
            MySQLConnUtils.printSQLException(e);
        }
        return transferInfoList;
    }

    public TransferInfoDTO getTransferInfo(ResultSet rs) throws SQLException {
        long transferId = rs.getLong("transferId");
        long senderId = rs.getLong("senderId");
        String senderName = rs.getString("senderName");
        long recipientId = rs.getLong("recipientId");
        String recipientName = rs.getString("recipientName");
        BigDecimal transferAmount = rs.getBigDecimal("transferAmount");
        int fee = rs.getInt("fees");
        BigDecimal feeAmount = rs.getBigDecimal("feeAmount");
        Date transferDate = rs.getDate("transferDate");
        return new TransferInfoDTO(transferId, senderId, senderName, recipientId, recipientName, transferAmount, fee, feeAmount, transferDate);
    }

    @Override
    public TransferInfoDTO findById(long id) throws SQLException {
        return null;
    }

    @Override
    public boolean save(TransferInfoDTO transferInfoDTO) throws SQLException {
        return false;
    }

    @Override
    public boolean update(TransferInfoDTO transferInfoDTO) throws SQLException {
        return false;
    }

    @Override
    public boolean remove(long id) throws SQLException {
        return false;
    }


}
