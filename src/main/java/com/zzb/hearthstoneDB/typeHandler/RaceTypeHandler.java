package com.zzb.hearthstoneDB.typeHandler;

import com.zzb.hearthstoneDB.pojo.Race;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RaceTypeHandler extends BaseTypeHandler<Race> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Race race, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, race.name());
    }

    @Override
    public Race getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String name = resultSet.getString(s);
        return name == null ? null : Race.valueOf(name);
    }

    @Override
    public Race getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String name = resultSet.getString(i);
        return name == null ? null : Race.valueOf(name);
    }

    @Override
    public Race getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String name = callableStatement.getString(i);
        return name == null ? null : Race.valueOf(name);
    }
}
