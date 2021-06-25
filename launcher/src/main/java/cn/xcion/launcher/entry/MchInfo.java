package cn.xcion.launcher.entry;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Author: Kern
 * E-mail: sky580@126.com
 * DateTime: 2021/6/26  01:37
 * Intro:
 */
@Entity(tableName = "mck_info")
@Dao
public abstract class MchInfo {

    private String login;
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String node_id;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }
}
