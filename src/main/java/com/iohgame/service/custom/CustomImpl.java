package com.iohgame.service.custom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import com.iohgame.framework.utility.Utility;
import com.iohgame.framework.utility.parameters.constant.ConstDatetime;
import com.iohgame.service.custom.CustomInfoDao.CustomGender;
import com.iohgame.service.custom.CustomInfoDao.OpenLevel;
import com.iohgame.service.property.mysql.property.ServerDBI;

public class CustomImpl extends ServerDBI implements Custom
{
    @Override
    public Map<Integer, CustomInfoDao> selectCustomInfo()
    {
        LOG.info("Select custom login info");

        Map<Integer, CustomInfoDao> list = new TreeMap<>();
        ResultSet result = slave().query("SELECT l.custom_id, l.custom_login_name," + //
                " l.custom_tele_flg, l.custom_tele_number, l.custom_mail_flg, l.custom_mail_address," + //
                " i.custom_nick, i.custom_gender, i.custom_birth, i.confirm_flg, i.open_level" + //
                " FROM custom_login l LEFT OUTER JOIN custom_info i ON i.custom_id = l.custom_id" + //
                " WHERE i.del_flg = 0 AND l.del_flg = 0"//
        );
        try
        {
            while (result.next())
            {
                CustomInfoDao dao = new CustomInfoDao.ContainerBuilder() //
                        .customId(Utility.toInteger(result.getString("custom_id"))) //
                        .customLoginName(result.getString("custom_login_name")) //
                        .customHasTel(judge(result.getString("custom_tele_flg"))) //
                        .customTelNumber(result.getString("custom_tele_number")) //
                        .customHasMail(judge(result.getString("custom_mail_flg"))) //
                        .customMailAddr(result.getString("custom_mail_address")) //
                        .customNick(result.getString("custom_nick")) //
                        .customGender(Utility.getEnum(result.getString("custom_gender"), CustomGender.class)) //
                        .customBirth(Utility.toDate(result.getString("custom_birth"), ConstDatetime.DATE)) //
                        .customHasConfirm(judge(result.getString("confirm_flg"))) //
                        .customOpenLevel(Utility.getEnum(result.getString("open_level"), OpenLevel.class)) //
                        .build();
                list.put(dao.customId(), dao);
            }
        }
        catch (SQLException e)
        {
            LOG.error(e.getMessage());
        }
        slave().free();

        return list;
    }

    @Override
    public Map<Integer, CustomPassword> selectCustomPassword()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
