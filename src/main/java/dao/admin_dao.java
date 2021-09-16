package dao;

import models.admin;

public interface admin_dao {
    void create(admin _admin);
    void update(admin _admin);
    void delete(admin _admin);
    admin read_by_id(int id);
    admin read_by_login(String login);
}
