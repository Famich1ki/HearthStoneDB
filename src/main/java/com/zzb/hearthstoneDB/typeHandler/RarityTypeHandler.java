package com.zzb.hearthstoneDB.typeHandler;

import com.zzb.hearthstoneDB.pojo.Rarity;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RarityTypeHandler extends BaseTypeHandler<Rarity> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Rarity rarity, JdbcType jdbcType) throws SQLException {
        ps.setString(i, rarity.name());
    }

    @Override
    public Rarity getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String name = rs.getString(columnName);
        return name == null ? null : Rarity.valueOf(name);
    }

    @Override
    public Rarity getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String name = rs.getString(columnIndex);
        return name == null ? null : Rarity.valueOf(name);
    }

    @Override
    public Rarity getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String name = cs.getString(columnIndex);
        return name == null ? null : Rarity.valueOf(name);
    }
}
