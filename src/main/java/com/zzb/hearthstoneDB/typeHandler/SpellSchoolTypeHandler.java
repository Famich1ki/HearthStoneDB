package com.zzb.hearthstoneDB.typeHandler;

import com.zzb.hearthstoneDB.pojo.SpellSchool;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpellSchoolTypeHandler extends BaseTypeHandler<SpellSchool> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SpellSchool spellSchool, JdbcType jdbcType) throws SQLException {
        ps.setString(i, spellSchool.name());
    }

    @Override
    public SpellSchool getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String name = rs.getString(columnName);
        return name == null ? null : SpellSchool.valueOf(name);
    }

    @Override
    public SpellSchool getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public SpellSchool getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
