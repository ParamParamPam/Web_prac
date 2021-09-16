package services;

import dao.admin_dao;
import dao.impl.admin_dao_impl;
import models.admin;

public class admin_service {

    private admin_dao _admin_dao = new admin_dao_impl();

    public void create_admin(admin _admin) {
        _admin_dao.create(_admin);
    }

    public void update_admin(admin _admin) {
        _admin_dao.update(_admin);
    }

    public void delete_admin(admin _admin) {
        _admin_dao.delete(_admin);
    }

    public admin read_admin_by_id(int id) {
        return _admin_dao.read_by_id(id);
    }

    public admin read_admin_by_login(String login) {
        return _admin_dao.read_by_login(login);
    }


}
