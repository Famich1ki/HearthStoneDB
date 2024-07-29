package com.zzb.hearthstoneDB.typeHandler;

import com.zzb.hearthstoneDB.pojo.CardClass;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardClassTypeHandler extends BaseTypeHandler<CardClass> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, CardClass heroType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, heroType.name());
    }

    @Override
    public CardClass getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String name = resultSet.getString(s);
        return name == null ? null : CardClass.valueOf(name);
    }

    @Override
    public CardClass getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String name = resultSet.getString(i);
        return name == null ? null : CardClass.valueOf(name);
    }

    @Override
    public CardClass getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String name = callableStatement.getString(i);
        return name == null ? null : CardClass.valueOf(name);
    }
}
